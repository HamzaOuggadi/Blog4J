package net.hamzaouggadi.blog4j.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserDTO {
    private String username;
    private String password;
    private String email;
    private Date createdAt;
    private boolean isDeleted;
}
