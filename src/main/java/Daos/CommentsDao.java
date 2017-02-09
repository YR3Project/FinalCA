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
    public Comments setComment(int commentID, int articleID, int cAuthor, String commentText, String date) {
            Connection con = null;
            PreparedStatement ps = null;
            Comments c = null;
            ResultSet rs = null;
            try{
                con = getConnection();

                String query = "Insert into Comments (CommentID, ArticleID, cAuthor, CommentText, DateAdded) values(?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, commentID);
                ps.setInt(2, articleID);
                ps.setInt(3, cAuthor);
                ps.setString(4, commentText);
                ps.setString(5, date);
                rs = ps.executeQuery();
                while(rs.next())
                {
                    c = new Comments(rs.getInt("commentID"), rs.getInt("ArticleID"), rs.getInt("cAuthor"), rs.getString("commentText"), rs.getString("DateAdded"));
                }
               

            }catch (SQLException e) {
                System.out.println("Exception occured in the setComment() method: " + e.getMessage());

            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the setComment() method");
                    e.getMessage();

                }
            }
            return c;
    }

    @Override
    public Comments getAuthor(int commentID, int articleID, int cAuthor, String commentText, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comments editComment(int commentID, int articleID, int cAuthor, String commentText, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comments deleteComment(int commentID, int articleID, int cAuthor, String commentText, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
