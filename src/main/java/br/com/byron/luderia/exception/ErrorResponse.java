package br.com.byron.luderia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {

	private Map<String, List<String>> errors;

}
