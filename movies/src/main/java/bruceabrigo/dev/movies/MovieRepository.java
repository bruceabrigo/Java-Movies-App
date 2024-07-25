package bruceabrigo.dev.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Works as the data access layer for API
// Connects to the database and returns the JSON
// Annotate as repository
// Type will be Movie to view a Movie in the DB
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // Implement automatic queries to skim database via variable names opposed to object IDs
    // Remember that optional ensures system can understand that properties may return NULL
    Optional<Movie> findMovieByImdbId(String imdbId);
}
