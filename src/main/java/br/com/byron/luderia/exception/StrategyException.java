package br.com.byron.luderia.exception;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class StrategyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status;
	
	private final Map<String, List<String>> errors;
	
	public StrategyException(Map<String, List<String>> errors, String message){
		super(message);
		this.errors = errors;
		this.status = HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
