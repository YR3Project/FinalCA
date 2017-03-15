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
    private final String db = "testdb";
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
        int authorID = 8;
        String title = "Test";
        String articleText = "ads";
        String game = "def";
        ArticleDao instance = new ArticleDao(db);
        boolean expResult = true;
        boolean result = instance.PostArticle(authorID, title, articleText, game);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test of getWowArticles method, of class ArticleDao.
     */
    @Test
    public void testGetWowArticles() {
        System.out.println("getWowArticles");
        ArticleDao instance = new ArticleDao(db);
        int expResult = 7;
        ArrayList<Article> result = instance.getWowArticles();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getLolArticles method, of class ArticleDao.
     */
    @Test
    public void testGetLolArticles() {
        System.out.println("getLolArticles");
        ArticleDao instance = new ArticleDao(db);
        int expResult = 7;
        ArrayList<Article> result = instance.getLolArticles();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getAllArticles method, of class ArticleDao.
     */
    @Test
    public void testGetAllArticles() {
        System.out.println("getAllArticles");
        ArticleDao instance = new ArticleDao(db);
        int expResult = 8;
        ArrayList<Article> result = instance.getAllArticles();
        assertEquals(expResult, result.size());
       
    }

    /**
     * Test of EditArticle method, of class ArticleDao.
     */
    @Test
    public void testEditArticle() {
        System.out.println("EditArticle");
        int articleID = 0;
        String title = "";
        String game = "";
        String text = "";
        ArticleDao instance = null;
        boolean expResult = false;
        boolean result = instance.EditArticle(articleID, title, game, text);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getArticleByID method, of class ArticleDao.
     */
    @Test
    public void testGetArticleByID() {
        System.out.println("getArticleByID");
        int articleID = 1;
        ArticleDao instance = new ArticleDao(db);
        Article expResult = instance.getArticleByID(articleID);
        Article result = instance.getArticleByID(articleID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteArticle method, of class ArticleDao.
     */
    @Test
    public void testDeleteArticle() {
        System.out.println("deleteArticle");
        int articleID = 0;
        
        ArticleDao instance = new ArticleDao(db);
        boolean expResult = true;
        boolean result = instance.deleteArticle(articleID);
        assertEquals(expResult, result);
        
    }
    
}
