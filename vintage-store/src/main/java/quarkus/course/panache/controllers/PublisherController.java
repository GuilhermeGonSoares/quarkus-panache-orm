package quarkus.course.panache.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import quarkus.course.jdbc.Artist;
import quarkus.course.panache.model.Publisher;
import quarkus.course.panache.repository.ArtistRepository;

import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherController {


    @GET
    @Path("{id}")
    public Publisher findPublisherById(@PathParam("id") Long id) {
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findAllArtists() {
        return Publisher.listAll();
    }
}
