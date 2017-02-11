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
    public Comments setComment(int commentID, int articleID, int cAuthor, String commentText, String date);
    
    public Comments getAuthor(int cAuthor);
    
    public Comments editComment(int commentID, int articleID, int cAuthor, String commentText, String date);
    
    public Comments deleteComment(int commentID, int articleID, int cAuthor, String commentText, String date);
    
    
}
