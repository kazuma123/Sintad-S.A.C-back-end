package com.webapp.edu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public NotFoundException(String detail) {
		super(HttpStatus.NOT_FOUND, detail);
	}
}
