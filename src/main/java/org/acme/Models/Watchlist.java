package org.acme.Models;

import javax.persistence.*;

@Entity
@Table(name = "streaming.watchlist")
public class Watchlist {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    User parentUser;

    @ManyToOne
    @JoinColumn(name = "episodeid")
    Episode parentEpisode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getParentUser() {
        return parentUser;
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }

    public Episode getParentEpisode() {
        return parentEpisode;
    }

    public void setParentEpisode(Episode parentEpisode) {
        this.parentEpisode = parentEpisode;
    }
}
