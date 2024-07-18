package quarkus.course.jdbc;



import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {

    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException {
        var conn = dataSource.getConnection();
        var sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?, ?, ?, ?)";
        artist.setId(Math.abs(new Random().nextLong()));

        try (var ps = conn.prepareStatement(sql)) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setObject(4, artist.getCreatedDate());
            ps.executeUpdate();
        }

        conn.close();

    }

    public Artist findById(Long id) throws SQLException {
        var conn = dataSource.getConnection();
        var sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";
        Artist artist = null;
        try (var ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                artist = new Artist();
                artist.setId(rs.getLong("id"));
                artist.setName(rs.getString("name"));
                artist.setBio(rs.getString("bio"));
                artist.setCreatedDate(rs.getTimestamp(4).toInstant());
                return artist;
            }
        }
        conn.close();

        return artist;
    }
}