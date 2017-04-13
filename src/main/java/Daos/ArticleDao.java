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
     * @param authorID
     * @param title
     * @param articleText
     * @param game
     * @param date
     * @return A boolean to show whether or not the article was posted
     */
    @Override
    public boolean PostArticle(int authorID, String title, String articleText, String game) {
        Connection con = null;
        PreparedStatement ps = null;
        int rowsAffected = 0;
        
        try{
            con = getConnection();

            String query = "Insert into article (authorid, title, articletext, game, dateadded) values(?,?,?,?,NOW())";
            ps = con.prepareStatement(query);
            ps.setInt(1, authorID);
            ps.setString(2, title);
            ps.setString(3, articleText);
            ps.setString(4, game);   
            
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

            String query = "Select * from article where game = 'wow' or game = 'def' ORDER BY DateAdded desc";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("ArticleText"), rs.getString("Game"), rs.getString("DateAdded"));
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

            String query = "Select * from article where game = 'lol' or game = 'def' ORDER BY DateAdded desc";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("ArticleText"), rs.getString("Game"), rs.getString("DateAdded"));
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

            String query = "Select * from article ORDER BY DateAdded desc";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                Article a = new Article(rs.getInt("ArticleID"), rs.getInt("AuthorID"), rs.getString("Title"), rs.getString("ArticleText"), rs.getString("Game"), rs.getString("DateAdded"));
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

            String query = "UPDATE article SET Title = ?, Game =?, Articletext = ? Where ArticleID = ? ";
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
    
        @Override
    public String GetPicPath(int id) {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pic = null;
        try{
            con = getConnection();

            String query = "Select photo from article Where AuthorID = ?";
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
    
    }