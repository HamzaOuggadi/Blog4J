package net.hamzaouggadi.blog4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.ArticleDTO;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;
import net.hamzaouggadi.blog4j.exceptions.GenericResponse;
import net.hamzaouggadi.blog4j.services.ArticleService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/articles")
@AllArgsConstructor
public class ArticleController {
    private ArticleService articleService;
    private MessageSource messageSource;

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getArticles() {
        return ResponseEntity.ok(articleService.listArticles());
    }

    @GetMapping(params = "articleId")
    public ResponseEntity<ArticleDTO> getArticle(@RequestParam Long articleId) {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<ArticleDTO>> searchArticles(@RequestParam String keyword) {
        return ResponseEntity.ok(articleService.searchArticleByKeyWord(keyword));
    }

    @PostMapping("/addArticle")
    public ResponseEntity<GenericResponse> addArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.addArticle(articleDTO);
        GenericResponse response = new GenericResponse();
        response.setDescription(messageSource.getMessage("article.add.success", new Object[]{articleDTO.getTitle()}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("article.add.success.front", new Object[]{articleDTO.getTitle()}, Locale.getDefault()));
        response.setError(false);
        response.setStatusCode(ApiStatusCode.API_ARTICLE_400);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/removeArticle")
    public ResponseEntity<GenericResponse> removeArticle(@RequestParam Long articleId) {
        articleService.deleteArticle(articleId);
        GenericResponse response = new GenericResponse();
        response.setDescription(messageSource.getMessage("article.delete.success", new Object[]{articleId}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("article.delete.success.front", new Object[]{}, Locale.getDefault()));
        response.setError(false);
        response.setStatusCode(ApiStatusCode.API_ARTICLE_300);
        return ResponseEntity.ok(response);
    }
}
