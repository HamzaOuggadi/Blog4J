package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
