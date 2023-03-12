package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.dtos.CommentDTO;
import net.hamzaouggadi.blog4j.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByWriterId(Long userId);
    List<Comment> findByArticleId(Long articleId);

}
