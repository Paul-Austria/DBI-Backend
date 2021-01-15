package org.acme.Models;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "streaming.series")
public class Series {
    @Id
    private int Id;
    private String image;
    private String name;
    private String description;
    private Date airDate;
    private int episodeCount;
    private  int genreid;
    private  float rating;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Date getAirDate() {
        return airDate;
    }

    public void setAirDate(Date airDate) {
        this.airDate = airDate;
    }

    public int getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
