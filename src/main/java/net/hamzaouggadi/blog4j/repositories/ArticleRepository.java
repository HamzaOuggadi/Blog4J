package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitleLike(String keyword);
    List<Article> findByTitleContainingIgnoreCase(String keyword);
}
