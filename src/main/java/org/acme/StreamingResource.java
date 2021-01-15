package org.acme;

import org.acme.Models.Login;
import org.acme.Models.Series;
import org.acme.Models.User;
import org.acme.workloads.IStreamingService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stream")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StreamingResource {

    private final IStreamingService streamingService;

    public StreamingResource(IStreamingService streamingService)
    {
        this.streamingService = streamingService;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @Transactional
    @POST
    @Path("User")
    public Response addsUser(User user)
    {
        boolean result = streamingService.addUser(user);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();

    }

    @Transactional
    @POST
    @Path("Login")
    public Response login(Login login)
    {
        User user = streamingService.login(login.getEmail(), login.getPassword());

        return Response.ok(user).build();
    }

    @GET
    @Path("Series/all")
    public Response getSeries()
    {
        return Response.ok(streamingService.getSeries()).build();
    }

    @GET
    @Path("User/{id}")
    public Response getUser(@PathParam("id") int id)
    {
        return Response.ok(streamingService.getUser(id)).build();
    }

    @GET
    @Path("Series/{id}")
    public Response getSeries(@PathParam("id") int id)
    {
        return Response.ok(streamingService.getSeries(id)).build();
    }


    @POST
    @Transactional
    @Path("Series")
    public Response addSeries(Series series){
        boolean result = streamingService.addSeries(series);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}