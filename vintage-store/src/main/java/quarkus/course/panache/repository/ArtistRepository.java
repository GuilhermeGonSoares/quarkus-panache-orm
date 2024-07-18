package quarkus.course.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import quarkus.course.jdbc.Artist;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
