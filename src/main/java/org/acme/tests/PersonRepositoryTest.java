package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.Models.*;
import org.acme.workloads.StreamingRepository;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.*;

@QuarkusTest
public class PersonRepositoryTest extends org.acme.TestBase {

    @Inject
    private StreamingRepository streamingRepository;

    @Test
    public void addPerson_getPerson_simple_success() {
        var personToAdd = new User();
        personToAdd.setEmail("admin@admin.xyz");
        personToAdd.setImage("admin.png");
        personToAdd.setFname("admin");
        personToAdd.setLname("admin");
        personToAdd.setPassword("admin");

        assertThatCode(()->streamingRepository.addUser(personToAdd)).doesNotThrowAnyException();
        var loadedPerson = streamingRepository.getUser(personToAdd.getId());

        assertThat(loadedPerson).isNotNull().isEqualTo(personToAdd);
    }

    @Test
    public void getPerson_notExists(){
        AtomicReference<User> loadedPerson = new AtomicReference<>();
        assertThatCode(()->{
            loadedPerson.set(streamingRepository.getUser(0));
        }).doesNotThrowAnyException();

        assertThat(loadedPerson.get()).isNull();
    }

    @Test
    public void addGenre_test() {
        var genre = new Genre();
        genre.setName("Action");

        assertThatCode(()->streamingRepository.addGenre(genre)).doesNotThrowAnyException();
        var loadedPerson = streamingRepository.getGenre(genre.getId());

        assertThat(loadedPerson).isNotNull().isEqualTo(genre);
    }

    @Test
    public void addSeries() {
        var series = new SeriesDTO();
        series.setEpisodeCount(12);
        series.setName("Series");
        series.setAirDate(new Date());
        series.setDescription("Desc");
        series.setRating(4.9f);

        assertThatCode(()->streamingRepository.addSeries(series)).doesNotThrowAnyException();
    }

    @Test
    public void addCompany() {
        var personToAdd = new Company();
        personToAdd.setName("Fox News");

        assertThatCode(()->streamingRepository.addCompany(personToAdd)).doesNotThrowAnyException();
        var loadedPerson = streamingRepository.getCompany(personToAdd.getId());

        assertThat(loadedPerson).isNotNull().isEqualTo(personToAdd);
    }
}