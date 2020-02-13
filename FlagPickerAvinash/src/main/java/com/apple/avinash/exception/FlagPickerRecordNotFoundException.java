package com.apple.avinash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlagPickerRecordNotFoundException extends Exception{


	private static final long serialVersionUID = 1L;

	public FlagPickerRecordNotFoundException(String exception) {
		super(exception);
	}
	
	public FlagPickerRecordNotFoundException() {
		super();
	}
	

	private String displayErrorMessage;
	
	private String errorCode;

	public String getDisplayErrorMessage() {
		return displayErrorMessage;
	}

	public void setDisplayErrorMessage(String displayErrorMessage) {
		this.displayErrorMessage = displayErrorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	


}
