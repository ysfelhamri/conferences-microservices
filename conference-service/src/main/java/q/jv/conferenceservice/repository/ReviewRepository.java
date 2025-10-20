package q.jv.conferenceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import q.jv.conferenceservice.entities.Review;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
