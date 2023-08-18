package hamzaouggadi.com.blog4j.services.impl;

import hamzaouggadi.com.blog4j.entities.Article;
import hamzaouggadi.com.blog4j.entities.Comment;
import hamzaouggadi.com.blog4j.repositories.ArticleRepository;
import hamzaouggadi.com.blog4j.repositories.CommentRepository;
import hamzaouggadi.com.blog4j.repositories.WriterRepository;
import hamzaouggadi.com.blog4j.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final WriterRepository writerRepository;
    private final ArticleRepository articleRepository;


    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long commentId) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            return commentOptional.get();
        } else {
            throw new Exception("Comment Not Found !");
        }
    }

    @Override
    public List<Comment> getCommentsByArticleId(Long articleId) throws Exception {
        try {
            return commentRepository.findByArticleId(articleId);
        } catch (Exception e) {
            throw new Exception("Comments Not Found !", e);
        }
    }

    @Override
    public List<Comment> getCommentsByWriterId(Long writerId) throws Exception {
        try {
            return commentRepository.findByWriterId(writerId);
        } catch (Exception e) {
            throw new Exception("Comment Not Found !", e);
        }
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void editComment(Comment comment) {
        addComment(comment);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
