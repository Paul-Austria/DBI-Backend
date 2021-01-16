package org.acme.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "streaming.genre")
public class Genre {
    @Id
    int id;
    String name;

    @OneToMany(mappedBy = "genre")
    private List<Series> series = new ArrayList<Series>();



    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
