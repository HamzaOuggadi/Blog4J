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
public class Writer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profilePhoto;
    private LocalDate registerDate;
    @OneToMany
    private List<Article> articles;
    @OneToMany(mappedBy = "writer")
    private List<Comment> comments;
    private boolean isBanned;
}
