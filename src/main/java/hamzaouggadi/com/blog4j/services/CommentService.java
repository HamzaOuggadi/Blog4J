package hamzaouggadi.com.blog4j.services;

import hamzaouggadi.com.blog4j.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long commentId);
    List<Comment> getCommentsByArticleId(Long articleId);
    List<Comment> getCommentsByWriterId(Long writerId);
    void addComment(Comment comment);
    void editComment(Comment comment);
    void deleteCommentById(Long commentId);
}
