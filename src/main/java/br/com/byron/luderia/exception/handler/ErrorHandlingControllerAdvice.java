package br.com.byron.luderia.exception.handler;

import br.com.byron.luderia.exception.ErrorResponse;
import br.com.byron.luderia.exception.NotFoundEntityException;
import br.com.byron.luderia.exception.StrategyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ErrorHandlingControllerAdvice {

	@ExceptionHandler(StrategyException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handlingStrategyException(StrategyException e) {
		log.error("HandlingConstraintValidationException: ", e);

		HttpStatus code = e.getStatus();

		ErrorResponse error = new ErrorResponse(e.getErrors());

		return ResponseEntity.status(code).body(error);
	}
	
	@ExceptionHandler(NotFoundEntityException.class)
	@ResponseBody
	public ResponseEntity<String> handlingStrategyException(NotFoundEntityException e) {
		log.error("HandlingConstraintValidationException: ", e);

		HttpStatus code = e.getStatus();

		return ResponseEntity.status(code).body(e.getMessage());
	}

}
