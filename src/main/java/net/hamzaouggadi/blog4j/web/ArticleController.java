package net.hamzaouggadi.blog4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.ArticleDTO;
import net.hamzaouggadi.blog4j.services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
@AllArgsConstructor
public class ArticleController {
    private ArticleService articleService;

    @GetMapping(params = "articleId")
    public ResponseEntity<ArticleDTO> getArticle(@RequestParam Long articleId) {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }

    @GetMapping(params = "keyword")
    public ResponseEntity<List<ArticleDTO>> searchArticles(@RequestParam String keyword) {
        return ResponseEntity.ok(articleService.searchArticleByKeyWord(keyword));
    }
}
