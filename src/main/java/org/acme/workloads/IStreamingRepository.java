package org.acme.workloads;

import org.acme.Models.*;

import java.util.List;

public interface IStreamingRepository {

    User getUser(int Id);
    boolean addUser(User user);
    User getUser(String email);
    User login(String email, String fname);

    List<Series> getSeries();

    Series getSeries(int id);
    boolean addSeries(SeriesDTO series);

    List<Episode>  getEpisodeForSeries(int SID);
    Episode getEpisode(int id);
    boolean addEpisode(int SeriesID, Episode episode);

    List<Genre> getGenres();
    Genre getGenre(int Id);
    boolean addGenre(Genre genre);
    List<Series> getSeriesByGenre(int id);

    List<Series> getBookmarkedSeries(int UserID);
    boolean bookmarkSeries(int UserID, int SeriesID);
    Bookmark getBookMark(int UserID, int SeriesID);

    List<Episode> getWatchedEpisodes(int UserID);
    List<Episode> getWatchedEpisodes(int UserID, int SeriesID);
    boolean addToWatch(int UserID, int EpisodeID);
    Watchlist getWatched(int UserID, int EpisodeID);

    Company getCompany(int id);
    boolean addCompany(Company company);
    List<Company> getCompanies();

    boolean comment(CommentDTO comment);
    List<Comments> getComments(int SeriesID);

    List<LogInfo> getLoginf();
    boolean addLogInfo(User user, String desc);
}
