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

public class DeleteCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("commID"));
        int artID = Integer.parseInt(request.getParameter("artID"));
        try {
            CommentsDao cDao = new CommentsDao("swgw");

            boolean action = cDao.deleteComment(id);
            if (action == true) {
                forwardToJsp = ("viewArticle.jsp?article="+artID);
            }
        } catch (InputMismatchException e) {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Text was supplied for parameters is not the right type.");
        }
        return forwardToJsp;
    }
}
