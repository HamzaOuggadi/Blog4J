package net.hamzaouggadi.blog4j.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {
    @ExceptionHandler(BlogUserException.class)
    public ResponseEntity<GenericResponse> handleBlogUserException(BlogUserException e) {
        GenericResponse response = new GenericResponse();
        log.error(e.getMessage());
        e.printStackTrace();
        response.setError(true);
        response.setDescription(e.getMessage());
        response.setDescriptionFront(e.getMessageFront());
        response.setStatusCode(e.getCode());
        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }
    @ExceptionHandler(ArticleException.class)
    public ResponseEntity<GenericResponse> handleArticleException(ArticleException e) {
        GenericResponse response = new GenericResponse();
        log.error(e.getMessage());
        e.printStackTrace();
        response.setDescription(e.getMessage());
        response.setDescriptionFront(e.getMessageFront());
        response.setError(true);
        response.setStatusCode(e.getCode());
        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }
}