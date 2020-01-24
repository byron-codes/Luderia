package br.com.byron.luderia.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class NotFoundEntityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public NotFoundEntityException(String message) {
		super(message);
		this.status = HttpStatus.NOT_FOUND;
	}

}
