package org.acme.workloads;

import org.acme.Models.Series;
import org.acme.Models.SeriesDTO;
import org.acme.Models.User;

import java.util.List;

public interface IStreamingService {
    boolean addUser(User user);
    User getUser(int Id);
    User login(String email, String fname);

    List<Series> getSeries();
    Series getSeries(int id);
    boolean addSeries(Series series);
}
