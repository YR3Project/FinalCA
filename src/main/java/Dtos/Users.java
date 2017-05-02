
package Dtos;
//Author Ben
import java.util.Objects;

public class Users implements Comparable<Users> {
    private int UserID;
    private String UserName;
    private String Email;
    private String Password;
    private String Country;
    private int Admin;
    private String Salt;
    private String Created;
    private String Due;
    private String PicPath;

    public Users() {
    }

    public Users(int UserID, String UserName, String Email, String Password, String Country, int Admin, String Salt, String Created, String Due) {
        this.UserID = UserID;
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.Country = Country;
        this.Admin = Admin;
        this.Salt = Salt;
        this.Created = Created;
        this.Due = Due;
    }

    public Users(String UserName, String Email, String Password, String Country, int Admin, String Salt, String Created, String Due) {
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.Country = Country;
        this.Admin = Admin;
        this.Salt = Salt;
        this.Created = Created;
        this.Due = Due;
    }
    
    public Users(String UserName, String Email, String Password, String Country, int Admin, String Salt, String Created, String Due, String PicPath) {
        this.UserName = UserName;
        this.Email = Email;
        this.Password = Password;
        this.Country = Country;
        this.Admin = Admin;
        this.Salt = Salt;
        this.Created = Created;
        this.Due = Due;
        this.PicPath = PicPath;
    }

    public int getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public int getAdmin() {
        return Admin;
    }

    public String getSalt() {
        return Salt;
    }

    public String getCreated() {
        return Created;
    }

    public String getDue() {
        return Due;
    }
    public String getPicPath() {
        return PicPath;
    }
    
    public String getCountry() {
        return Country;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    public void setPicPath(String PicPath) {
        this.PicPath = PicPath;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setAdmin(int Admin) {
        this.Admin = Admin;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }

    public void setCreated(String Created) {
        this.Created = Created;
    }

    public void setDue(String Due) {
        this.Due = Due;
    }
    
    public void setCountry(String Country){
        this.Country = Country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.UserID;
        hash = 67 * hash + Objects.hashCode(this.UserName);
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.UserID != other.UserID) {
            return false;
        }
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Users{" + "UserID=" + UserID + ", UserName=" + UserName + ", Email=" + Email + ", Password=" + Password + ", Country=" + Country + ", Admin=" + Admin + ", Salt=" + Salt + ", Created=" + Created + ", Due=" + Due + '}';
    }

    @Override
    public int compareTo(Users o) {
        if(this.UserID > o.UserID)
        {
            return +1;
        }
        if(this.UserID < o.UserID)
        {
            return -1;
        }
        else 
            return 0;
    }

   
    
    
}
