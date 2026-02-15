package com.hong.flyway.config;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.lang.IllegalArgumentException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        List<String> errors =  new ArrayList<>();
        errors.add("Invalid UUID string.");
        var errorResponseDTO = ErrorResponseDTO.builder().errors(errors).build();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookNotFoundException(NoSuchElementException ex) {
        List<String> errors =  new ArrayList<>();
        errors.add("Resource not found.");
        var errorResponseDTO = ErrorResponseDTO.builder().errors(errors).build();
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(HttpMessageNotReadableException ex) {
        List<String> errors =  new ArrayList<>();
        errors.add("Invalid JSON format provided.");
        var errorResponseDTO = ErrorResponseDTO.builder().errors(errors).build();
        // HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handle(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).toList();
        var errorResponseDTO = ErrorResponseDTO.builder().errors(errors).build();
        // HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponseDTO> handle(HttpRequestMethodNotSupportedException ex) {
        List<String> errors =  new ArrayList<>();
        errors.add("Method Not Allowed.");
        var errorResponseDTO = ErrorResponseDTO.builder().errors(errors).build();
        // HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(errorResponseDTO);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Void> handleException(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().build();
    }

    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ExceptionHandler(NoSuchElementException.class)
    // public ResponseEntity<Object> handleBookNotFoundException(NoSuchElementException ex) {
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("message", "Element not found");
    //     body.put("timestamp", LocalDateTime.now());
    //     return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    // }

    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // @ExceptionHandler(NoResourceFoundException.class)
    // public ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex) {
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("message", "Resource not found");
    //     body.put("timestamp", LocalDateTime.now());
    //     return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    // }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(ConstraintViolationException.class)
    // protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("message", "Invalid content");
    //     body.put("timestamp", LocalDateTime.now());
    //     return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
    //     ValidationErrorResponse errorResponse = new ValidationErrorResponse();
    //     for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
    //         errorResponse.addError(fieldError.getField(), fieldError.getDefaultMessage());
    //     }
    //     return ResponseEntity.badRequest().body(errorResponse);
    // }

}
