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

public class EditArticleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String game = request.getParameter("game");
        int id = Integer.parseInt(request.getParameter("artID"));
        
         if (content != null && title != null &&  game != null && !content.equals("") && !title.equals("") && !game.equals(""))
             {
        try {
            ArticleDao aDao = new ArticleDao("swgw");

            boolean action = aDao.EditArticle(id, title, game, content);
            if (action == true) {
                forwardToJsp = ("viewArticle.jsp?article="+id);
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
