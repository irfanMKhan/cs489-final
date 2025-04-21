package com.secured.apsd_final.exception;

import com.secured.apsd_final.model.dto.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AstronautNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleAstronautNotFoundException(AstronautNotFoundException exception, HttpServletRequest request) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(Instant.now(), HttpStatus.NOT_FOUND, exception.getMessage(), exception.getMessage(), request.getRequestURI()),
                HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleSatelliteNotFoundException(SatelliteNotFoundException exception, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponseDTO(Instant.now(), HttpStatus.NOT_FOUND, exception.getMessage(), exception.getMessage(), request.getRequestURI()),
                HttpStatus.NOT_FOUND);

    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> ex(Exception exception, HttpServletRequest request) {

        return new ResponseEntity<>(
                new ErrorResponseDTO(Instant.now(), HttpStatus.NOT_FOUND, exception.getMessage(), exception.getMessage(), request.getRequestURI()),
                HttpStatus.NOT_FOUND);

    }

}




