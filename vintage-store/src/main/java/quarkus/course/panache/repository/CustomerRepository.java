package quarkus.course.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import quarkus.course.jdbc.Artist;
import quarkus.course.jpa.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
