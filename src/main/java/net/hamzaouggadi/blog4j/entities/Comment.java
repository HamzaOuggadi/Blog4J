package net.hamzaouggadi.blog4j.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date publishDate;
    private int likes;
    private boolean isRemoved;
    @ManyToOne
    private Article article;
    @ManyToOne
    private BlogUser writer;
}
