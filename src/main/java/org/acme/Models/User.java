package org.acme.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "streaming.user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String fname;
    private String lname;
    private String password;
    private String Image;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<Bookmark>();

    @OneToMany(mappedBy = "watchUser")
    private List<Watchlist> watchlists = new ArrayList<Watchlist>();

    @OneToMany(mappedBy = "logUser")
    private List<LogInfo> logInfos = new ArrayList<>();

    @OneToMany(mappedBy = "parentUser")
    private List<Comments> comments = new ArrayList<>();


    public void setLogInfos(List<LogInfo> logInfos) {
        this.logInfos = logInfos;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setWatchlists(List<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
