package eshop.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FournisseurNotValidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
