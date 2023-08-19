package hamzaouggadi.com.blog4j.repositories;

import hamzaouggadi.com.blog4j.entities.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WriterRepository extends JpaRepository<Writer, Long> {

    Writer findByEmailIgnoreCase(String email);

    List<Writer> findByUsernameContainsIgnoreCase(String username);
}
