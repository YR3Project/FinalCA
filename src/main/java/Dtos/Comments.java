package Dtos;

import Daos.*;

/**
 *
 * @author D00165195
 */
public class Comments {
    public int commentID;
    public int articleID;
    public int cAutor;
    public String commentText;
    public String date;

    public Comments(int commentID, int articleID, int cAutor, String commentText, String date) {
        this.commentID = commentID;
        this.articleID = articleID;
        this.cAutor = cAutor;
        this.commentText = commentText;
        this.date = date;
    }

    public Comments() {
    }

    public Comments(int commentID, int articleID, String commentText, String date) {
        this.commentID = commentID;
        this.articleID = articleID;
        this.commentText = commentText;
        this.date = date;
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

    public int getcAutor() {
        return cAutor;
    }

    public void setcAutor(int cAutor) {
        this.cAutor = cAutor;
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
        return "Comments{" + "commentID=" + commentID + ", articleID=" + articleID + ", cAutor=" + cAutor + ", commentText=" + commentText + ", date=" + date + '}';
    }
}
