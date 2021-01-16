package org.acme.workloads;

import org.acme.Models.Episode;
import org.acme.Models.Genre;
import org.acme.Models.Series;
import org.acme.Models.User;

import java.util.List;

public interface IStreamingRepository {

    User getUser(int Id);
    boolean addUser(User user);

    User login(String email, String fname);

    List<Series> getSeries();

    Series getSeries(int id);
    boolean addSeries(Series series);

    List<Episode>  getEpisodeForSeries(int SID);
    Episode getEpisode(int id);
    boolean addEpisode(int SeriesID, Episode episode);

    List<Genre> getGenres();
    Genre getGenre(int Id);
    boolean addGenre(Genre genre);
    List<Series> getSeriesByGenre(int id);
}
