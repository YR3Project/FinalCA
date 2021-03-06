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

/*
Author Ben
*/

public class SetCommentCommand implements Command{   

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        
        HttpSession session = request.getSession();
        String comment = request.getParameter("comment");
        String id = request.getParameter("userID");
        String article = request.getParameter("article");
        String date = request.getParameter("date");
        String commentID = request.getParameter("commentID");
        if (comment != null && article != null &&  date != null && !comment.equals("") && !article.equals("") && !date.equals(""))
             {
        try
        {
            int trueID = Integer.parseInt(id);
            int trueArticle = Integer.parseInt(article);
            int commentI = Integer.parseInt(commentID);
            
            CommentsDao comDao = new CommentsDao("swgw");
            
            boolean action = comDao.setComment(trueID, trueID, commentID);
            if(action == true)
            {
                
                session.setAttribute("commentSuccess", "comment");
                forwardToJsp = "index.jsp";
            }
        }
        catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";
                        
                        session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
             }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    session.setAttribute("errorMessage", "A parameter value required for Commenting was missing");
                }
        return forwardToJsp;
    }
}
