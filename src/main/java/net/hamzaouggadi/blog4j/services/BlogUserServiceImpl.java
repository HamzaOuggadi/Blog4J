package net.hamzaouggadi.blog4j.services;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.BlogUserDTO;
import net.hamzaouggadi.blog4j.entities.BlogUser;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;
import net.hamzaouggadi.blog4j.exceptions.BlogUserException;
import net.hamzaouggadi.blog4j.mappers.BlogUserMapper;
import net.hamzaouggadi.blog4j.repositories.BlogUserRepository;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
@AllArgsConstructor
public class BlogUserServiceImpl implements BlogUserService {
    private BlogUserRepository blogUserRepository;
    private BlogUserMapper blogUserMapper;
    private MessageSource messageSource;

    @Override
    public List<BlogUserDTO> listUsers() {
        List<BlogUser> listUsers = blogUserRepository.findAll();
        List<BlogUserDTO> listUsersDTO = new ArrayList<>();
        if (!CollectionUtils.isEmpty(listUsers)) {
            listUsers.stream().forEach(user -> {
                listUsersDTO.add(blogUserMapper.blogUserToBlogUserDTO(user));
            });
        } else {
            throw new BlogUserException(
                    messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                    messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_100,
                    HttpStatus.NOT_FOUND);
        }
        return listUsersDTO;
    }

    @Override
    public BlogUserDTO getUser(Long userId) {
        return null;
    }

    @Override
    public BlogUserDTO getUserByUsername(String username) {
        return null;
    }

    @Override
    public BlogUserDTO getUserByEmail(String email) {
        return null;
    }

    @Override
    public void addUser(BlogUserDTO blogUserDTO) {

    }

    @Override
    public void removeUser(Long userId) {

    }
}
