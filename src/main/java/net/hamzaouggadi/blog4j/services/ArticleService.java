package net.hamzaouggadi.blog4j.services;

import net.hamzaouggadi.blog4j.dtos.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> listArticle();
    ArticleDTO getArticle(Long articleId);
    ArticleDTO searchArticleByKeyWord(String keyword);
    void addArticle(ArticleDTO articleDTO);
    void deleteArticle(Long articleId);
}
