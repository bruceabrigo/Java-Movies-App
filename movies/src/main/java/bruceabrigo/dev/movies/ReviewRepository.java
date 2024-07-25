package bruceabrigo.dev.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Type will be called Review for Reviews
// Annotate as repository
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
