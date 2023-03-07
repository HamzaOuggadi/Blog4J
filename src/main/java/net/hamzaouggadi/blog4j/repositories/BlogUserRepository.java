package net.hamzaouggadi.blog4j.repositories;

import net.hamzaouggadi.blog4j.entities.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
}
