package quarkus.course.panache;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class PublisherTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        Publisher publisher = new Publisher("Packt");
        publisher.persist();

        Publisher foundPublisher = Publisher.findById(publisher.id);
        assertNotNull(foundPublisher);
        assertEquals("Packt", foundPublisher.name);
    }
}