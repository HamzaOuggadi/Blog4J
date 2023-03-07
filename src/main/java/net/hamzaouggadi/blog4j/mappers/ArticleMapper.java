package net.hamzaouggadi.blog4j.mappers;

import net.hamzaouggadi.blog4j.dtos.ArticleDTO;
import net.hamzaouggadi.blog4j.entities.Article;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ArticleMapper {
    ArticleDTO articleToArticleDTO(Article article);
    Article articleDTOToArticle(ArticleDTO articleDTO);
}
