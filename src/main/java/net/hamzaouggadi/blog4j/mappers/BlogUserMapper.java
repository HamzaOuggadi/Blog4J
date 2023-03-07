package net.hamzaouggadi.blog4j.mappers;

import net.hamzaouggadi.blog4j.dtos.BlogUserDTO;
import net.hamzaouggadi.blog4j.entities.BlogUser;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface BlogUserMapper {
    BlogUserDTO blogUserToBlogUserDTO(BlogUser blogUser);

    BlogUser blogUserDTOToBlogUser(BlogUserDTO blogUserDTO);
}
