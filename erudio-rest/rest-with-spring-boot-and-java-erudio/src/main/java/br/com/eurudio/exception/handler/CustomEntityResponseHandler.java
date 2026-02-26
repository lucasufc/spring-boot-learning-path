package br.com.eurudio.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.eurudio.exception.ExceptionResponse;
import br.com.eurudio.exception.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(getResponse(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(getResponse(ex, request), HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponse getResponse (Exception ex, WebRequest request) {
        return new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );
    }
}
