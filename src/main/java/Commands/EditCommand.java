package Commands;
import Daos.UsersDao;
import Dtos.Users;
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

        if (Newname.equals("") || email.equals("")) {
            String msg = "You cannot leave any of the entries empty or have the same username as the old one";
            session.setAttribute("ChangeError", msg);
            forwardToJsp = "ChangeError.jsp";
        } else {
            try {
                UsersDao userDao = new UsersDao("swgw");
                boolean Action = userDao.EditProfile(Newname, email, id);
                

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
        return forwardToJsp;
    }
}
