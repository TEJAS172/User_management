package Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.UserManagement.Payload.ApiResponse;
@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(final ResourceNotFoundException ex){
			final String message = ex.getMessage();
			final ApiResponse apiResponse = new ApiResponse(message, false);
			return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgNotValidExceptionHandler(MethodArgumentNotValidException ex){
	Map<String,String> response = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach(error->{
		String fieldName = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		
		response.put(fieldName, message);
		
	});
	return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
}
}

