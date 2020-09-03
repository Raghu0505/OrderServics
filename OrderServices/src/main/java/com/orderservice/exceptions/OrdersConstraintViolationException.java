package com.orderservice.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class OrdersConstraintViolationException
{
    
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public List<Map<String,List<String>>> handleConstraintViolation(ConstraintViolationException ex) {
	    List<Map<String, List<String>>>list= new ArrayList<>();
		Map<String, List<String>> errors = new HashMap<>();
	     List<String>messges= new ArrayList<>();
	     
	     for (ConstraintViolation<?> string : ex.getConstraintViolations()) {
	    	 messges.add(string.getMessage());
	    	 messges.add(string.getPropertyPath().toString());
		}
	     ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message",messges);
	        //errors.put("path",messges);
	    }); 
	    list.add(errors);
	    
	 
	    return list;
	}}