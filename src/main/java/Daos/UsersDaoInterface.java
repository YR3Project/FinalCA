package Daos;

/**
 *
 * 
 *
 * @author Ben
 */
import Dtos.Users;
import java.io.InputStream;
import java.util.ArrayList;


public interface UsersDaoInterface {

    /**
     * 
     * @param u
     * @return 
     */
    public int RegisterUser(Users u);
    /**
     * 
     * @param uname
     * @param pass
     * @param email
     * @param salt
     * @param Created
     * @param Due
     * @return 
     */
    
    
    public boolean RegisterUser(String uname, String pass, String email, byte[] salt, String Created, String Due);
    /**
     * 
     * @param name
     * @param password
     * @return 
     */
    public Users LogingInUser(String name, String password);

     /**
    @param username
    @return byte[] for slat necessary for logging in to user account
    */
    public byte[] GetCAlSalt(String username);
    
     /**
     * @param name
     * @return Return details of the user whos name was entered
     */
    public Users getUserbyName(String name);
    
    public String GetName(String email);
    /*
    for getting name to use in login functions so user can log-in with both email and there name
    */
    
    public String GetAuthorByID(int ID);
    
     public boolean EditProfile(String username, String email, int id);
    //allows the user to edit their profile}
     
      /**
     * @param photo
     * @param id
     * @return true or false based on whether the profile picture was uploaded
     * Successfully to the database
     **/
     public boolean AddProfilePic(InputStream photo, int id);
     //allow user to give themselves a custom picture to use on there account.
     
    /**
     * @param newpass
    @param oldpass
    @return true or false based on if the password has been changed
    */
    public boolean ChangePassword(String newpass, String oldpass );
    
    /**
    @param newsalt
    @param oldsalt
    @return replaces the recorded byte[] in the database when user changes there password
    */
    public boolean ChangeSalt(byte[] newsalt, byte[] oldsalt);

    /**
    @param Username 
    @param cdate 
    @param ddate
    @return true or false based on whether it changed the dates for creation and expire/due in the database
    */
    public boolean ChangeDates(String Username, String cdate, String ddate);
    
    
     /**
    @param pass
    @return salt when changing password
    */
    public byte[] GetCAlSaltch(String pass);
    
    
    public ArrayList<Users>GetAllUsers();
    /**
     * 
     * @param id
     * return Path to profile Picture
     */
    public String GetPicPath(int id);
}