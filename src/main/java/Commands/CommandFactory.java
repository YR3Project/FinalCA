
package Commands;

/**
 *
 * Author Ben , Chris
 */
public class CommandFactory {
   public Command createCommand(String action)
    {
       switch (action) {
           case "login":
               return new LoginCommand();
           case "register":
               return new RegisterCommand();
           case "comment":
               return new SetCommentCommand();
           case "edit":
               return new EditCommand();
           default:
               break;
       }
        
        return null;
    }
}
