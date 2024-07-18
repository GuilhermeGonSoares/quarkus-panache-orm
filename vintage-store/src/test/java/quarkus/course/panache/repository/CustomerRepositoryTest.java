package quarkus.course.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import quarkus.course.jpa.Customer;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() {
        var customer = new Customer("John", "Doe", "johndoe@email.com");
        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        var foundCustomer = customerRepository.findById(customer.getId());
        assertEquals(customer.getId(), foundCustomer.getId());
        assertEquals(customer.getFirstName(), foundCustomer.getFirstName());
    }

}