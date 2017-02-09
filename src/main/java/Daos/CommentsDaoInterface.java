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
    
    public Comments setComment(int authorID, int commentID, String comment, String date);
    
    public Comments getAuthor(int authorID, int commentID, String comment);
    
    public Comments editComment(int authorID, int commentID, String comment);
    
    public Comments deleteComment(int authorID, int commentID, String comment, String date);
    
    
}
