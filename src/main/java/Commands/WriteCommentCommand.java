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
public class WriteCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        String comment = request.getParameter("comment");
        int artID = Integer.parseInt(request.getParameter("artID"));
        try {
            Object Value2 = session.getAttribute("CurrentUser");
            Users successUser = (Users) Value2;
            int id = successUser.getUserID();
            CommentsDao comDao = new CommentsDao("swgw");
            boolean action = comDao.setComment(artID, id, comment);
            if (action == true) {

                session.setAttribute("commentSuccess", "comment");
                forwardToJsp = "index.jsp";
            }
        } catch (InputMismatchException e) {

            forwardToJsp = "error.jsp";

            session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
        }
        return forwardToJsp;
    }
}
