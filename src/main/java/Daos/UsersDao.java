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

public class UsersDao extends Dao implements UsersDaoInterface {

    public UsersDao(String databaseName) {
        super(databaseName);
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
            u = new Users(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getString("Country"), rs.getInt("Admin"), rs.getString("Salt"), rs.getString("Created"), rs.getString("Due"));
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
                u = new Users(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getString("Country"), rs.getInt("Admin"), rs.getString("Salt"), rs.getString("Created"), rs.getString("Due"));
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
    public String GetEmail(String name) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String email = null;
        try{
            con = getConnection();

            String query = "Select email from users Where username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              email = rs.getString("email");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetEmail() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetEmail() method: " + e.getMessage());
            }
        }
        
        return email;
    }

   
    @Override
    public boolean RegisterUser(String uname, String pass, String country, String email, byte[] salt, String Created, String Due) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into users (username, email, password, country, admin, salt, Created, Due) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, country);
            ps.setInt(5, 0);   
            ps.setBytes(6, salt);
            ps.setString(7, Created);
            ps.setString(8, Due);
            
                   
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

    @Override
    public boolean EditProfile(String username, String Country, String email, int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET username = ?, country= ?, email = ? Where userID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, Country);
            ps.setString(3, email);
            ps.setInt(4, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the EditProfile method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    

    @Override
    public boolean ChangePassword(String newpass, String oldpass) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET password = ? Where password = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setString(2, oldpass);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ChangePassword method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean ChangeSalt(byte[] newsalt, byte[] oldsalt) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET Salt = ? Where Salt = ? ";
            ps = con.prepareStatement(query);
            ps.setBytes(1, newsalt);
            ps.setBytes(2, oldsalt);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangePassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ChangePassword method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean ChangeDates(String Username, String cdate, String ddate) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET Due = ?, Created = ? Where username = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, ddate);
             ps.setString(2, cdate);
            ps.setString(3, Username);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ChangeDueDate method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ChangeDueDate method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public byte[] GetCAlSaltch(String pass) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] salt = null;
        try{
            con = getConnection();

            String query = "Select Salt from users Where password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pass);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                salt = rs.getBytes("salt");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetCAlSaltch() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetCAlSaltch() method: " + e.getMessage());
            }
        }
        
        return salt;
    }

    @Override
    public ArrayList<Users> GetAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Users> users = new ArrayList();
        Users u = null;
        
        try{
            con = getConnection();

            String query = "Select * from users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                 u = new Users(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password"), rs.getString("Country"), rs.getInt("Admin"), rs.getString("Salt"), rs.getString("Created"), rs.getString("Due"));
                users.add(u);
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getAllUsers() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAllUsers() method: " + e.getMessage());
            }
        }
        
        return users;
    }

    @Override
    public String GetProfPicPath(int id) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pic = null;
        try{
            con = getConnection();

            String query = "Select photo from users Where userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
              pic = rs.getString("photo");
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the GetPicPath() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the GetPicPath() method: " + e.getMessage());
            }
        }
        
        return pic;
    }

    @Override
    public boolean ForgotPassword(String newpass, String name) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET password = ? Where username = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setString(2, name);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ForgotPassword method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ForgotPassword method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
    

    @Override
    public boolean ForgotPassSalt(byte[] newsalt, String name) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE users SET Salt = ? Where username = ? ";
            ps = con.prepareStatement(query);
            ps.setBytes(1, newsalt);
            ps.setString(2, name);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ForgotPassSalt method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ForgotPassSalt method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean RemoveUser(int id) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "DELETE FROM users WHERE userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the ForgotPassSalt method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the ForgotPassSalt method");
                e.getMessage();

            }
        }
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    }


