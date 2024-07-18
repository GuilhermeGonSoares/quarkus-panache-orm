package quarkus.course.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import quarkus.course.jdbc.Artist;
import quarkus.course.jpa.Customer;
import quarkus.course.panache.model.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class PurchaseOrderRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPurchaseOrder() {
        // Creates an Artist
        var artist = new Artist("artist name", "artist surname");
        // Creates a Publisher
        var publisher = new Publisher("publisher name");
        // Creates a Book
        var book = new Book();
        book.title = "book title";
        book.nbOfPages = 500;
        book.language = Language.ENGLISH;
        book.price = new BigDecimal(20);
        // Sets the relationships
        book.publisher = publisher;
        book.artist = artist;
        // Persists the Book
        book.persist();

        //Creates a customer
        var customer = new Customer("John", "Doe", "johndoe@email.com");
        customerRepository.persist(customer);

        //Create an order line
        var orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        // Creates a Purchase Order
        var purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLine(orderLine);
        // Persists the Purchase Order
        purchaseOrder.persist();

    }
}