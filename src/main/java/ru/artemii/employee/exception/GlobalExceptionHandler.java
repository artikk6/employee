package ru.artemii.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.artemii.employee.payload.ErrorPayload;

import java.net.BindException;
import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<ErrorPayload> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body(
                        ErrorPayload.builder()
                                .message(
                                        (e.getBindingResult().getFieldError().getDefaultMessage()))
                                .detailMessage(e.getBindingResult().getFieldErrors().toString())
                                .atCurrent(LocalDateTime.now())
                                .build()
                );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorPayload> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorPayload.builder()
                                .message(e.getMessage())
                                .detailMessage(e.getMessage())
                                .atCurrent(LocalDateTime.now())
                                .build()
                );
    }


}
