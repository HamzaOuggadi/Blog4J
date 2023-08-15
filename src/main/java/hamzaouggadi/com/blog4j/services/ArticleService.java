package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleById(Long articleId);
    List<Article> getArticlesByWriterId(Long writerId);
    void addArticle(Article article);
    void editArticle(Article article);
    void deleteArticleById(Long articleId);
}
