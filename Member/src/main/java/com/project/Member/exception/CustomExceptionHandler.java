package com.project.Member.exception;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	@Autowired
	NotFound notFound;
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<NotFound> handlerException(){
		notFound.setResult("Id not Found");
		return new ResponseEntity<>(notFound,HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public HashMap validaterMismatch(MethodArgumentNotValidException match) {
		HashMap<String,String> hashmap = new HashMap<String,String>();
		hashmap.put("Validation-Failed","Name Must be Filled");
		return hashmap;
	}
}
