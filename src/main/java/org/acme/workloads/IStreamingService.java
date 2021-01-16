package org.acme.workloads;

import org.acme.Models.*;

import java.util.List;

public interface IStreamingService {
    boolean addUser(User user);
    User getUser(int Id);
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
