package org.acme.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "streaming.company")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Series> series;

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
