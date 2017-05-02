
package Commands;

import Daos.UsersDao;
import java.util.InputMismatchException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ben
 */
public class DeleteUserCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
        
        String UId = request.getParameter("uId");
        
        int id = Integer.parseInt(UId);
        
        try
         {
             HttpSession session = request.getSession();
             
             UsersDao userDao = new UsersDao("swgw");
             String User = userDao.GetAuthorByID(id);
             boolean Remove = userDao.RemoveUser(id);
             if(Remove == true){
                 String msg = "The following User was removed " + User;
                 session.setAttribute("EditSuccess", msg);
                  forwardToJsp = "viewProfile.jsp";
             }
             
             if(Remove == false){
                 String msg = "The User was not removed";
                 session.setAttribute("EditSuccess", msg);
                  forwardToJsp = "viewProfile.jsp";    
             }
         }catch (InputMismatchException e)
                    {
                        
                        forwardToJsp = "error.jsp";
                        
                        HttpSession session = request.getSession();
                        
                        session.setAttribute("errorMessage", "Text was supplied for parameters is not he right type.");
                    }
        return forwardToJsp;
    }
    
}
