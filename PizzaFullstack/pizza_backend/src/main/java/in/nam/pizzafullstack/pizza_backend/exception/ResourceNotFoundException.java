package in.nam.pizzafullstack.pizza_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// when resources not found in db we throw this exception
// rest apo
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}