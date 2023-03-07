package net.hamzaouggadi.blog4j.services;

import net.hamzaouggadi.blog4j.dtos.BlogUserDTO;

import java.util.List;

public interface BlogUserService {
    List<BlogUserDTO> listUsers();
    BlogUserDTO getUser(Long userId);
    BlogUserDTO getUserByUsername(String username);
    BlogUserDTO getUserByEmail(String email);
    void addUser(BlogUserDTO blogUserDTO);
    void removeUser(Long userId);
}
