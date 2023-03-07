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
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ElementCollection
    private List<String> images;
    @OneToMany
    private List<ArticleCategory> category;
    @ManyToOne
    private BlogUser writer;
    private Date publishDate;
    @OneToMany(mappedBy = "article")
    private List<Comment> comments;
}
