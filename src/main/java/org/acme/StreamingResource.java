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
    public Response addSeries(SeriesDTO series){
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

    @GET
    @Path("Bookmark/{userID}")
    public Response getBookmarks(@PathParam("userID") int UserID)
    {
        return Response.ok(streamingService.getBookmarkedSeries(UserID)).build();
    }

    @GET
    @Path("Bookmark/{userID}/{seriesID}")
    public Response getBookmark(@PathParam("userID") int UserID, @PathParam("seriesID") int SeriesID)
    {
        if(streamingService.getBookMark(UserID, SeriesID) == null)
        {
            return Response.ok(false).build();
        }

        return Response.ok(true).build();
    }

    @POST
    @Transactional
    @Path("Bookmark/{userID}/{seriesID}")
    public Response Bookmark(@PathParam("userID") int UserID, @PathParam("seriesID") int SeriesID)
    {
        return Response.ok(streamingService.bookmarkSeries(UserID, SeriesID)).build();
    }

    @GET
    @Path("Watchlist/{userID}")
    public Response WatchList(@PathParam("userID") int UserID)
    {
        return Response.ok(streamingService.getWatchedEpisodes(UserID)).build();
    }

    @GET
    @Path("Series/Watchlist/{userID}/{SeriesID}")
    public Response WatchList(@PathParam("userID") int UserID, @PathParam("SeriesID") int SeriesID)
    {
        return Response.ok(streamingService.getWatchedEpisodes(UserID, SeriesID)).build();
    }

    @POST
    @Transactional
    @Path("WatchList/{userID}/{EpisodeID}")
    public Response addWatch(@PathParam("userID") int UserID, @PathParam("EpisodeID") int EpisodeID)
    {
        return Response.ok(streamingService.addToWatch(UserID, EpisodeID)).build();
    }

    @GET
    @Path("hasWatched/{userID}/{EpisodeID}")
    public Response getWatch(@PathParam("userID") int UserID, @PathParam("EpisodeID") int EpisodeID)
    {
        return Response.ok(streamingService.getWatched(UserID, EpisodeID) != null).build();
    }

    @POST
    @Transactional
    @Path("Company")
    public Response addCompany(Company company)
    {
        boolean result = streamingService.addCompany(company);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("Company/{id}")
    public Response GetCompany(@PathParam("id") int id)
    {
        return Response.ok(streamingService.getCompany(id)).build();
    }

    @GET
    @Path("Company")
    public Response getCompanies(){
        return Response.ok(streamingService.getCompanies()).build();
    }

    @POST
    @Transactional
    @Path("Comment")
    public Response Comment(CommentDTO commentTDO){
        System.out.println(commentTDO);
        boolean result = streamingService.comment(commentTDO);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();

    }

    @GET
    @Path("Comments/{SeriesID}")
    public Response getComments(@PathParam("SeriesID") int id)
    {
        return Response.ok(streamingService.getComments(id)).build();
    }
}