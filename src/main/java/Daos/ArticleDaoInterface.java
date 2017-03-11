package Daos;

/**
 *
 * 
 *
 * @author Ben
 */
import Dtos.Article;
import java.util.ArrayList;


public interface ArticleDaoInterface {

    /**
     * @param authorID
     * @param title
     * @param articleText
     * @param game
     * @param date
     * @return A boolean to show whether or not the article was posted
     */
    public boolean PostArticle(int authorID, String title, String articleText, String game);
    
    /**
     * @return all articles related to WoW
    */
    public ArrayList<Article> getWowArticles();
    
    /**
     * @return all articles related to LoL
    */
    public ArrayList<Article> getLolArticles();
    
    /**
     * @return all articles
    */
    public ArrayList<Article> getAllArticles();
    
    /**
     * @param articleID
     * @param title
     * @param text
     * @param game
     * @return A boolean to show whether or not the article was posted
     */
    public boolean EditArticle(int articleID, String title, String game, String text);
    
    /**
     * @param articleID
     * @return An article with the corresponding id
     */
    public Article getArticleByID(int articleID);
    
    /**
     * @param articleID
     * @return A boolean to show whether or not the article was removed
     */
    public boolean deleteArticle(int articleID);
    
}