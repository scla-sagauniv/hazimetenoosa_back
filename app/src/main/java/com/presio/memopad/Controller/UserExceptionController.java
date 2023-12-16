package com.presio.memopad.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.presio.memopad.Error.EmailIsAlreadyUsedException;
import com.presio.memopad.Error.EmailIsNotExistsException;
import com.presio.memopad.Error.UserPasswordIsIncorrectException;
import com.presio.memopad.Response.ErrorMessageResponse;

@RestControllerAdvice
public class UserExceptionController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EmailIsAlreadyUsedException.class)
  public ResponseEntity<Object> handleMyException(EmailIsAlreadyUsedException exception, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    return super.handleExceptionInternal(exception,
        new ErrorMessageResponse(exception.getMessage()),
        headers,
        HttpStatus.BAD_REQUEST,
        request);
  }

  @ExceptionHandler(EmailIsNotExistsException.class)
  public ResponseEntity<Object> handleMyException(EmailIsNotExistsException exception, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    return super.handleExceptionInternal(exception,
        new ErrorMessageResponse(exception.getMessage()),
        headers,
        HttpStatus.BAD_REQUEST,
        request);
  }

  @ExceptionHandler(UserPasswordIsIncorrectException.class)
  public ResponseEntity<Object> handleMyException(UserPasswordIsIncorrectException exception, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    return super.handleExceptionInternal(exception,
        new ErrorMessageResponse(exception.getMessage()),
        headers,
        HttpStatus.BAD_REQUEST,
        request);
  }
}
