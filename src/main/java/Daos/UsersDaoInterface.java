package Daos;

/**
 *
 * 
 *
 * @author Ben
 */
import Dtos.Users;
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
}