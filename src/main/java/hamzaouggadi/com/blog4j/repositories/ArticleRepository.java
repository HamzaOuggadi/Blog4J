package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
