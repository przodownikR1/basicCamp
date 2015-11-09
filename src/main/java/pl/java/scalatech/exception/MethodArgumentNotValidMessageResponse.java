package pl.java.scalatech.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class MethodArgumentNotValidMessageResponse {
    @Getter
    private final String field;

    @Getter
    private final Object value;

    @Getter
    private final String message;


}