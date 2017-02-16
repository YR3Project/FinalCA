
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
        else if(action.equals("comment"))
        {
            return new SetCommentCommand();
        }
        else if(action.equals("riotApi"))
        {
            return new RiotApiCommand();
        }
        return null;
    }
}
