package Dtos;

public class Article {
    private int articleID;
    private int authorID;
    private String title;
    private String articleText;
    private String game;
    private String date;
    

    public Article(int articleID, int authorID, String title, String articleText, String game, String date) {
        this.articleID = articleID;
        this.authorID = authorID;
        this.title = title;
        this.articleText = articleText;
        this.game = game;
        this.date = date;
    }

    public int getArticleID() {
        return articleID;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleText() {
        return articleText;
    }

    public String getGame() {
        return game;
    }

    public String getDate() {
        return date;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" + "articleID=" + articleID + ", authorID=" + authorID + ", title=" + title + ", articleText=" + articleText + ", game=" + game + ", date=" + date + '}';
    }
}
