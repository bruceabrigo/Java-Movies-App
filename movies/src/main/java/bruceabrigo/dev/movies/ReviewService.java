package bruceabrigo.dev.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    // Create refrence to the review repository
    @Autowired
    private ReviewRepository reviewRepository;
    // Form dynamic query without using the repos
    @Autowired
    // Create a Mongo Template
    private MongoTemplate mongoTemplate;
    // Review method creates a String body via reference to imdbId
    public Review createReview(String reviewBody, String imdbId) {
        // use review as a parameter to insert into the MongoDB reviewRepo
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                // Update definition
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
