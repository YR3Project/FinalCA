/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;
import Commands.*;
import Dtos.Comments;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author D00165195
 */
public class CommentsDao extends Dao implements CommentsDaoInterface{

    public CommentsDao(String databaseName) {
        super(databaseName);
    }

    @Override
    public String setComment(int authorID, int commentID, String comment, String date) {
            Connection con = null;
            PreparedStatement ps = null;
           

            try{
                con = getConnection();

                String query = "Insert into Comments (authorID, commentID, comment, date) values(?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, authorID);
                ps.setInt(2, commentID);
                ps.setString(3, comment);
                ps.setString(4, date);
                
               

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
    }

    
    
}
