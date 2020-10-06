package com.murad.handling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Global Exception Handler is triggered when any defined exception is thrown any controller which defined RestController
@RestControllerAdvice
public class ApiExceptionHandler {

//    @ExceptionHandler({EntityNotFoundException.class})
//    public ResponseEntity entityNotFound(){
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record not founded";
    }

//    @ExceptionHandler({IllegalArgumentException.class})
//    public ResponseEntity illegalArgument(){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String illegalArgument() {
        return "Wrong Argument";
    }

}
