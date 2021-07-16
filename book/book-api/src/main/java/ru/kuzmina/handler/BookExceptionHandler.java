package ru.kuzmina.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kuzmina.exception.DuplicateException;
import ru.kuzmina.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Обработка исключений
 */
@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException exception) {
        return new ResponseEntity<>("PhoneBook not found: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateException.class)
    public ResponseEntity<Object> duplicateEntity(DuplicateException exception) {
        return new ResponseEntity<>("Saving error: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exception(Exception exception) {
        return new ResponseEntity<>("Caught exception: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            List<String> message = new ArrayList<>();
            for (FieldError e : errors) {
                message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
            }
            return new ResponseEntity<>("Caught exception: " + message, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
