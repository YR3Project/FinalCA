package Commands;

import Daos.UsersDao;
import Dtos.Users;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
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
public class ChangeCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
                HttpSession session = request.getSession();
                
                String UserName = request.getParameter("name");
                String Email = request.getParameter("email");
                String oldPassword = request.getParameter("oldpass");
                String NewPassword = request.getParameter("newpass");
                String comPassword = request.getParameter("compass");
                
                if(UserName.equals("") || NewPassword.equals("")|| comPassword.equals("")|| oldPassword.equals(""))
                {
                    String msg = "you cannot leave any of the entries empty";
                    session.setAttribute("ChangeFail", msg);
                    forwardToJsp = "ChangePassword.jsp";
                }
                else if(!(NewPassword.equals(comPassword)))
                {
                 String msg = "Your newPassword must be the same for confirmPassword";
                 session.setAttribute("ChangeFail", msg);
                 forwardToJsp = "ChangePassword.jsp";
                }
                else if(oldPassword.equals(NewPassword))
                {
                 String msg = "Please pick a new Password dont repeat your old Password";
                 session.setAttribute("ChangeFail", msg);
                 forwardToJsp = "ChangePassword.jsp";  
                }
                else{
                
                    try
                    {
                        boolean Structure = NewPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");
                       
                       
                        //Check that it doesn't contain AND or NOT removed lower case ones 
                        //since where cause problems with passwords like LegendandStrike45 as a example. 
                        boolean noConditions = !(NewPassword.contains("AND") || NewPassword.contains("NOT")); //|| NewPassword.contains("not") || NewPassword.contains("and"))
                        boolean noUsername = !(NewPassword.contains(UserName));
                        
                        if(!Structure){
                            String error = "Your NewPassword must be atleast more than 8 in Length, one Digit, "
                                    + "one Upper-Case, one Lower-case and no Spaces";
                            session.setAttribute("ChangeFail", error);
                            forwardToJsp = "ChangePassword.jsp";
                            }
                        
                        if(!noConditions){
                            String error = "Your NewPassword must not contain any conditions e.g AND/OR";
                            session.setAttribute("ChangeFail", error);
                            forwardToJsp = "ChangePassword.jsp";
                            }
                        
                        if(!noUsername){
                            String error = "Your NewPassword must not contain Your UserName";
                            session.setAttribute("ChangeFail", error);
                            forwardToJsp = "ChangePassword.jsp";
                            }
                        
                       
                       if(Structure && noConditions && noUsername)
                        {
                           byte[] newsalt = getSalt();
                            
                                MessageDigest md = MessageDigest.getInstance("SHA-512");
                                md.update(newsalt);
                                byte[] bytes = md.digest(NewPassword.getBytes());
			
                                StringBuilder sb1 = new StringBuilder();
			
                                for(int i=0; i< bytes.length ;i++)
                                {
                                    sb1.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                                }
                                String newgeneratedPassword = sb1.toString();
                                
                                
                            
                            UsersDao userDao = new UsersDao("swgw");
                        
                                byte[] oldsalt = userDao.GetCAlSalt(UserName);
                            
                                MessageDigest md2 = MessageDigest.getInstance("SHA-512");
                                md2.update(oldsalt);
                                byte[] bytes2 = md2.digest(oldPassword.getBytes());
			
                                StringBuilder sb2 = new StringBuilder();
			
                                for(int i=0; i< bytes2.length ;i++)
                                {
                                    sb2.append(Integer.toString((bytes2[i] & 0xff) + 0x100, 16).substring(1));
                                }
                                String oldgeneratedPassword = sb2.toString();
                        
                       
                       boolean Action = userDao.ChangePassword(newgeneratedPassword, oldgeneratedPassword);
                       boolean SaltAction = userDao.ChangeSalt(newsalt, oldsalt);
                       
                       if(Action == true && SaltAction == true){
                           DateFormat df = new SimpleDateFormat("dd/MM/yy");
                           Date createdate = new Date();
                           Date expiredate = new Date();
                           Calendar c = Calendar.getInstance(); 
                                c.setTime(createdate); 
                                c.add(Calendar.DATE, 1);
                                expiredate = c.getTime();
                          userDao.ChangeDates(UserName, df.format(createdate), df.format(expiredate));
                                
                          session.setAttribute("ChangeSuccess", "Your Password Has been Changed"); 
                          session.removeAttribute("CurrentUser");
                          
                          forwardToJsp = "LoginForm.jsp"; 
                        String EmailName = "C:\\Users\\Ben\\Desktop\\apache-tomcat-8.5.11-windows-x64\\apache-tomcat-8.5.11\\temp\\EmailDetails\\EmailName.txt";
                        String EmailPassword = "C:\\Users\\Ben\\Desktop\\apache-tomcat-8.5.11-windows-x64\\apache-tomcat-8.5.11\\temp\\EmailDetails\\EmailPassword.txt";
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
                                        + "\n\n your Password Has been Changed!" + "\n\n We hope you were the one to do this action if not then take the necessary steps to resovle this"
                                        + "\n\n Issue before its to late");

                                Transport.send(message);



                        } catch (MessagingException e) {
                                throw new RuntimeException(e);
                        }
                        
                       }
                       else if(Action == false && SaltAction == false)
                       {
                           String msg = "Changing Password";
                          session.setAttribute("Type", msg);
                          session.setAttribute("AccountFail", UserName);
                          
                          forwardToJsp = "AccountFail.jsp";
                       }
                    }
                    }catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";

                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
                    catch (NoSuchAlgorithmException ex) {
                              forwardToJsp = "error.jsp";

                               session.setAttribute("errorMessage", "Something has gone wrong with hashing your password");
                           } catch (NoSuchProviderException ex) {
                                                Logger.getLogger(ChangeCommand.class.getName()).log(Level.SEVERE, null, ex);
                                    }catch (NullPointerException ex) {
                                                Logger.getLogger(ChangeCommand.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                Logger.getLogger(ChangeCommand.class.getName()).log(Level.SEVERE, null, ex);
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
