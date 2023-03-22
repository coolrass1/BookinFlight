package com.skk.Seating_arrangement_system.exception;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class EmployeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ConstraintViolationException(ConstraintViolationException ex){
        var result=ex.getConstraintViolations().stream().map(s->s.getMessage()).collect(Collectors.toList());

        return result.get(0);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, List<String>> MethodArgumentNotValidException (MethodArgumentNotValidException ex){

        var  errors =ex.getBindingResult().getAllErrors().stream().map(f->f.getDefaultMessage()).collect(Collectors.toList());;


        Map<String, List<String> > errorResponse = new HashMap<>();
        //Map<String, Map<String, List<String> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;


    }
}
