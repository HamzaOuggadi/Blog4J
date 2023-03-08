package net.hamzaouggadi.blog4j.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.hamzaouggadi.blog4j.entities.ArticleCategory;
import net.hamzaouggadi.blog4j.entities.BlogUser;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {
    private String title;
    private String content;
    private List<String> images;
    private List<ArticleCategory> articleCategories;
    private BlogUser writer;
}
