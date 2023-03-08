package net.hamzaouggadi.blog4j;

import net.hamzaouggadi.blog4j.entities.BlogUser;
import net.hamzaouggadi.blog4j.repositories.BlogUserRepository;
import net.hamzaouggadi.blog4j.services.BlogUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Blog4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Blog4jApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BlogUserRepository blogUserRepository) {
        return args -> {
            Stream.of("Hamza", "Asmae", "Jacky").forEach(usr -> {
                BlogUser user = new BlogUser();
                user.setUsername(usr);
                user.setEmail(usr + "@gmail.com");
                user.setPassword("1234");
                user.setCreatedAt(new Date());
                user.setRemoved(false);

                blogUserRepository.save(user);
            });
        };
    }

}
