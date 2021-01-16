package org.acme;

import org.acme.Models.*;
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
    @GET
    @Path("Series/{id}/Episodes")
    public Response getEpisodes(@PathParam("id") int id){
        return Response.ok(streamingService.getEpisodeForSeries(id)).build();
    }

    @GET
    @Path("Episode/{id}")
    public Response getEpisode(@PathParam("id") int id){
        return Response.ok(streamingService.getEpisode(id)).build();
    }

    @POST
    @Transactional
    @Path("Series/{id}/Episode")
    public Response addEpisode(@PathParam("id") int id, Episode episode)
    {
        boolean result = streamingService.addEpisode(id, episode);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("Genre/{id}/Series")
    public Response getSeriesByGenre(@PathParam("id")int id)
    {
        return Response.ok(streamingService.getSeriesByGenre(id)).build();
    }

    @GET
    @Path("Genre")
    public Response getGenres(){
        return Response.ok(streamingService.getGenres()).build();
    }

    @POST
    @Transactional
    @Path("Genre")
    public Response addGenre(Genre genre)
    {
        return Response.ok(streamingService.addGenre(genre)).build();
    }
}