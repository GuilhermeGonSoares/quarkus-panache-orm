package quarkus.course.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {
    public String title;
    public Duration duration;
    public Instant createdDate = Instant.now();
    @ManyToOne
    @JoinColumn(name = "cd_fk")
    public CD cd;
}
