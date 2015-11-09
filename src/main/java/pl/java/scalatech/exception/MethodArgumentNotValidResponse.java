package pl.java.scalatech.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class MethodArgumentNotValidResponse{
    @Getter
    private final List<MethodArgumentNotValidMessageResponse> errors = new ArrayList<>();

    public MethodArgumentNotValidResponse(List<MethodArgumentNotValidMessageResponse> errors) {
        this.errors.addAll(errors);
    }
}