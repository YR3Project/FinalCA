/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author D00165195
 */
import Commands.*;
import Dtos.Comments;
import java.util.ArrayList;
public interface CommentsDaoInterface {
    
    /**
     * @param commentID
     * @param articleID
     * @param cAuthor
     * @param commentText
     * @param date
     * @return An comment object
     */
    public boolean setComment(int commentID, int articleID, int cAuthor, String commentText, String date);
    /**
     * 
     * @param cAuthor
     * @return All comments made by the author
     */
    public Comments getAuthor(int cAuthor);
    
    /**
     * 
     * @param commentID
     * @param commentText
     * @return Edits a comment 
     */
    
    public Comments editComment(int commentID, String commentText);
    
    /**
     * 
     * @param commentID
     * @param articleID
     * @return Returns true or false which will either delete the comment or it won't
     *  
     */
    public boolean deleteComment(int commentID, int articleID);
    
    
}
