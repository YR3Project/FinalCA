/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

https://www.tutorialspoint.com/servlets/servlets-file-uploading.htm
 */
package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
     
    // database connection settings
    private final String dbURL = "jdbc:mysql://localhost:3306/swgw";
    private final String dbUser = "root";
    private final String dbPass = "";
     
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String forwardToJsp = "";
        
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        String ID = request.getParameter("id");
        int id = Integer.parseInt(ID);
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        
        else if(filePart == null)
        {
            //didnt work
        }
         
        Connection conn = null; // connection to the database
       
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "UPDATE users SET photo = ? Where userID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column and the id to point where to put it
                statement.setBlob(1, inputStream);
                statement.setInt(2, id);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) 
            {
                String msg = "Successful changed profile Picture";
                          session.setAttribute("EditSuccess", msg); 
                          
                          forwardToJsp = "viewProfile.jsp";
                
            }
            else if( row <= 0)
            {
                String msg = "Profile Picture Change was Unsuccessful";
                          session.setAttribute("EditSuccess", msg); 
                          
                          forwardToJsp = "viewProfile.jsp";
            }
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        response.sendRedirect(forwardToJsp);
    }
}