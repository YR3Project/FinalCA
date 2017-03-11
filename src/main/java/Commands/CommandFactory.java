
package Commands;

/**
 *
 * Author Ben , Chris
 */
public class CommandFactory {
   public Command createCommand(String action)
    {
        if(action.equals("login"))
        {
            return new LoginCommand();
        }
        
        else if(action.equals("register"))
        {
            return new RegisterCommand();
        }
        
        else if(action.equals("writeComm"))
        {
            return new WriteCommentCommand();
        }
        
        else if(action.equals("postArtc"))
        {
            return new PostArticleCommand();
        }
        else if(action.equals("editArtc"))
        {
            return new EditArticleCommand();
        }
        else if(action.equals("delArtc"))
        {
            return new DeleteArticleCommand();
        }
        return null;
    }
}

