package bruceabrigo.dev.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Works as the data access layer for API
// Connects to the database and returns the JSON
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // Implement automatic queries to skim database via variable names opposed to object IDs
    Optional<Movie> findMovieByImdbId(String imdbId);
}
