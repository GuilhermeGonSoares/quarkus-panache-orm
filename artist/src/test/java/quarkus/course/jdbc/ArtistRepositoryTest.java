package quarkus.course.jdbc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ArtistRepositoryTest {

    @Inject
    ArtistRepository artistRepository;

    @Test
    public void shouldCreateAndFindArtist() throws SQLException {
        Artist artist = new Artist("John Doe", "Bio of John Doe");
        artistRepository.persist(artist);
        assertNotNull(artist.getId());
        Artist foundArtist = artistRepository.findById(artist.getId());
        assertEquals(artist.getName(), foundArtist.getName());
        assertEquals(artist.getBio(), foundArtist.getBio());
    }
}