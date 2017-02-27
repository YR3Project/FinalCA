package Daos;

/**
 *
 * @author Ben
 */
import Dtos.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends Dao implements ArticleDaoInterface {

    public ArticleDao(String databaseName) {
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
    public boolean PostArticle(int authorID, String title, String articleText, String game, String date) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into article (authorid, title, game, articletext, dateadded) values(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, authorID);
            ps.setString(2, title);
            ps.setString(3, articleText);
            ps.setString(4, game);   
            ps.setString(5, date);
            
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("Exception occured in the PostArticle() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the final part of PostArticle()");
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
    public ArrayList<Article> getWowArticles() {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> articles = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from article where game = 'wow' OR game = 'def'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("Game"), rs.getString("ArticleText"), rs.getString("DateAdded"));
                articles.add(a);
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getWowArticles() method: " + e.getMessage());
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
                System.out.println("Exception occured in the final part of getWowArticles(): " + e.getMessage());
            }
        }
        
        return articles;
    }
    
    @Override
    public ArrayList<Article> getLolArticles() {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> articles = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from article where game = 'lol' OR game = 'def'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("Game"), rs.getString("ArticleText"), rs.getString("DateAdded"));
                articles.add(a);
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getLolArticles() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the final part of getLolArticles(): " + e.getMessage());
            }
        }
        return articles;
    }
    
    @Override
    public ArrayList<Article> getAllArticles() {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> articles = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from article";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("Game"), rs.getString("ArticleText"), rs.getString("DateAdded"));
                articles.add(a);
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getAllArticles() method: " + e.getMessage());
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
                System.out.println("Exception occurred in the final part of getAllArticles(): " + e.getMessage());
            }
        }
        return articles;
    }
    
    @Override
    public boolean EditArticle(int articleID, String title, String game, String text) {
       Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            con = getConnection();

            String query = "UPDATE article SET title = ?, game =?, text = ?  Where ArticleID = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            ps.setString(2, game);
            ps.setString(3, text);
            ps.setInt(4, articleID);

            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("An exception has occurred in the EditArticle() method: " + e.getMessage());

        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part the EditArticle()");
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
    public Article getArticleByID(int articleID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article a = null;
        
        try{
            con = getConnection();

            String query = "Select * from Article where articleID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, articleID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("Game"), rs.getString("ArticleText"), rs.getString("DateAdded"));
                
            }
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the getArticleByID() method: " + e.getMessage());
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
                System.out.println("An exception occurred in the final part of getArticleByID(): " + e.getMessage());
            }
        }
        return a;
    }
    
    @Override
    public boolean deleteArticle(int articleID) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "DELETE FROM article Where articleID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, articleID);
                            
            rowsAffected = ps.executeUpdate(); 
            
        }catch (SQLException e) {
            System.out.println("An exception has occurred in the deleteArticle() method: " + e.getMessage());
            
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("An exception has occurred in the final part of deleteArticle()");
                e.getMessage();
                
            }
        }
        return rowsAffected > 0;
    }
    }

