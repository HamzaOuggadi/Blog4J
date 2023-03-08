package net.hamzaouggadi.blog4j.exceptions;

import lombok.Getter;
import lombok.Setter;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class CommentException extends RuntimeException {
    private String message;
    private String messageFront;
    private ApiStatusCode code;
    private HttpStatus httpStatus;

    public CommentException() {
        super();
    }

    public CommentException(String message, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public CommentException(String message, String messageFront, ApiStatusCode code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.messageFront = messageFront;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public CommentException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
