package com.apple.avinash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FlagPickerServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public FlagPickerServiceException(String exception) {
		super(exception);
	}

	public FlagPickerServiceException() {
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
