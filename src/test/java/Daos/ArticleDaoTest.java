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
        int authorID = 8;
        String title = "JunitTest";
        String articleText = "def";
        String game = "def";
        
        boolean expResult = true;
        boolean result = aDao.PostArticle(authorID, title, articleText, game);
        assertEquals(expResult, result);
        
        aDao.getArticlesByTitle("JunitTest");
        int ID = aDao.getArticlesByTitle(title).get(0).getArticleID();
        
        aDao.deleteArticle(ID);
        //For testing the deletearticle
        int authorID2 = 8;
        String title2 = "DeleteTest";
        String articleText2 = "Testing the stuff";
        String game2 = "wow";
        aDao.PostArticle(authorID2, title2, articleText2, game2);
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
     
    @Test
    public void testEditArticle() {
        System.out.println("EditArticle");
        int articleID = 1;
        String title = "Riots new Release";
        String game = "wow";
        String text = "test";
        
        boolean expResult = true;
        boolean result = aDao.EditArticle(articleID, title, game, text);
        assertEquals(expResult, result);
        
        String getText = aDao.getArticleByID(articleID).getGame();
        
        assertEquals("wow", getText);
        
        aDao.EditArticle(articleID, "Riots Latest Release", "lol", "Galio");
        
    }*/

    /**
     * Test of getArticleByID method, of class ArticleDao.
     
    @Test
    public void testGetArticleByID() {
        System.out.println("getArticleByID");
        int articleID = 3;
        
        boolean resultBoolean = false;
        boolean expResult = true; 
        //String expResult = "New Article";
        Article result = aDao.getArticleByID(articleID);
        if(result != null)
        {
            resultBoolean = true;
        }
        
        assertEquals(expResult,  resultBoolean);
       
    }*/

    /**
     * Test of deleteArticle method, of class ArticleDao.
     */
    @Test
    public void testDeleteArticle() {
        System.out.println("deleteArticle");
        int articleID = aDao.getArticlesByTitle("DeleteTest").get(0).getArticleID();
        
        boolean expResult = true;
        boolean result = aDao.deleteArticle(articleID);
        assertEquals(expResult, result);
        
        Article result2 = aDao.getArticleByID(articleID);
        assertNull(null, result2);
        
        
        
    }

    /**
     * Test of GetPicPath method, of class ArticleDao.
     
    @Test
    public void testGetPicPath() {
        System.out.println("GetPicPath");
        int id = 9;
       
        String expResult = "Images/Articles/35.jpg";
        String result = aDao.getArticleByID(9).get
        assertEquals(expResult, result);
        
    }
    * */
    @Test
    public void testGetArticlesByTitle()
    {
        System.out.println("GetArticlesByTitle");
        
        String name = "New ";
        int expResult = 2;
        
        ArrayList<Article> result = aDao.getArticlesByTitle(name);
        
        assertEquals(expResult, result.size());
    }
}
