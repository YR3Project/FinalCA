/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Comments;
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
public class CommentsDaoTest {
    private String testdb = "testdb";
    private CommentsDao cDao = new CommentsDao(testdb);
    public CommentsDaoTest() {
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
     * Test of setComment method, of class CommentsDao.
     */
    @Test
    public void testSetComment() {
      /*  System.out.println("setComment");
        int articleID = 1;
        int cAuthor = 46;
        String commentText = "TestComment";
        
        boolean expResult = true;
        boolean result = cDao.setComment(articleID, cAuthor, commentText);
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of getAuthor method, of class CommentsDao.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        int cAuthor = 46;

        String expResult = "Chris";
        String result = cDao.getAuthor(cAuthor);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getCommentsByArticle method, of class CommentsDao.
     */
    @Test
    public void testGetCommentsByArticle() {
        System.out.println("getCommentsByArticle");
        int articleID = 2;
        
        int expResult = 3;
        ArrayList<Comments> result = cDao.getCommentsByArticle(articleID);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of editComment method, of class CommentsDao.
     */
    @Test
    public void testEditComment() {
        System.out.println("editComment");
        int commentID = 23;
        String commentText = "Test2Comment";
        
        
        //Comments result = cDao.editComment(commentID, commentText);
        //String
        //assertEquals(expResult, result);
       
    }

    /**
     * Test of deleteComment method, of class CommentsDao.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        int commentID = 24;
        
        boolean expResult = true;
        boolean result = cDao.deleteComment(commentID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAuthorByCommentID method, of class CommentsDao.
     */
    @Test
    public void testGetAuthorByCommentID() {
        System.out.println("getAuthorByCommentID");
        int commentID = 22;
        int articleID = 2;
       
        int expResult = 29;
        int result = cDao.getAuthorByCommentID(commentID, articleID);
        assertEquals(expResult, result);
        
    }
    
}
