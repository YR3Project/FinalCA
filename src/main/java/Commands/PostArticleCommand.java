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

public class PostArticleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();

        
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            String game = request.getParameter("game");
            
            if (content != null && title != null &&  game != null && !content.equals("") && !title.equals("") && !game.equals(""))
             {
            
         try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date date = new Date();
            Object Value = session.getAttribute("CurrentUser");
            Users successUser = (Users) Value;
            int id = successUser.getUserID();
            ArticleDao aDao = new ArticleDao("swgw");

            boolean action = aDao.PostArticle(id, title, title, game);
            if (action == true) {

                session.setAttribute("articleSuccess", "article");
                forwardToJsp = "index.jsp";
            }
        } catch (InputMismatchException e) {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Text was supplied for parameters is not the right type.");
        }
        
       }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    session.setAttribute("errorMessage", "A parameter value required for Articles was missing");
                }
        return forwardToJsp;
    }
}
