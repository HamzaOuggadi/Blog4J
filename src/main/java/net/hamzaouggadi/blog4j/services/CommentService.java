package net.hamzaouggadi.blog4j.services;

import net.hamzaouggadi.blog4j.dtos.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> listComments();
    CommentDTO getComment(Long commentId);
    List<CommentDTO> getCommentsByUser(Long userId);
    List<CommentDTO> getCommentsByArticle(Long articleId);
    void addComment(CommentDTO commentDTO);
    void deleteComment(Long commentId);
}
