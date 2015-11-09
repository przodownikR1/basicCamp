package pl.java.scalatech.exception;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MethodArgumentNotValidExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    MethodArgumentNotValidResponse processException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        return new MethodArgumentNotValidResponse(getValidationErrors(bindingResult));
    }

    private List<MethodArgumentNotValidMessageResponse> getValidationErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().map(fieldError -> {
            return new MethodArgumentNotValidMessageResponse(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
        }).collect(toList());
    }
}