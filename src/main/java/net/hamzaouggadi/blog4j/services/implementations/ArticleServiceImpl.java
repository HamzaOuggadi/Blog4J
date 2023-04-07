package net.hamzaouggadi.blog4j.services.implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hamzaouggadi.blog4j.dtos.ArticleDTO;
import net.hamzaouggadi.blog4j.entities.Article;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;
import net.hamzaouggadi.blog4j.exceptions.ArticleException;
import net.hamzaouggadi.blog4j.mappers.ArticleMapper;
import net.hamzaouggadi.blog4j.repositories.ArticleRepository;
import net.hamzaouggadi.blog4j.services.ArticleService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private ArticleMapper articleMapper;
    private MessageSource messageSource;

    @Override
    public List<ArticleDTO> listArticles() {
        List<Article> articles = articleRepository.findAll();
        if (!CollectionUtils.isEmpty(articles)) {
            List<ArticleDTO> articleDTOS = new ArrayList<>();
            articles.stream().forEach(article -> {
                if (!article.isRemoved()) {
                    articleDTOS.add(articleMapper.articleToArticleDTO(article));
                }
            });
            return articleDTOS;
        } else {
            throw new ArticleException(
                    messageSource.getMessage("article.not.found.id", new Object[]{}, Locale.getDefault()),
                    messageSource.getMessage("article.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_ARTICLE_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArticleDTO getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() ->
                new ArticleException(messageSource.getMessage("article.not.found.id", new Object[]{articleId}, Locale.getDefault()),
                        messageSource.getMessage("article.not.found.front", new Object[]{}, Locale.getDefault()),
                        ApiStatusCode.API_ARTICLE_100,
                        HttpStatus.NOT_FOUND));
        if (!article.isRemoved()) {
            return articleMapper.articleToArticleDTO(article);
        } else {
            throw new ArticleException(messageSource.getMessage("article.not.found.id", new Object[]{articleId}, Locale.getDefault()),
                    messageSource.getMessage("article.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_ARTICLE_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<ArticleDTO> searchArticleByKeyWord(String keyword) {
        List<Article> articles = articleRepository.findByTitleContainingIgnoreCase(keyword);
        if (!CollectionUtils.isEmpty(articles)) {
            List<ArticleDTO> articleDTOS = new ArrayList<>();
            articles.stream().forEach(article -> {
                if (!article.isRemoved()) {
                    articleDTOS.add(articleMapper.articleToArticleDTO(article));
                }
            });
            return articleDTOS;
        } else {
            throw new ArticleException(
                    messageSource.getMessage("article.not.found.keyword", new Object[]{keyword}, Locale.getDefault()),
                    messageSource.getMessage("article.not.found.keyword", new Object[]{keyword}, Locale.getDefault()),
                    ApiStatusCode.API_ARTICLE_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addArticle(ArticleDTO articleDTO) {
        try {
            Article article = articleMapper.articleDTOToArticle(articleDTO);
            article.setRemoved(false);
            article.setPublishDate(new Date());
            articleRepository.save(article);
        } catch (Exception e) {
            throw new ArticleException(
                    messageSource.getMessage("article.add.failed", new Object[]{}, Locale.getDefault()),
                    messageSource.getMessage("article.add.failed.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_ARTICLE_200,
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new ArticleException(
                messageSource.getMessage("article.not.found.id", new Object[]{articleId}, Locale.getDefault()),
                messageSource.getMessage("article.not.found.front", new Object[]{}, Locale.getDefault()),
                ApiStatusCode.API_ARTICLE_100,
                HttpStatus.NOT_FOUND));
        try {
            if (!article.isRemoved()) {
                article.setRemoved(true);
            }
        } catch (Exception e) {
            throw new ArticleException(messageSource.getMessage("article.delete.failed", new Object[]{articleId}, Locale.getDefault()),
                    messageSource.getMessage("article.delete.failed.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_ARTICLE_300,
                    HttpStatus.NOT_FOUND);
        }
    }
}
