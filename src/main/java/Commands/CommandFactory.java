
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
           case "change":
               return new ChangeCommand();
           case "postArtc":
               return new PostArticleCommand();
           case "editArtc":
               return new EditArticleCommand();
           case "delArtc":
               return new DeleteArticleCommand();
            case "delComm":
               return new DeleteCommentCommand();
           default:
               break;
       }
        
        return null;
    }
}
