package net.hamzaouggadi.blog4j.mappers;

import net.hamzaouggadi.blog4j.dtos.ArticleCategoryDTO;
import net.hamzaouggadi.blog4j.entities.ArticleCategory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface ArticleCategoryMapper {
    ArticleCategoryDTO articleCategoryToArticleCategoryDTO(ArticleCategory articleCategory);
    ArticleCategory articleCategoryDTOToArticleCategory(ArticleCategoryDTO articleCategoryDTO);
}
