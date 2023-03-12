package net.hamzaouggadi.blog4j.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hamzaouggadi.blog4j.dtos.CommentDTO;
import net.hamzaouggadi.blog4j.entities.Comment;
import net.hamzaouggadi.blog4j.mappers.CommentMapper;
import net.hamzaouggadi.blog4j.repositories.CommentRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private MessageSource messageSource;
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> listComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.stream().forEach(comment -> {
            commentDTOS.add(commentMapper.commentToCommentDTO(comment));
        });
        return commentDTOS;
    }

    @Override
    public CommentDTO getComment(Long commentId) {
        return commentMapper.commentToCommentDTO(commentRepository.findById(commentId).orElseThrow());
    }

    @Override
    public List<CommentDTO> getCommentsByUser(Long userId) {
        List<Comment> comments = commentRepository.findByWriterId(userId);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.stream().forEach(comment -> {
            commentDTOS.add(commentMapper.commentToCommentDTO(comment));
        });
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentsByArticle(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.stream().forEach(comment -> {
            commentDTOS.add(commentMapper.commentToCommentDTO(comment));
        });
        return commentDTOS;
    }

    @Override
    public void addComment(CommentDTO commentDTO) {
        commentRepository.save(commentMapper.commentDTOToComment(commentDTO));
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setRemoved(true);
        commentRepository.save(comment);
    }
}
