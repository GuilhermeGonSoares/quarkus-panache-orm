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
        var count = artistRepository.count();
        var listAll = artistRepository.listAll().size();
        assertEquals(count, listAll);
        assertEquals(artistRepository.listAllArtistsSorted().size(), listAll);
        Artist artist = new Artist("John Doe", "bio");
        artistRepository.persist(artist);

        assertEquals(count + 1, artistRepository.count());

        Artist foundArtist = artistRepository.findById(artist.getId());
        assertNotNull(foundArtist);
        assertEquals("John Doe", foundArtist.getName());

        artistRepository.deleteById(artist.getId());
        assertEquals(count, artistRepository.count());
    }
}