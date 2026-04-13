package com.employemanagement.employee.Exception;
import com.employemanagement.employee.DTO.StandardApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardApiResponse> handleNotFound(ResourceNotFoundException ex) {
        StandardApiResponse response = new StandardApiResponse(ex.getMessage(), 404, null);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}