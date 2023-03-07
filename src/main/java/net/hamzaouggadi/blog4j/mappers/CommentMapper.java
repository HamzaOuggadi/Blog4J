package net.hamzaouggadi.blog4j.mappers;

import net.hamzaouggadi.blog4j.dtos.CommentDTO;
import net.hamzaouggadi.blog4j.entities.Comment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CommentMapper {
    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);
}
