package com.dev.sportsstore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class OrderTrackerGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {OrderNotFoundException.class})
	public ResponseEntity<?> handleProductNotFound(OrderNotFoundException orderNotFoundException, WebRequest request) {
		return super.handleExceptionInternal(orderNotFoundException, orderNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
