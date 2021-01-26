package org.acme.Models;

import javax.persistence.*;

@Entity
@Table(name = "streaming.bookmark")
public class Bookmark {


    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int Id;
    @ManyToOne
    @JoinColumn(name = "userid")
    User user;
    @ManyToOne
    @JoinColumn(name = "seriesid")
    Series BookmarkSeries;

    public Bookmark() {
    }

    public Bookmark(User user, Series series) {
        this.user = user;
        this.BookmarkSeries = series;
    }
/*
    public int getId() {
        return Id;
    }
*/
    public void setId(int id) {
        Id = id;
    }
 /*   public User getUser() {
        return user;
    }
*/
    public void setUser(User user) {
        this.user = user;
    }

    public Series getBookmarkSeries() {
        return BookmarkSeries;
    }

    public void setBookmarkSeries(Series series) {
        this.BookmarkSeries = series;
    }
}
