package Commands;
import Daos.UsersDao;
import Dtos.Users;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Author Aleksander Matraszek, Benjamin Rose
*/
public class EditCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        HttpSession session = request.getSession();
        
        Object Value = session.getAttribute("CurrentUser");
        Users uid = (Users) Value;
        
        int id = uid.getUserID();
        String Newname = request.getParameter("userName");
        String email = request.getParameter("email");
        String Country = request.getParameter("country");
        UsersDao userDao = new UsersDao("swgw");
        boolean Checkname = false;
        boolean Checkemail = false;
        ArrayList<Users> Accounts = userDao.GetAllUsers();
        if (Newname.equals("") || email.equals("")) {
            String msg = "You cannot leave any of the entries empty or have the same username as the old one";
            session.setAttribute("errorMessage", msg);
            forwardToJsp = "error.jsp";
        }
         
         for(int x = 0; x < Accounts.size(); x++)
            {
             if(Newname.toLowerCase().equals(Accounts.get(x).getUserName().toLowerCase()))
               {
                  Checkname = true;
               }
             
            }
                        
         for(int x = 0; x < Accounts.size(); x++)
            {
             if(email.equals(Accounts.get(x).getEmail()))
               {
                  Checkemail = true;
               }
            }
         
        if (Checkname == false && Checkemail == false){
            try {

                boolean Action = userDao.EditProfile(Newname, Country, email, id);
                

                if (Action == true) {
                    
                    session.setAttribute("ChangeSuccess", "Your Profile has been edited"); 
                    
                    forwardToJsp = "LoginForm.jsp";
                } else if (Action == false) {
                    session.setAttribute("EditSuccess", "There was a problem Unable to edit your account");
                     forwardToJsp = "viewProfile.jsp";
                }
            } catch (InputMismatchException e) {
                forwardToJsp = "error.jsp";
                session.setAttribute("errorMessage", "The inputs supplied for parameters is not he right type.");
            } catch (NullPointerException ex) {
                Logger.getLogger(EditCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(Checkname == true)
               {
                String error = "That Username Already in use ";
                session.setAttribute("errorMessage", error);
                forwardToJsp = "error.jsp";    
               }
        else if(Checkemail == true)
                {
                 String error = "That Email Already in use ";
                 session.setAttribute("errorMessage", error);
                 forwardToJsp = "error.jsp";  
                }
        return forwardToJsp;
    }
}
