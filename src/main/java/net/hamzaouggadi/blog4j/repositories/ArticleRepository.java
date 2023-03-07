package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
