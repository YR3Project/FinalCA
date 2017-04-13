
package Commands;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ben
 */
public class ProfilePicCommand implements Command {
     /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "Profiles";

     
    // database connection settings
    private final String dbURL = "jdbc:mysql://localhost:3306/swgw";
    private final String dbUser = "root";
    private final String dbPass = "";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

    
        // gets absolute path of the web application
        String appPath = "E:\\Proj1\\SWGW-G02 - III stooges\\FinalCA\\src\\main\\webapp\\Images";
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.getParentFile().mkdirs();
        }
        
        String ID = request.getParameter("id");
        String datapath = null;
        try{
        for (Part part : request.getParts()) {
            
            String fileName = extractFileName(part);
            String NewfileName = fileName.replaceAll(fileName.substring(0, fileName.indexOf(".")), ID);
            // refines the fileName in case it is an absolute path
            NewfileName = new File(NewfileName).getName();
            part.write(savePath + File.separator + NewfileName);
           datapath = "Images/Profiles/" + NewfileName;
        }
       }catch(StringIndexOutOfBoundsException ex)
       {
           
       } catch (IOException ex) {
            Logger.getLogger(ProfilePicCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ProfilePicCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
   HttpSession session = request.getSession();
        String forwardToJsp = "";

        
        // obtains the upload file part in this multipart request
        int id = Integer.parseInt(ID);

         
        Connection conn = null; // connection to the database
       
         
        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            // constructs SQL statement
            String sql = "UPDATE users SET photo = ? Where userID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

           
                // fetches input FilePath for the  column and the id to point where to put it
                statement.setString(1, datapath);
                statement.setInt(2, id);

 
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
        return forwardToJsp;
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
    }

