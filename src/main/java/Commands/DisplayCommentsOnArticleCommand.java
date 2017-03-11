/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import Daos.*;
import Dtos.*;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.NoSuchProviderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Chris
 */
public class DisplayCommentsOnArticleCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        
            String getArticleID = request.getParameter("articleID");
            
            if(getArticleID != null)
            {
                try
                {
                    HttpSession session = request.getSession();
                    
                    CommentsDao comDao = new CommentsDao("finaltestproject");
                    
                    int ArticleID = Integer.parseInt(getArticleID);
                    
                    
                }catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";
                        
                        HttpSession session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
            }
        
        return forwardToJsp;
    }
    
}
