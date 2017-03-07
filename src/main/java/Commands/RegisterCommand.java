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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
Author Ben
*/

public class RegisterCommand implements Command{
    
    
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

                String UserName = request.getParameter("userName");
                String Password = request.getParameter("password");
                String Email = request.getParameter("email");
                

                if (UserName != null && Password != null && !UserName.equals("") && !Password.equals("") && !Email.equals(""))
                {
                    try
                    {
                        
                       HttpSession session = request.getSession();
                       
                       boolean Structure = Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
                       /*
                        boolean isAtLeast8 = Password.matches("^*.{8,}$");
                        boolean hasUppercase = Password.matches("^?=.*?[A-Z]$");
                        boolean hasLowercase = Password.matches("^?=.*?[a-z]$");
                        boolean hasNumeric = Password.matches("^?=.*?[0-9]$");
                        boolean hasNoSpaces = !Password.contains(" ");
                       */
                       
                        //Check that it doesn't contain AND or NOT removed lower case ones 
                        //since where cause problems with passwords like LegendandStrike45 as a example. 
                        boolean noConditions = !(Password.contains("AND") || Password.contains("NOT")); //|| Password.contains("not") || Password.contains("and"))
                        boolean noUsername = !(Password.contains(UserName));
                        
                        if(!Structure){
                            String error = "Your Password must be atleast more than 8 in Length, one Digit, "
                                    + "one Upper-Case, one Lower-case and no Spaces";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                        if(!noConditions){
                            String error = "Your Password must not contain any conditions e.g AND/OR";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                         if(!noUsername){
                            String error = "Your Password must not contain Your UserName";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        /*
                        if(!isAtLeast8){
                            String error = "Your Password is too Short must be more than 6 Characters";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                             }
                        
                
                        if(!hasUppercase) {
                            String error = "Your Password must contain one Uppercase letter";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                
                        if(!hasLowercase){
                            String error = "Your Password must contain one owercase letter";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                        if(!hasNumeric){
                            String error = "Your Password must contain Numbers";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                        }
                
                        if(!hasNoSpaces){
                            String error = "Your Password must not contain any Spaces";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                
                        if(!noConditions){
                            String error = "Your Password must not contain any conditions e.g AND/OR";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                        if(!noUsername){
                            String error = "Your Password must not contain Your UserName";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                        
                       
                       if(isAtLeast8 && hasUppercase && hasLowercase && hasNoSpaces && noConditions && noUsername)
                       */
                        UsersDao userDao = new UsersDao("swgw");

                        
                        boolean Checkemail = true;
                                
                        ArrayList<Users> Accounts = userDao.GetAllUsers();
                        
                        for(int x = 0; x < Accounts.size(); x++)
                        {
                            if(Email.equals(Accounts.get(x).getEmail()))
                            {
                                Checkemail = true;
                            }
                            else
                            {
                               Checkemail = false;
                            }
                            
                        }
                        
                        
                        if(Structure && noConditions && noUsername && Checkemail == false)
                        {
                        byte[] salt = getSalt();
                            
                        MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			byte[] bytes = md.digest(Password.getBytes());
			
                        StringBuilder sb = new StringBuilder();
			
                        for(int i=0; i< bytes.length ;i++)
			{
                            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			String generatedPassword = sb.toString();

                            
                       
                       DateFormat df = new SimpleDateFormat("dd/MM/yy");
                       Date createdate = new Date();
                       Date expiredate = new Date();
                       Calendar c = Calendar.getInstance(); 
                        c.setTime(createdate); 
                        c.add(Calendar.DATE, 10);
                        expiredate = c.getTime();
                       
                       boolean Action = userDao.RegisterUser(UserName, generatedPassword, Email, salt, df.format(createdate), df.format(expiredate));
                       
                       if(Action == true){
                           
                           Users user = userDao.getUserbyName(UserName);
                          session.setAttribute("RegSuccess", user); 
                          
                          forwardToJsp = "registrationSuccessful.jsp"; 
                           
                           /*
                        // Recipient's email ID needs to be mentioned.
                        String to = "ben.rose76@gmail.com";//change accordingly

                        // Sender's email ID needs to be mentioned
                        String from = "statwisegamewise@yahoo.com";//change accordingly
                        final String eusername = "statwisegamewise@yahoo.com";//change accordingly
                        final String epassword = "Finalcaproject";//change accordingly

                        // Assuming you are sending email through relay.jangosmtp.net
                        String host = "smtp.mail.yahoo.com";

                        Properties props = new Properties();
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", host);
                        props.put("mail.smtp.port", "465");

                        // Get the Session object.
                        Session emailsession = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(eusername, epassword);
                        }
                    });

                try {
                         // Create a default MimeMessage object.
                        Message message = new MimeMessage(emailsession);

                        // Set From: header field of the header.
                        message.setFrom(new InternetAddress(from));

                        // Set To: header field of the header.
                        message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(to));

                        // Set Subject: header field
                        message.setSubject("Testing Subject");

                        // Now set the actual message
                        message.setText("Hello, this is sample for to check send "
                        + "email using JavaMailAPI ");

                        // Send message
                        Transport.send(message);



                    } catch (MessagingException mex) {
                                mex.printStackTrace();
                    }
                          
                            String msg = "Check your Email For confirmation of account";
                            session.setAttribute("ChangeSuccess", msg); 
                          
                            forwardToJsp = "LoginForm.jsp";
                            */

                       }
                       else if(Action == false)
                       {
                            String msg = " Registration ";
                            session.setAttribute("Type", msg);
                            session.setAttribute("AccountFail", UserName); 
                           
                            
                            forwardToJsp = "AccountFail.jsp";
                       }
                       
                     }
                     else
                       {
                         String error = "Your Email Already exists ";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";  
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
                               
                               session.setAttribute("errorMessage", "Something has gone wrong with hashing your password");
                           } catch (NoSuchProviderException ex) {
                                Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                
                return forwardToJsp;
    }

    private byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		//Create array for salt
		byte[] salt = new byte[16];
		//Get a random salt
		sr.nextBytes(salt);
		//return salt
		return salt;
    }
    
                    
}
