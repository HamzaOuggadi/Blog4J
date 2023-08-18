package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticleId(Long articleId);
    List<Comment> findByWriterId(Long writerId);
}
