
package Commands;
import Daos.UsersDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

//Author Ben
public class ForgotCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
                HttpSession session = request.getSession();
                
                String UserName = request.getParameter("userName");

                
                if(UserName.equals(""))
                {
                    String msg = "you cannot leave any of the entries empty";
                    session.setAttribute("ChangeError", msg);
                    forwardToJsp = "ChangeError.jsp";
                }
                else if(!(UserName.equals(""))){
                
                
                    
   
                       UsersDao userDao = new UsersDao("swgw");
                       String Email = userDao.GetEmail(UserName);
                      
                       if(Email != null){
                           
                          session.setAttribute("ChangeSuccess", "Check Email To Continue"); 
                          session.removeAttribute("CurrentUser");
                          session.setAttribute("UserName", UserName);
                          session.setAttribute("Email", Email);
                          forwardToJsp = "LoginForm.jsp";
                        try{  
                        String EmailName = "E:\\Back-Ups\\mk6\\FinalCA\\src\\main\\EmailDetails\\EmailName.txt";
                        String EmailPassword = "E:\\Back-Ups\\mk6\\FinalCA\\src\\main\\EmailDetails\\EmailPassword.txt";
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
                        


                                Message message = new MimeMessage(mailsession);
                                message.setFrom(new InternetAddress(username));
                                message.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(Email));
                                message.setSubject("Requested Change");
                                message.setText("Dear New Member,"
                                        + "\n\n CLick Link to Recover Account!" );
                                String content = "<a href='http://localhost:8080/StatwiseGameWiseSite/ChangeForgotPassword.jsp'>ChangePassword.com</a>";
                                message.setContent(content, "text/html");
                                Transport.send(message);



                        } catch (MessagingException e) {
                                throw new RuntimeException(e);
                        }  catch (IOException ex) {
                               Logger.getLogger(ForgotCommand.class.getName()).log(Level.SEVERE, null, ex);
                           }
                        
                       }
                       else if(Email == null)
                       {
                          String msg = "Forgot Password";
                          session.setAttribute("Type", msg);
                          session.setAttribute("AccountFail", UserName);
                          
                          forwardToJsp = "AccountFail.jsp";
                       }
                    
                    
               
                    }
         return forwardToJsp;
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
