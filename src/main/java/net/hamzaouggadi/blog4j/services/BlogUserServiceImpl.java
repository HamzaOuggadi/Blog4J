package net.hamzaouggadi.blog4j.services;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.BlogUserDTO;
import net.hamzaouggadi.blog4j.entities.BlogUser;
import net.hamzaouggadi.blog4j.mappers.BlogUserMapper;
import net.hamzaouggadi.blog4j.repositories.BlogUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BlogUserServiceImpl implements BlogUserService {
    private BlogUserRepository blogUserRepository;
    private BlogUserMapper blogUserMapper;
    @Override
    public List<BlogUserDTO> listUsers() {
        List<BlogUser> listUsers = blogUserRepository.findAll();
        List<BlogUserDTO> listUsersDTO = new ArrayList<>();
        listUsers.stream().forEach(user -> {
            listUsersDTO.add(blogUserMapper.blogUserToBlogUserDTO(user));
        });
        return null;
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
