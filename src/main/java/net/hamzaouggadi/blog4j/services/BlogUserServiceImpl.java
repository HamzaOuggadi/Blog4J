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

import java.util.*;

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
                if (!user.isRemoved()) {
                    listUsersDTO.add(blogUserMapper.blogUserToBlogUserDTO(user));
                } else {
                    throw new BlogUserException(
                            messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                            messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                            ApiStatusCode.API_USER_100,
                            HttpStatus.NOT_FOUND);
                }
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
        BlogUser userById = blogUserRepository.findById(userId).orElseThrow(()->
                new BlogUserException(
                        messageSource.getMessage("user.not.found.id", new Object[]{userId}, Locale.getDefault()),
                        messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                        ApiStatusCode.API_USER_100,
                        HttpStatus.NOT_FOUND));
        if (!userById.isRemoved()) {
            return blogUserMapper.blogUserToBlogUserDTO(userById);
        } else {
            throw new BlogUserException(
                    messageSource.getMessage("user.not.found.id", new Object[]{userId}, Locale.getDefault()),
                    messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BlogUserDTO getUserByUsername(String username) {
        BlogUser userByUsername = blogUserRepository.findByUsername(username);
        if (userByUsername != null || !userByUsername.isRemoved()) {
            return blogUserMapper.blogUserToBlogUserDTO(userByUsername);
        } else {
            throw new BlogUserException(
                    messageSource.getMessage("user.not.found.username", new Object[]{username}, Locale.getDefault()),
                    messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BlogUserDTO getUserByEmail(String email) {
        BlogUser userByEmail = blogUserRepository.findByEmail(email);
        if (userByEmail != null || !userByEmail.isRemoved()) {
            return blogUserMapper.blogUserToBlogUserDTO(userByEmail);
        } else {
            throw new BlogUserException(
                    messageSource.getMessage("user.not.found.username", new Object[]{email}, Locale.getDefault()),
                    messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_100,
                    HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addUser(BlogUserDTO blogUserDTO) {
        BlogUser user = blogUserMapper.blogUserDTOToBlogUser(blogUserDTO);
        try {
            user.setRemoved(false);
            user.setCreatedAt(new Date());
            blogUserRepository.save(user);
        } catch (Exception e) {
            throw new BlogUserException(
                    messageSource.getMessage("user.registration.failed", new Object[]{user.getUsername()}, Locale.getDefault()),
                    messageSource.getMessage("user.registration.failed.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_200,
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Override
    public void removeUser(Long userId) {
        BlogUser user = blogUserRepository.findById(userId).orElseThrow(()-> new BlogUserException(
                messageSource.getMessage("user.not.found.id", new Object[]{userId}, Locale.getDefault()),
                messageSource.getMessage("user.not.found.front", new Object[]{}, Locale.getDefault()),
                ApiStatusCode.API_USER_100,
                HttpStatus.NOT_FOUND));
        try {
            user.setRemoved(true);
        } catch (Exception e) {
            throw new BlogUserException(
                    messageSource.getMessage("user.remove.failed", new Object[]{userId}, Locale.getDefault()),
                    messageSource.getMessage("user.remove.failed.front", new Object[]{}, Locale.getDefault()),
                    ApiStatusCode.API_USER_300,
                    HttpStatus.CONFLICT);
        }
    }
}
