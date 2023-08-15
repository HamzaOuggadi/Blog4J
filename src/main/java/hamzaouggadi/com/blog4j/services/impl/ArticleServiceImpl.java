package hamzaouggadi.com.blog4j.services.impl;

import hamzaouggadi.com.blog4j.entities.Article;
import hamzaouggadi.com.blog4j.entities.Writer;
import hamzaouggadi.com.blog4j.repositories.ArticleRepository;
import hamzaouggadi.com.blog4j.repositories.WriterRepository;
import hamzaouggadi.com.blog4j.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final WriterRepository writerRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long articleId) throws Exception {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if (optionalArticle.isPresent()) {
            return optionalArticle.get();
        } else {
            throw new Exception("Article Not Found !");
        }
    }

    @Override
    public List<Article> getArticlesByWriterId(Long writerId) throws Exception {
        Optional<Writer> optionalWriter = writerRepository.findById(writerId);
        if (optionalWriter.isPresent()) {
            return articleRepository.findArticlesByWriterId(optionalWriter.get().getId());
        } else {
            throw new Exception("Article Not Found !");
        }
    }

    @Override
    public void addArticle(Article article, Long writerId) throws Exception {
        Optional<Writer> optionalWriter = writerRepository.findById(writerId);
        if (optionalWriter.isPresent()) {
            Writer writer = optionalWriter.get();
            article.setWriter(writer);
            articleRepository.save(article);
        } else {
            throw new Exception("Writer Not Found !");
        }
    }

    @Override
    public void editArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticleById(Long articleId) throws Exception {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setShow(false);
            articleRepository.save(article);
        } else {
            throw new Exception("Article Not Found !");
        }
    }
}
