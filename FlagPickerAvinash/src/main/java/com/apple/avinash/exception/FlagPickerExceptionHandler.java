package com.apple.avinash.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
@Component
public class FlagPickerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		FlagPickerServiceAPIErrorResponse error = new FlagPickerServiceAPIErrorResponse("Server_Error", errors);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(FlagPickerRecordNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(FlagPickerRecordNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getDisplayErrorMessage());
		FlagPickerServiceAPIErrorResponse error = new FlagPickerServiceAPIErrorResponse(ex.getErrorCode(),
				errors);
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}

}