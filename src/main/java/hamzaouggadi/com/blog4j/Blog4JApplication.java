package hamzaouggadi.com.blog4j;

import com.github.javafaker.Faker;
import hamzaouggadi.com.blog4j.entities.Article;
import hamzaouggadi.com.blog4j.entities.Category;
import hamzaouggadi.com.blog4j.entities.Comment;
import hamzaouggadi.com.blog4j.entities.Writer;
import hamzaouggadi.com.blog4j.repositories.ArticleRepository;
import hamzaouggadi.com.blog4j.repositories.CategoryRepository;
import hamzaouggadi.com.blog4j.repositories.CommentRepository;
import hamzaouggadi.com.blog4j.repositories.WriterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Blog4JApplication {

    public static void main(String[] args) {
        SpringApplication.run(Blog4JApplication.class, args);
    }

    @Bean
    CommandLineRunner start(WriterRepository writerRepository,
                            ArticleRepository articleRepository,
                            CommentRepository commentRepository,
                            CategoryRepository categoryRepository) {
        return args -> {
            Faker faker = new Faker();

            Writer writer = Writer.builder()
                    .username("hamza")
                    .email("hamza@gmail.com")
                    .isBanned(false)
                    .password("1234")
                    .registerDate(LocalDate.now())
                    .build();

            writerRepository.save(writer);

            Comment comment = Comment.builder()
                    .writer(writer)
                    .content(faker.lorem().paragraph(1))
                    .likes(3)
                    .show(true)
                    .build();

            commentRepository.save(comment);

            Category category = Category.builder()
                    .title("Tourism")
                    .build();

            categoryRepository.save(category);

            Article article = Article.builder()
                    .title(faker.lorem().paragraph(1))
                    .content(faker.lorem().paragraph(10))
                    .writer(writer)
                    .publishDate(LocalDate.now())
                    .show(true)
                    .categories(List.of(category))
                    .comments(List.of(comment))
                    .build();

            articleRepository.save(article);
        };
    }

}
