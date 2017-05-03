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

public class ReportCommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("commID"));
        int artID = Integer.parseInt(request.getParameter("artID"));
        Object Value = session.getAttribute("CurrentUser");
            Users successUser = (Users) Value;
            int reporter = successUser.getUserID();
        try {
            ReportDao rDao = new ReportDao("swgw");

            boolean action = rDao.fileReport(id, reporter);
            if (action == true) {
                forwardToJsp = ("viewArticle.jsp?article="+artID);
            }else {
                forwardToJsp = ("viewArticle.jsp?article="+artID);
            }
        } catch (InputMismatchException e) {

            forwardToJsp = ("viewArticle.jsp?article="+artID);

            session.setAttribute("errorMessage", "Text was supplied for parameters is not the right type.");
        }
        return forwardToJsp;
    }
}
