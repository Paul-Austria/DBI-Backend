package org.acme.Models;

import javax.persistence.*;

@Entity
@Table(name="streaming.comments")
public class Comments {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @javax.persistence.Id
    int Id;
    String comment;

    @ManyToOne
    @JoinColumn(name = "UserID")
    User parentUser;

    @ManyToOne
    @JoinColumn(name = "SeriesID")
    Series CommentSeries;


    public Series getCommentSeries() {
        return CommentSeries;
    }

    public void setCommentSeries(Series parentSeries) {
        this.CommentSeries = parentSeries;
    }

    public String getParentUser() {
        return parentUser.getFname() + " " +parentUser.getLname();
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
}
