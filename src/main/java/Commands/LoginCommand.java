/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.UsersDao;
import Dtos.Users;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Author Ben
 */
public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
                String forwardToJsp = "";
        
                String Entry1 = request.getParameter("userName");
                String Password = request.getParameter("password");
                String UserName = null;
                //ChrisTest
                if (Entry1 != null && Password != null && !Entry1.equals("") && !Password.equals(""))
                {
                    try
                    {
                        HttpSession session = request.getSession();
                        UsersDao userDao = new UsersDao("swgw");
                        //this is so they can use there email as well as the username.
                        if(Entry1.contains("@")){
                          UserName = userDao.GetName(Entry1);
                        }
                        else if(!Entry1.contains("@")){
                          UserName = Entry1;
                        }
                        Users one = userDao.getUserbyName(UserName);
                        String Duedate = one.getDue();
                        DateFormat df = new SimpleDateFormat("dd/MM/yy");
                        Date createdate = new Date();
                        if(Duedate.equals(df.format(createdate)))
                        {
                            String msg ="Your Password has gone passed the expire date please change it";
                           session.setAttribute("Expired", msg);   
                           forwardToJsp = "ChangePassword.jsp"; 
                        }
                        else if(!(Duedate.equals(df.format(createdate)))){
                        
                         byte[] salt = userDao.GetCAlSalt(UserName);
                            
                        MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			byte[] bytes = md.digest(Password.getBytes());
			
                        StringBuilder sb = new StringBuilder();
			
                        for(int i=0; i< bytes.length ;i++)
			{
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String generatedPassword = sb.toString();
                        
                        
                        
                        Users result = userDao.LogingInUser(UserName, generatedPassword);

                            if(result != null)
                            {
                              session.setAttribute("CurrentUser", result);
                              forwardToJsp = "index.jsp";     
                            }
                            else if(result == null)
                            {
                                
                                String msg = "Login";
                                session.setAttribute("Type", msg);
                                session.setAttribute("AccountFail", UserName);  
                                forwardToJsp = "AccountFail.jsp";
                            }
                       
                    }
                    
                    } 
                    catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";
                        
                        HttpSession session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
                    catch (NoSuchAlgorithmException ex) {
                            forwardToJsp = "error.jsp";
                            
                            HttpSession session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Something has gone wrong with encrpting/hashing the password");
                        }
                } else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    HttpSession session = request.getSession();

                    
                    session.setAttribute("errorMessage", "A parameter value required for login was missing");
                }
                
                return forwardToJsp;
    } 
}
