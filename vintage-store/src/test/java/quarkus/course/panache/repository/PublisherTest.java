package quarkus.course.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import quarkus.course.panache.model.Publisher;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class PublisherTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        Publisher publisher = new Publisher("Packet");
        publisher.persist();

        Publisher foundPublisher = Publisher.findById(publisher.id);
        assertNotNull(foundPublisher);
        assertEquals("Packet", foundPublisher.name);
    }
}