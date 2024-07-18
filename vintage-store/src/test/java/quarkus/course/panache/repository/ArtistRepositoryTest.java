package quarkus.course.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import quarkus.course.jdbc.Artist;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ArtistRepositoryTest {

    @Inject
    ArtistRepository artistRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnArtist() {
        Artist artist = new Artist("John Doe", "bio");
        artistRepository.persist(artist);

        Artist foundArtist = artistRepository.findById(artist.getId());
        assertNotNull(foundArtist);
        assertEquals("John Doe", foundArtist.getName());
    }
}