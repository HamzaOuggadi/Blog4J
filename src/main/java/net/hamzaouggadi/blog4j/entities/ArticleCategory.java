package net.hamzaouggadi.blog4j.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Embeddable
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
}
