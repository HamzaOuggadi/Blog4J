package hamzaouggadi.com.blog4j.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToMany
    private List<Image> images;
    @OneToMany
    private List<Category> categories;
    @ManyToOne
    private Writer writer;
    @OneToMany
    private List<Comment> comments;
    private LocalDate publishDate;
    private boolean show;
}
