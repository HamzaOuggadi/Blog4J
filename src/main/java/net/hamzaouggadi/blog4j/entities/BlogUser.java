package net.hamzaouggadi.blog4j.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Date createdAt;
    @OneToMany(mappedBy = "writer")
    private List<Article> articles;
    @OneToMany(mappedBy = "writer")
    private List<Comment> comments;
}