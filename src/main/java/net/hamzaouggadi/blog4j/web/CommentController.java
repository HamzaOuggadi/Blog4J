package net.hamzaouggadi.blog4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.CommentDTO;
import net.hamzaouggadi.blog4j.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping(params = "userId")
    public ResponseEntity<List<CommentDTO>> getCommentsByUser(@RequestParam Long userId) {
        return ResponseEntity.ok(commentService.getCommentsByUser(userId));
    }
}
