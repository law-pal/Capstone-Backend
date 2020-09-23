package com.lawrence.BeautyQuotient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotExceptionFound {
public void ResourceNotFoundException(String message) {
		
	}
}
