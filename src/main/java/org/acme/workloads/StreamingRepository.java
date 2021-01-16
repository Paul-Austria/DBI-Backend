package org.acme.workloads;

import org.acme.Models.*;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class StreamingRepository  implements IStreamingRepository{
    private final EntityManager entityManager;

    public StreamingRepository(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public User getUser(int Id) {
        var query = entityManager.createQuery("select p from User p where p.id = :Id", User.class);
        query.setParameter("Id", Id);

        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean addUser(User user) {
        if(getUser(user.getId()) == null)
        {
            entityManager.persist(user);
            return true;
        }
        return false;
    }



    @Override
    public User login(String email, String fname) {
        var query = entityManager.createQuery("select p from User p where p.email = :email and p.password = :fname", User.class);
        query.setParameter("email", email);
        query.setParameter("fname", fname);

        return query.getResultStream().findFirst().orElse(null);

    }

    @Override
    public List<Series> getSeries() {
        var query = entityManager.createQuery("select p from Series p", Series.class);
        return query.getResultList();
    }

    @Override
    public Series getSeries(int id) {
        var query = entityManager.createQuery("select p from Series p where p.Id = :Id", Series.class);
        query.setParameter("Id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean addSeries(SeriesDTO series) {
        Series seriesD = new Series();
        seriesD.setAirDate(series.getAirDate());
        seriesD.setCompany(getCompany(series.getCompanyid()));
        seriesD.setDescription(series.getDescription());
        seriesD.setGenre(getGenre(series.getGenreid()));
        seriesD.setName(series.getName());
        seriesD.setRating(series.getRating());
        seriesD.setImage(series.getImage());
        seriesD.setEpisodeCount(0);
        entityManager.persist(seriesD);
        return true;
    }

    @Override
    public List<Episode> getEpisodeForSeries(int SID) {
        var query = entityManager.createQuery("select p from Episode p where p.parent = :Id", Episode.class);
        query.setParameter("Id", getSeries(SID));
        return query.getResultList();
    }

    @Override
    public Episode getEpisode(int id) {
        var query = entityManager.createQuery("select p from Episode p where p.id = :Id", Episode.class);
        query.setParameter("Id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean addEpisode(int SeriesID,Episode episode) {
        if(getSeries(SeriesID) == null) return false;
        episode.setParent(getSeries(SeriesID));
        Series series = getSeries(SeriesID);
        series.setEpisodeCount(series.getEpisodeCount()+1);
        entityManager.persist(episode);
        return true;
    }

    @Override
    public List<Genre> getGenres() {
        var query = entityManager.createQuery("select p from Genre p", Genre.class);
        return query.getResultList();
    }

    @Override
    public Genre getGenre(int Id) {
        var query = entityManager.createQuery("select p from Genre p where p.id = :ID", Genre.class);
        query.setParameter("ID", Id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean addGenre(Genre genre) {
        entityManager.persist(genre);
        return true;
    }

    @Override
    public List<Series> getSeriesByGenre(int id) {
        var query =  entityManager.createQuery("select g from Series g where g.genre = :genre");
        query.setParameter("genre", getGenre(id));
        return query.getResultList();
    }

    @Override
    public List<Series> getBookmarkedSeries(int UserID) {
        var query =  entityManager.createQuery("select g from Bookmark g where g.user = :user");
        query.setParameter("user", getUser(UserID));
        return query.getResultList();
    }

    @Override
    public boolean bookmarkSeries(int UserID, int SeriesID) {
        if(getBookMark(UserID, SeriesID) == null)
        {
            Bookmark b = new Bookmark(getUser(UserID), getSeries(SeriesID));
            entityManager.persist(b);
            return true;
        }
        else
        {
            entityManager.remove(getBookMark(UserID, SeriesID));
            return false;
        }
    }

    @Override
    public Bookmark getBookMark(int UserID, int SeriesID) {
        var query = entityManager.createQuery("Select b from Bookmark b where  b.user = :user and b.series = :series", Bookmark.class);
        query.setParameter("user", getUser(UserID));
        query.setParameter("series", getSeries(SeriesID));
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Episode> getWatchedEpisodes(int UserID) {
        var query = entityManager.createQuery("Select w from Watchlist w where w.parentUser = :user");
        query.setParameter("user", getUser(UserID));

        return query.getResultList();
    }

    @Override
    public List<Episode> getWatchedEpisodes(int UserID, int SeriesID) {
        var query = entityManager.createQuery("Select w from Watchlist w where w.parentUser = :user and w.parentEpisode.parent = :series");
        query.setParameter("user", getUser(UserID));
        query.setParameter("series", getSeries(SeriesID));
        return query.getResultList();
    }

    @Override
    public boolean addToWatch(int UserID, int EpisodeID) {
        if(getWatched(UserID, EpisodeID) == null)
        {
            Watchlist w = new Watchlist();
            w.setParentUser(getUser(UserID));
            w.setParentEpisode(getEpisode(EpisodeID));
            entityManager.persist(w);
            return true;
        }
        else
        {
            entityManager.remove(getWatched(UserID, EpisodeID));
            return false;
        }
    }

    @Override
    public Watchlist getWatched(int UserID, int EpisodeID) {
        var query = entityManager.createQuery("Select w from Watchlist w where w.parentUser = :user and w.parentEpisode = :episode",Watchlist.class);
        query.setParameter("user", getUser(UserID));
        query.setParameter("episode", getEpisode(EpisodeID));
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Company getCompany(int id) {
        var query = entityManager.createQuery("select p from Company p where p.id = :Id", Company.class);
        query.setParameter("Id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public boolean addCompany(Company company) {
        entityManager.persist(company);
        return true;
    }

    @Override
    public List<Company> getCompanies() {
        var query = entityManager.createQuery("select p from Company p", Company.class);
        return query.getResultList();
    }
}
