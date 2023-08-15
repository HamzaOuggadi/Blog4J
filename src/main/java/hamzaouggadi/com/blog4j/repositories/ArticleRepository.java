package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByWriterId(Long writerId);
}
