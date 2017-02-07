package Daos;

/**
 *
 * @author Ben
 */
import Dtos.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao extends Dao implements UsersDaoInterface {

    public UsersDao(String databaseName) {
        super(databaseName);
    }

   
   /**
     * @param uname
     * @param pass
     * @param fname
     * @param lname
     * @param addre
     * @param email
     * @param Created
     * @param Due
     * @return true or false
     */
    @Override
    public boolean RegistorUser(String uname, String pass, String email, byte[] salt, String Created, String Due) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into users (username, email, password, admin, salt, Created, Due) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setInt(4, 0);   
            ps.setBytes(5, salt);
            ps.setString(6, Created);
            ps.setString(7, Due);
            
                   
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the RegistorUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RegistorUser() method");
                e.getMessage();
                
            }
        }
        if(rowsAffected > 0)
        {
        return true;
        }
        else{
            return false;
        }
    }

    /**
     * @param name
     * @param password
     * @return User
     */
    @Override
    public Users LogingInUser(String name, String password) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        
        try{
            con = getConnection();

            String query = "SELECT * from users Where username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
            u = new Users(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getInt("Admin"), rs.getString("Salt"), rs.getString("Created"), rs.getString("Due"));
            }
 
        }catch (SQLException e) {
            System.out.println("Exception occured in the LogingInUser() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the RemoveUser() method");
                e.getMessage();
                
            }
        }
        return u;
    }
    
    @Override
    public byte[] GetCAlSalt(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] salt = null;
        try{
            con = getConnection();

            String query = "Select salt from users Where userName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                salt = rs.getBytes("salt");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getUserbyName() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getUserbyName() method: " + e.getMessage());
            }
        }
        
        return salt;
    }
    
    /**
     * @param name
     * @return userName
     */
    @Override
    public Users getUserbyName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users u = null;
        try{
            con = getConnection();

            String query = "Select * from users Where username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                u = new Users(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getInt("Admin"), rs.getString("Salt"), rs.getString("Created"), rs.getString("Due"));
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getUserbyName() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getUserbyName() method: " + e.getMessage());
            }
        }
        
        return u;
    }
    
    }


