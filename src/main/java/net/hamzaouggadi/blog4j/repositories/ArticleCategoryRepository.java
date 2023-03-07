package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.entities.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {
}
