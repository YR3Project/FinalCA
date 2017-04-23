/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.*;
import Dtos.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


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
import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ProxyConfig;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.simplejavamail.util.ConfigLoader;

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
                       
                       
                        //Check that it doesn't contain AND or NOT removed lower case ones 
                        //since where cause problems with passwords like LegendandStrike45 as a example. 
                        boolean noConditions = !(Password.contains("AND") || Password.contains("NOT")); //|| Password.contains("not") || Password.contains("and"))
                        boolean noUsername = !(Password.contains(UserName));
                        boolean noSpaces = !(UserName.contains(" "));// No Spaces in username
                        boolean noPassword1 = !(Password.contains("Password1"));
                        
                        if(UserName.length() < 3){
                             String error = "Your UserName must be atleast more than 2 in Length";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                        }
                        
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
                         
                         if(!noSpaces)
                         {
                            String error = "Your Username must not contain Spaces";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                         }
                         if(!noPassword1)
                         {
                           String error = "Your Password must not contain Password1 try to think of better passwords";
                           session.setAttribute("Complexity", error);
                           forwardToJsp = "RegRetry.jsp";
                         }
                         

                        UsersDao userDao = new UsersDao("swgw");

                        
                        boolean Checkemail = false;
                        boolean Checkname = false;
                                
                        ArrayList<Users> Accounts = userDao.GetAllUsers();
                        
                        for(int x = 0; x < Accounts.size(); x++)
                        {
                            if(Email.equals(Accounts.get(x).getEmail()))
                            {
                                Checkemail = true;
                            }
                           
 
                        }
                        
                        for(int x = 0; x < Accounts.size(); x++)
                        {
                         if(UserName.equals(Accounts.get(x).getUserName()))
                            {
                                Checkname = true;
                            }
                            
                        }
                        if(Structure && noConditions && noUsername && noSpaces &&  Checkemail == false && Checkname == false)
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
                          session.setAttribute("PicId", user);
                          
                  
                          forwardToJsp = "registrationSuccessful.jsp"; 
                        String EmailName = "E:\\Proj1\\SWGW-G02 - III stooges\\FinalCA\\src\\main\\EmailDetails\\EmailName.txt";
                        String EmailPassword = "E:\\Proj1\\SWGW-G02 - III stooges\\FinalCA\\src\\main\\EmailDetails\\EmailPassword.txt";
                        final String username = readFileInputStream(EmailName);
                        final String password = readFileInputStream(EmailPassword);

                        Properties props = new Properties();
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

                        Session mailsession;
                        mailsession = Session.getInstance(props, new javax.mail.Authenticator() {
                         @Override
                         protected PasswordAuthentication getPasswordAuthentication() {
                             return new PasswordAuthentication(username, password);
                         }
                     });

                        try {

                                Message message = new MimeMessage(mailsession);
                                message.setFrom(new InternetAddress(username));
                                message.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(Email));
                                message.setSubject("Registered Account");
                                message.setText("Dear New Member,"
                                        + "\n\n Welcome to StatWiseGameWise!" + "\n\n We hope you enjoy your time on our site" + "\n\n Heres your password - " + Password);

                                Transport.send(message);



                        } catch (MessagingException e) {
                                throw new RuntimeException(e);
                        }
                                
                       }
                       else if(Action == false)
                       {
                            String msg = " Registration ";
                            session.setAttribute("Type", msg);
                            session.setAttribute("AccountFail", UserName); 
                           
                            
                            forwardToJsp = "AccountFail.jsp";
                       }
                       
                     }
                        else if(Checkemail == true)
                       {
                         String error = "Your Email Already exists ";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";  
                       }
                        else if(Checkname == true)
                        {
                          String error = "Your Username Already in use ";
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
                           }  catch (IOException ex) {
                
                            } catch (NoSuchProviderException ex) {
                Logger.getLogger(RegisterCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
                }else
                {
                    
                    forwardToJsp = "error.jsp";
                    
                    HttpSession session = request.getSession();

                    
                    session.setAttribute("errorMessage", "A parameter value required for Registration was missing");
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
    
    private static String readFileInputStream(String filename) throws IOException {
        
        String sContent=null;
        byte [] buffer =null;
        File a_file = new File(filename);
        try
        {
        FileInputStream fis = new FileInputStream(filename);
        int length = (int)a_file.length();
        buffer = new byte [length];
        fis.read(buffer);
        fis.close();
        }
        catch(IOException e)
        {
        }
        sContent = new String(buffer);
        return sContent;
        }
    
                    
}
