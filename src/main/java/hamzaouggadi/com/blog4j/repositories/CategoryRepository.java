package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
