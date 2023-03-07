package net.hamzaouggadi.blog4j.exceptions;

import lombok.Data;
import net.hamzaouggadi.blog4j.enums.ApiStatusCode;

@Data
public class GenericResponse {
    private ApiStatusCode statusCode;
    private boolean error;
    private String description;
    private String descriptionFront;
}
