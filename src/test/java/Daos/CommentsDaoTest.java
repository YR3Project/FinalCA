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
    private final String db = "testdb";
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
        System.out.println("setComment");
        Comments newComment = new Comments();
        newComment.setArticleID(1);
        newComment.setCommentID(2);
        newComment.setCommentText("213");
        newComment.setDate("0000-00-00");
        newComment.setcAuthor(31);
        CommentsDao instance = new CommentsDao(db);
        boolean expResult = true;
        boolean result = instance.setComment(2, 29, "wewew");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAuthor method, of class CommentsDao.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        int cAuthor = 29;
        CommentsDao instance = new CommentsDao(db);
        String expResult = "BenRose";
        String result = instance.getAuthor(cAuthor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCommentsByArticle method, of class CommentsDao.
     */
    @Test
    public void testGetCommentsByArticle() {
        System.out.println("getCommentsByArticle");
        int articleID = 1;
        CommentsDao instance = new CommentsDao(db);
        int expResult = 1;
        ArrayList<Comments> result = instance.getCommentsByArticle(articleID);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of editComment method, of class CommentsDao.
     */
    @Test
    public void testEditComment() {
        System.out.println("editComment");
        int commentID = 1;
        String commentText = "123";
        CommentsDao instance = new CommentsDao(db);
        Comments c = new Comments();
        int expResult = 1;
        c.setCommentID(commentID);
        c.setCommentText(commentText);
        Comments result = instance.editComment(commentID, commentText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteComment method, of class CommentsDao.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        int commentID = 2;
        CommentsDao instance = new CommentsDao(db);
        boolean expResult = false;
        boolean result = instance.deleteComment(commentID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAuthorByCommentID method, of class CommentsDao.
     */
    @Test
    public void testGetAuthorByCommentID() {
        System.out.println("getAuthorByCommentID");
        int commentID = 1;
        int articleID = 1;
        CommentsDao instance = new CommentsDao(db);
        String expResult = "29, wewew";
        String result = instance.getAuthorByCommentID(1, 0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
