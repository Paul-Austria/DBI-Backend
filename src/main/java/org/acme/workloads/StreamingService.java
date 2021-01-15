package org.acme.workloads;

import org.acme.Models.Series;
import org.acme.Models.User;

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
    public boolean addSeries(Series series) {
        return streamingRepository.addSeries(series);
    }


}
