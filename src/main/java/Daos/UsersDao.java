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

   /*
    public int RegisterUser(Users u) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into users (username, email, password, admin, salt, Created, Due) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, 0);   
            ps.setBytes(5, u.getSalt());
            ps.setString(6, u.getCreated());
            ps.setString(7, u.getDue());
            
                   
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the RegistorUser() method: " + e.getMessage());
            rowsAffected = -1;
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
        return rowsAffected;
    }
    */
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

    @Override
    public String GetName(String email) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;
        try{
            con = getConnection();

            String query = "Select username from users Where email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              name = rs.getString("username");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetName() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetName() method: " + e.getMessage());
            }
        }
        
        return name;
    }

    @Override
    public int RegisterUser(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegisterUser(String uname, String pass, String email, byte[] salt, String Created, String Due) {
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

    @Override
    public String GetAuthorByID(int ID) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;
        try{
            con = getConnection();

            String query = "Select username from users Where userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              name = rs.getString("username");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetAuthorByID() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetAuthorByID() method: " + e.getMessage());
            }
        }
        
        return name;
    }
    
    }


