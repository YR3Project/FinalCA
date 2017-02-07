/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Daos.UsersDao;
import Dtos.Users;
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
Author Aleks,Ben
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
                       
                       
                        boolean isAtLeast8 = Password.length() >= 8;
                        boolean isaMax128 = Password.length() <= 128;
                        boolean hasUppercase = !Password.equals(Password.toLowerCase());
                        boolean hasLowercase = !Password.equals(Password.toUpperCase());
                        boolean hasNumeric = Password.matches("[0-9]");
                        boolean hasNoSpaces = !Password.contains(" ");
                        boolean noConditions = !(Password.contains("AND") || Password.contains("NOT") || Password.contains("not") || Password.contains("and"));//Check that it doesn't contain AND or NOT
                        boolean noUsername = !(Password.contains(UserName));
                
                        if(!isAtLeast8){
                            String error = "Your Password is too Short";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                             }
                        if(!isaMax128){
                            String error = "Your Password is too Long";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                
                        if(!hasUppercase) {
                            String error = "Your Password must contain one uppercase letter";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                
                        if(!hasLowercase){
                            String error = "Your Password must contain one lowercase letter";
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
                            String error = "Your Password must not contain any conditions e.g and/or";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                        if(!noUsername){
                            String error = "Your Password must not contain Your UserName";
                            session.setAttribute("Complexity", error);
                            forwardToJsp = "RegRetry.jsp";
                            }
                        
                       
                       if(isAtLeast8 && isaMax128 && hasUppercase && hasLowercase && hasNoSpaces && noConditions && noUsername)
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

                            
                       UsersDao userDao = new UsersDao("finalprojecttest");
                       DateFormat df = new SimpleDateFormat("dd/MM/yy");
                       Date createdate = new Date();
                       Date expiredate = new Date();
                       Calendar c = Calendar.getInstance(); 
                        c.setTime(createdate); 
                        c.add(Calendar.DATE, 1);
                        expiredate = c.getTime();
                       
                       boolean Action = userDao.RegistorUser(UserName, generatedPassword, Email, salt, df.format(createdate), df.format(expiredate));
                       
                       if(Action == true){
                          Users user = userDao.getUserbyName(UserName);
                          session.setAttribute("RegSuccess", user); 
                          
                          forwardToJsp = "registrationSuccessful.jsp"; 
                       }
                       else if(Action == false)
                       {
                            String msg = "Registration" + Email + generatedPassword + salt + df.format(createdate) + df.format(expiredate);
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
