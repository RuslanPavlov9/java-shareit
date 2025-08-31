package ru.practicum.shareit.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.ValidationException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ErrorHandlerTest {

    private final ErrorHandler errorHandler = new ErrorHandler();

    @Test
    void handleValidationException() {
        ValidationException exception = new ValidationException("Validation failed");

        Map<String, String> result = errorHandler.handleValidationException(exception);

        assertEquals("Validation failed", result.get("error"));
        assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }

    @Test
    void handleIllegalArgumentException() {
        IllegalArgumentException exception = new IllegalArgumentException("Illegal argument");

        Map<String, String> result = errorHandler.handleIllegalArgumentException(exception);

        assertEquals("Illegal argument", result.get("error"));
    }

    @Test
    void handleNotFoundException_RuntimeException() {
        RuntimeException exception = new RuntimeException("Not found");

        Map<String, String> result = errorHandler.handleNotFoundException(exception);

        assertEquals("Not found", result.get("error"));
    }

    @Test
    void handleNullPointerException() {
        NullPointerException exception = new NullPointerException("Null pointer");

        Map<String, String> result = errorHandler.handleNullPointException(exception);

        assertEquals("Null pointer", result.get("error"));
    }

    @Test
    void handleGeneralException() {
        Exception exception = new Exception("General error");

        Map<String, String> result = errorHandler.handleException(exception);

        assertEquals("General error", result.get("error"));
    }

    @Test
    void handleHttpMessageNotReadableException() {
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("Message not readable");

        Map<String, String> result = errorHandler.handleHttpMessageNotReadableException(exception);

        assertEquals("Message not readable", result.get("error"));
    }

    @Test
    void handleResponseStatusException() {
        ResponseStatusException exception = new ResponseStatusException(HttpStatus.NOT_FOUND, "Status exception");

        Map<String, String> result = errorHandler.handleResponseStatusException(exception);

        assertEquals("404 NOT_FOUND \"Status exception\"", result.get("error"));
    }

    @Test
    void handleNotFoundException_Custom() {
        NotFoundException exception = new NotFoundException("Custom not found");

        Map<String, String> result = errorHandler.handleNotFoundException(exception);

        assertEquals("Custom not found", result.get("error"));
    }

    @Test
    void handleAlreadyExistsException() {
        AlreadyExistsException exception = new AlreadyExistsException("Already exists");

        Map<String, String> result = errorHandler.handleAlreadyExistsException(exception);

        assertEquals("Already exists", result.get("error"));
    }

    @Test
    void handleDataIntegrityViolationException() {
        DataIntegrityViolationException exception = new DataIntegrityViolationException("Data integrity violation");

        Map<String, String> result = errorHandler.handleDataIntegrityViolationException(exception);

        assertEquals("Data integrity violation", result.get("error"));
    }

    @Test
    void handleDataValidationException() {
        DataValidationException exception = new DataValidationException("Data validation failed");

        Map<String, String> result = errorHandler.handleDataValidationException(exception);

        assertEquals("Data validation failed", result.get("error"));
    }

    @Test
    void handleForbiddenException() {
        ForbiddenException exception = new ForbiddenException("Access forbidden");

        Map<String, String> result = errorHandler.handleDataForbiddenException(exception);

        assertEquals("Access forbidden", result.get("error"));
    }

}
