package br.com.taxadeconversao.infrastructure.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> handleFeignException(FeignException ex) {

		if (ex.status() == 404) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Par de moedas não encontrado.");
		}

		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Erro ao consultar taxa de conversão: " + ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno: " + ex.getMessage());
	}
	
}
