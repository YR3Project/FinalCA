/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;
import Commands.*;
import Dtos.Comments;
import Dtos.Users;
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

    /**
    * Returns the authors of comments
    * @param commentID
    * @param articleID
    * @param cAuthor
    * @param commentText
    * @param date
    * @return Sets the comment set by a user
    */
    @Override
    public boolean setComment(int commentID, int articleID, int cAuthor, String commentText, String date) {
            Connection con = null;
            PreparedStatement ps = null;
            Comments c = null;
            ResultSet rs = null;
            int rowsAffected = 0;
            try{
                con = getConnection();

                String query = "Insert INTO comments (CommentID, ArticleID, cAuthor, CommentText, DateAdded) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1,commentID);
                ps.setInt(2,articleID);
                ps.setInt(3, cAuthor);
                ps.setString(4, commentText);
                ps.setString(5, date);
                
                //Updates the rowsAffected variable to 1 if the insert works
                rowsAffected = ps.executeUpdate();
                
               

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
            //Check to see if the insert went through
            if(rowsAffected > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
    }

    /**
    * Returns the authors of comments
    * @param cAuthor = authorID
    * @return Comments made by the author
    */
    @Override
    //Reason it returns all of the columns is for a report system
    public Comments getAuthor(int cAuthor) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comments c = null;
        try{
            con = getConnection();

            String query = "Select * from Comments Where cAuthor = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cAuthor);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                c = new Comments(rs.getInt("commentID"), rs.getInt("ArticleID"), rs.getInt("cAuthor"), rs.getString("commentText"), rs.getString("DateAdded"));
            }
        }catch (SQLException e) {
            System.out.println("Exception occured in the getAuthor() method: " + e.getMessage());
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
                System.out.println("Exception occured in the finally section of the getAuthor() method: " + e.getMessage());
            }
        }
        
        return c;
    }
    /**
     * Users who made their comment should be able to edit them as should admins and mods
     * @param commentID
     * @param commentText
     * @return Edits the users comment
     */
    @Override
    public Comments editComment(int commentID, String commentText) {
            Connection con = null;
            PreparedStatement ps = null;
            Comments c = null;
            ResultSet rs = null;
                try{
                    con = getConnection();

                    String query = "Insert Comments SET (CommentText) WHERE commentID = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, commentText);
                    ps.setInt(2, commentID);


                }catch (SQLException e) {
                    System.out.println("Exception occured in the editComment() method: " + e.getMessage());

                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                        if (con != null) {
                            freeConnection(con);
                        }
                    } catch (SQLException e) {
                        System.out.println("Exception occured in the finally section of the editComment() method");
                        e.getMessage();

                    }
                }
            return c;    
    }
    /**
     * Putting in a comment ID deletes the comment thats inside the article using the articleID
     * @param commentID
     * @return Deletes the users comment
     */
    @Override
    public boolean deleteComment(int commentID, int articleID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            con = getConnection();

            String query = "DELETE FROM comments where commentID = ? AND articleID = ";
            ps = con.prepareStatement(query);
            ps.setInt(1, commentID);
            ps.setInt(2, articleID);
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Exception occured in the deleteComment() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the deleteComment() method: " + e.getMessage());
            }
        }
        if (rowsAffected < 0) {
            return true;
        } else {
            return false;
        }
        
    }
    /**
     * 
     * @param commentID
     * @param articleID
     * @return AuthorID and their comments
     */
    @Override
    public String getAuthorByCommentID(int commentID, int articleID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String author = null;
        try {
            con = getConnection();

            String query = "SELECT authorID, commentText FROM comments where commentID = ? or articleID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, commentID);
            ps.setInt(2, articleID);
            rs = ps.executeQuery();
            while(rs.next())
            {
                author = rs.getString("CAuthor");
                
            }

        } catch (SQLException e) {
            System.out.println("Exception occured in the deleteComment() method: " + e.getMessage());
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the deleteComment() method: " + e.getMessage());
            }
        }
        
        return author;
        
    }

    @Override
    public Comments getAllCommentsByArticleID(int articleID) {
            Connection con = null;
            PreparedStatement ps = null;
            Comments c = null;
            ResultSet rs = null;
                try{
                    con = getConnection();

                    String query = "SELECT CommentText,CAuthor FROM Comments WHERE articleID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, articleID);

                }catch (SQLException e) {
                    System.out.println("Exception occured in the getAllCommentsByArticleID() method: " + e.getMessage());

                } finally {
                    try {
                        if (ps != null) {
                            ps.close();
                        }
                        if (con != null) {
                            freeConnection(con);
                        }
                    } catch (SQLException e) {
                        System.out.println("Exception occured in the finally section of the getAllCommentsByArticleID() method");
                        e.getMessage();

                    }
                }
            return c;    
        
    }

    
    
}
