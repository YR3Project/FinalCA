
package Commands;

/**
 *
 * Author Ben , Aleks, Chris
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
        return null;
    }
}
