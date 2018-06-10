package com.paxos.assignment.microservice.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ResourceNotFoundExceptionHandler
{
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Map<String, Object>> handleResourceNotFound(final ResourceNotFoundException e) {
      Map<String, Object> errorInfo = new LinkedHashMap<>();
      errorInfo.put("httpCode", HttpStatus.NOT_FOUND.value());
      errorInfo.put("httpStatus", HttpStatus.NOT_FOUND.getReasonPhrase());
      errorInfo.put("err_msg", e.getMessage());
      return new ResponseEntity<Map<String, Object>>(errorInfo, HttpStatus.NOT_FOUND);
  }
  
}