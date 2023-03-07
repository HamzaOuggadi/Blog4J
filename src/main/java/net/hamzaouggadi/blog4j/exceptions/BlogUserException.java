package net.hamzaouggadi.blog4j.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class BlogUserException extends RuntimeException {
    private String message;
    private String code;
    private HttpStatus httpStatus;

    public BlogUserException() {
        super();
    }

    public BlogUserException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BlogUserException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
