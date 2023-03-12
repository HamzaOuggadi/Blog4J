package net.hamzaouggadi.blog4j;

import jdk.jfr.Category;
import net.hamzaouggadi.blog4j.entities.Article;
import net.hamzaouggadi.blog4j.entities.ArticleCategory;
import net.hamzaouggadi.blog4j.entities.BlogUser;
import net.hamzaouggadi.blog4j.entities.Comment;
import net.hamzaouggadi.blog4j.repositories.ArticleRepository;
import net.hamzaouggadi.blog4j.repositories.BlogUserRepository;
import net.hamzaouggadi.blog4j.repositories.CommentRepository;
import net.hamzaouggadi.blog4j.services.BlogUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Blog4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Blog4jApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BlogUserRepository blogUserRepository,
                            ArticleRepository articleRepository,
                            CommentRepository commentRepository) {
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

            for (int i=0; i<5; i++) {
                Stream.of("Title 1 : Lorem ipsum dolor sit amet",
                        "Title 2 : Lorem ipsum dolor sit amet",
                        "Title 3 : Lorem ipsum dolor sit amet").forEach(title -> {
                    Article article = new Article();
                    article.setTitle(title);
                    article.setContent("Mauris a nisl vel nibh efficitur ullamcorper. Phasellus in urna felis. Aenean semper nulla vel ipsum dapibus, quis commodo nisl porta. Suspendisse consequat, elit in molestie ullamcorper, magna sem interdum massa, et varius diam turpis ut purus. Cras malesuada eu quam non vehicula. Vivamus vehicula lectus id nisl dictum rutrum. Pellentesque quam nisl, rhoncus nec augue ut, bibendum venenatis ligula.");
                    article.setCategory(new ArrayList<>());
                    article.setPublishDate(new Date());
                    article.setImages(new ArrayList<>());
                    article.setComments(new ArrayList<>());
                    article.setWriter(blogUserRepository.findById(1L).orElseThrow());
                    articleRepository.save(article);
                });
            }

            for (int i=0; i<5; i++) {
                Stream.of("Commentaire 1", "Commentaire 2", "Commentaire 3").forEach(cmnt -> {
                    Comment comment = new Comment();
                    comment.setContent(cmnt);
                    comment.setLikes((int) (Math.random() * 100));
                    comment.setPublishDate(new Date());
                    comment.setWriter(blogUserRepository.findById(1L).orElseThrow());
                    comment.setArticle(articleRepository.findById(1L).orElseThrow());
                    comment.setRemoved(false);
                    commentRepository.save(comment);
                });
            }
        };
    }
}
