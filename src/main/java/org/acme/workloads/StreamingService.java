package org.acme.workloads;

import org.acme.Models.*;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class StreamingService implements IStreamingService {

    private final IStreamingRepository streamingRepository;

    public StreamingService(IStreamingRepository streamingRepository)
    {
        this.streamingRepository = streamingRepository;
    }


    @Override
    public boolean addUser(User user) {
        return streamingRepository.addUser(user);
    }

    @Override
    public User getUser(int Id) {
        return streamingRepository.getUser(Id);
    }

    @Override
    public User login(String email, String fname) {
        return  streamingRepository.login(email, fname);
    }

    @Override
    public List<Series> getSeries() {
        return streamingRepository.getSeries();
    }

    @Override
    public Series getSeries(int id) {
        return streamingRepository.getSeries(id);
    }

    @Override
    public boolean addSeries(SeriesDTO series) {
        return streamingRepository.addSeries(series);
    }

    @Override
    public List<Episode> getEpisodeForSeries(int SID) {
        return streamingRepository.getEpisodeForSeries(SID);
    }

    @Override
    public Episode getEpisode(int id) {
        return streamingRepository.getEpisode((id));
    }

    @Override
    public boolean addEpisode(int seriesID,Episode episode) {
        return streamingRepository.addEpisode(seriesID, episode);
    }

    @Override
    public List<Genre> getGenres() {
        return streamingRepository.getGenres();
    }

    @Override
    public Genre getGenre(int Id) {
        return streamingRepository.getGenre(Id);
    }

    @Override
    public boolean addGenre(Genre genre) {
        return streamingRepository.addGenre(genre);
    }

    @Override
    public List<Series> getSeriesByGenre(int id) {
        return streamingRepository.getSeriesByGenre(id);
    }

    @Override
    public List<Series> getBookmarkedSeries(int UserID) {
        return streamingRepository.getBookmarkedSeries(UserID);
    }

    @Override
    public boolean bookmarkSeries(int UserID, int SeriesID) {
        return streamingRepository.bookmarkSeries(UserID, SeriesID);
    }

    @Override
    public Bookmark getBookMark(int UserID, int SeriesID) {
        return streamingRepository.getBookMark(UserID, SeriesID);
    }

    @Override
    public List<Episode> getWatchedEpisodes(int UserID) {
        return streamingRepository.getWatchedEpisodes(UserID);
    }

    @Override
    public List<Episode> getWatchedEpisodes(int UserID, int SeriesID) {
        return streamingRepository.getWatchedEpisodes(UserID, SeriesID);
    }

    @Override
    public boolean addToWatch(int UserID, int EpisodeID) {
        return streamingRepository.addToWatch(UserID, EpisodeID);
    }

    @Override
    public Watchlist getWatched(int UserID, int EpisodeID) {
        return streamingRepository.getWatched(UserID, EpisodeID);
    }

    @Override
    public Company getCompany(int id) {
        return streamingRepository.getCompany(id);
    }

    @Override
    public boolean addCompany(Company company) {
        return streamingRepository.addCompany(company);
    }

    @Override
    public List<Company> getCompanies() {
        return streamingRepository.getCompanies();
    }


}
