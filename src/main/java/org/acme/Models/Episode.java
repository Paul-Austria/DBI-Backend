package org.acme.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "streaming.episode")
public class Episode {

    @Id
    int id;

    @ManyToOne
    @JoinColumn(name = "seriesId")
    private Series parent;

    String name;
    String description;
    String videoLink;

    @OneToMany(mappedBy = "parentEpisode")
    private List<Watchlist> watchlist = new ArrayList<Watchlist>();

    public List<Watchlist> setWatchList() {
        return watchlist;
    }

    public void setEpisodes(List<Watchlist> episodes) {
        this.watchlist = episodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Series getParent() {
        return parent;
    }

    public void setParent(Series parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}

