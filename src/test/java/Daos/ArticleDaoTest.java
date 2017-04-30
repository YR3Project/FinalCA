/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Article;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class ArticleDaoTest {
    private String testdb = "testdb";
    private ArticleDao aDao = new ArticleDao(testdb);
    public ArticleDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of PostArticle method, of class ArticleDao.
     */
    @Test
    public void testPostArticle() {
        System.out.println("PostArticle");
        int authorID = 48;
        String title = "test";
        String articleText = "def";
        String game = "def";
        
        boolean expResult = true;
        boolean result = aDao.PostArticle(authorID, title, articleText, game);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getWowArticles method, of class ArticleDao.
     */
    @Test
    public void testGetWowArticles() {
        System.out.println("getWowArticles");
        
        int expResult = 2;
        ArrayList<Article> result = aDao.getWowArticles();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getLolArticles method, of class ArticleDao.
     */
    @Test
    public void testGetLolArticles() {
        System.out.println("getLolArticles");
       
        int expResult = 2;
        ArrayList<Article> result = aDao.getLolArticles();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getAllArticles method, of class ArticleDao.
     */
    @Test
    public void testGetAllArticles() {
        System.out.println("getAllArticles");
        
        int expResult = 3;
        ArrayList<Article> result = aDao.getAllArticles();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of EditArticle method, of class ArticleDao.
     */
    @Test
    public void testEditArticle() {
        System.out.println("EditArticle");
        int articleID = 5;
        String title = "RiotsLatestRelease";
        String game = "wow";
        String text = "";
        
        boolean expResult = true;
        boolean result = aDao.EditArticle(articleID, title, game, text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getArticleByID method, of class ArticleDao.
     */
    @Test
    public void testGetArticleByID() {
        System.out.println("getArticleByID");
        int articleID = 2;
        
        int expResult = 2;
        int result = aDao.getArticleByID(articleID).getArticleID();
        System.out.println(result);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of deleteArticle method, of class ArticleDao.
     */
    @Test
    public void testDeleteArticle() {
        System.out.println("deleteArticle");
        int articleID = 4;
        
        boolean expResult = true;
        boolean result = aDao.deleteArticle(articleID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of GetPicPath method, of class ArticleDao.
     */
    @Test
    public void testGetPicPath() {
        System.out.println("GetPicPath");
        int id = 9;
       
        String expResult = "Images/Articles/35.jpg";
        //String result = aDao.GetPicPath(id);
        //assertEquals(expResult, result);
        
    }
    @Test
    public void testGetArticlesByTitle()
    {
        System.out.println("GetArticlesByTitle");
        
        String name = "Return to the ";
        int expResult = 1;
        
        ArrayList<Article> result = aDao.getArticlesByTitle(name);
        
        assertEquals(expResult, result.size());
    }
}
