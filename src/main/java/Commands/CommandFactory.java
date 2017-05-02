
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
           case "writeComm":
               return new WriteCommentCommand();
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
            case "ProPic":
                return new ProfilePicCommand();
            case "ArtPic":
                return new ArticlePicCommand();
            case "battle":
                return new BattleScoreCommand();
            case "forgot":
                return new ForgotCommand();
            case "forgotPassword":
                return new ForgotPasswordCommand();
            case "delUser":
                return new DeleteUserCommand();
           default:
               break;
       }
        
        return null;
    }
}
