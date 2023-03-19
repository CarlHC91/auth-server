package org.raspberry.auth.rest.exceptions;

import org.raspberry.auth.dto.exceptions.ErrorDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionErrorAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetailsDTO> errorHandler(Exception ex) {
		ErrorDetailsDTO errorDetailsDTO = new ErrorDetailsDTO();
		errorDetailsDTO.setStatus("error");
		errorDetailsDTO.setStatusMessage(ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetailsDTO);
	}

}
