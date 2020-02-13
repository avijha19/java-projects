package com.apple.avinash.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class FlagPickerServiceAPIErrorResponse {

	public FlagPickerServiceAPIErrorResponse(String errorMessage, List<String> errors) {
		super();
		this.errorCode = errorMessage;
		this.errors = errors;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	// General error message about nature of error
	private String errorCode;

	// Specific errors in API request processing
	private List<String> errors;

}
