package Dtos;

import Daos.*;

/**
 *
 * @author D00165195
 */
public class Comments {
    public int commentID;
    public int articleID;
    public int cAuthor;
    public String commentText;
    public String date;

    public Comments(int commentID, int articleID, int cAuthor, String commentText, String date) {
        this.commentID = commentID;
        this.articleID = articleID;
        this.cAuthor = cAuthor;
        this.commentText = commentText;
        this.date = date;
    }

    public Comments() {
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getcAuthor() {
        return cAuthor;
    }

    public void setcAuthor(int cAuthor) {
        this.cAuthor = cAuthor;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comments{" + "commentID=" + commentID + ", articleID=" + articleID + ", cAuthor=" + cAuthor + ", commentText=" + commentText + ", date=" + date + '}';
    }
    
}
