package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
