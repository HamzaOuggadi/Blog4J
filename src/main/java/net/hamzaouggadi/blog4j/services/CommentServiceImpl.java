package net.hamzaouggadi.blog4j.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hamzaouggadi.blog4j.dtos.CommentDTO;
import net.hamzaouggadi.blog4j.entities.Comment;
import net.hamzaouggadi.blog4j.mappers.CommentMapper;
import net.hamzaouggadi.blog4j.repositories.BlogUserRepository;
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
    private BlogUserRepository blogUserRepository;

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
        log.info("Number of Likes for Comments(1) : " + comments.get(1).getLikes());
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comments.stream().forEach(comment -> {
            commentDTOS.add(commentMapper.commentToCommentDTO(comment));
        });
        log.info("Number of Likes for CommentDTOs(1) : " + commentDTOS.get(1).getLikes());
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> getCommentsByArticle(Long articleId) {
        return null;
    }

    @Override
    public void addComment(CommentDTO commentDTO) {

    }

    @Override
    public void deleteComment(Long commentId) {

    }
}
