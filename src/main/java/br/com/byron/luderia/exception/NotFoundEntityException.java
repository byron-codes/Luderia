package br.com.byron.luderia.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundEntityException extends Exception {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public NotFoundEntityException(String message) {
		super(message);
		this.status = HttpStatus.NOT_FOUND;
	}

}
