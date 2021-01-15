package org.acme.workloads;

import org.acme.Models.Series;
import org.acme.Models.User;

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
    public boolean addSeries(Series series) {
        entityManager.persist(series);
        return true;
    }
}
