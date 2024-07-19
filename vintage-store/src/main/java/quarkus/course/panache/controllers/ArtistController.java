package quarkus.course.panache.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import quarkus.course.jdbc.Artist;
import quarkus.course.panache.repository.ArtistRepository;

import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistController {
    @Inject
    ArtistRepository artistRepository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id) {
        return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> findAllArtists() {
        return artistRepository.findAll().list();
    }
}
