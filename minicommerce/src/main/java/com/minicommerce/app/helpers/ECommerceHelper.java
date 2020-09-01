package com.minicommerce.app.helpers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.minicommerce.app.util.ErrorResponse;


public class ECommerceHelper {

	private ECommerceHelper() {
	}

	public static ResponseEntity<ErrorResponse> createErrorEntity(HttpStatus httpStatus, String message) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(message);
		errorResponse.setReasonPhrase(httpStatus.getReasonPhrase());
		errorResponse.setStatusCode(String.valueOf(httpStatus.value()));
		errorResponse.setCode(String.valueOf(httpStatus.value()));
		errorResponse.setCreateDate(new Date());
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
	
}
