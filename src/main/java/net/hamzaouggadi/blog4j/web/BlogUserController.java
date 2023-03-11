package net.hamzaouggadi.blog4j.web;

import lombok.AllArgsConstructor;
import net.hamzaouggadi.blog4j.dtos.BlogUserDTO;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;
import net.hamzaouggadi.blog4j.exceptions.GenericResponse;
import net.hamzaouggadi.blog4j.services.BlogUserService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class BlogUserController {
    BlogUserService blogUserService;
    MessageSource messageSource;
    @GetMapping
    public ResponseEntity<List<BlogUserDTO>> listUsers() {
        List<BlogUserDTO> listUsers = blogUserService.listUsers();
        return ResponseEntity.ok(listUsers);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<BlogUserDTO> getUserById(@PathVariable Long userId) {
        BlogUserDTO user = blogUserService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping(params = "username")
    public ResponseEntity<BlogUserDTO> getUserByUsername(@RequestParam(name = "username") String username) {
        BlogUserDTO user = blogUserService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping(params = "email")
    public ResponseEntity<BlogUserDTO> getUserByEmail(@RequestParam String email) {
        BlogUserDTO user = blogUserService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addUser")
    public ResponseEntity<GenericResponse> addUser(@RequestBody BlogUserDTO blogUserDTO) {
        blogUserService.addUser(blogUserDTO);
        GenericResponse response = new GenericResponse();
        response.setDescription(messageSource.getMessage("user.added.success", new Object[]{blogUserDTO.getUsername()}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("user.added.success.front", new Object[]{blogUserDTO.getUsername()}, Locale.getDefault()));
        response.setStatusCode(ApiStatusCode.API_USER_400);
        response.setError(false);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<GenericResponse> deleteUser(@RequestParam Long userId) {
        blogUserService.removeUser(userId);
        GenericResponse response = new GenericResponse();
        response.setDescription(messageSource.getMessage("user.removed.success", new Object[]{userId}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("user.removed.success.front", new Object[]{}, Locale.getDefault()));
        response.setStatusCode(ApiStatusCode.API_USER_400);
        response.setError(false);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
