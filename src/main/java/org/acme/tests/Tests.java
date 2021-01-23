package org.acme.tests;

import org.acme.Models.User;
import org.acme.workloads.StreamingRepository;
import org.acme.workloads.StreamingService;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class Tests {

    @Test
    public void addUser_andLogin(){

        var user = new User();
        user.setEmail("new@email");
        user.setFname("testName");
        user.setImage("Image");
        user.setLname("LastName");
        user.setPassword("password");
        var repoMock = Mockito.mock(StreamingRepository.class);
        Mockito.when(repoMock.getUser(anyInt())).thenReturn(null);
        Mockito.when(repoMock.addUser(user)).thenReturn(true);
        ArgumentCaptor<User> storedPerson = ArgumentCaptor.forClass(User.class);

        var service = new StreamingService(repoMock);
        var res = service.addUser(user);

        Mockito.verify(repoMock, Mockito.times(1)).login(user.getEmail(), user.getPassword());
        var personEntity = storedPerson.getValue();
        assertThat(personEntity).isNotNull();
    }
}
