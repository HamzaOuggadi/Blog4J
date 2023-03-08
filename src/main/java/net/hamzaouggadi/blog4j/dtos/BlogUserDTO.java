package net.hamzaouggadi.blog4j.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserDTO {
    private String username;
    private String password;
    private String email;
}
