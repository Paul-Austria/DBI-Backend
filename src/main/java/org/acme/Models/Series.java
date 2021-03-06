package org.acme.Models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
@Entity
@Table(name = "streaming.series")
public class Series {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    private String image;
    private String name;
    private String description;
    private Date airDate;
    private int episodeCount;

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name="companyID")
    private Company company;
    private  float rating;

    @OneToMany(mappedBy = "parent")
    private List<Episode> episodes = new ArrayList<Episode>();


    @OneToMany(mappedBy = "CommentSeries")
    private List<Comments> comments;

    @OneToMany(mappedBy = "BookmarkSeries")
    private List<Bookmark> bookmarks;




    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public void setRating(float rating) {
        this.rating = rating;
    }
}
