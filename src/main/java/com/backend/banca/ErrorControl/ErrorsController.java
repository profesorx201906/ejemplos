package com.backend.banca.ErrorControl;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// import com.backend.banca.ErrorControl.Entity.ErrorResponse;
// import com.backend.banca.ErrorControl.Entity.Error;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Date;

// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.FieldError;
// import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;



@RestControllerAdvice
public class ErrorsController {
    public static final String VIEW_ERROR = "Se generó un error 500 de forma intencional";
    public static final String VIEW_ERROR_ARITMETIC = "error/500 division by zero";


    // @ExceptionHandler(Exception.class)
    // public String showInternalServerError() {
    //     return VIEW_ERROR;
    // }

    // @ExceptionHandler(ArithmeticException.class)
    // public String showArithmeticException() {
    //     return VIEW_ERROR_ARITMETIC;
    // }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
    //     List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    //     ErrorResponse errorResponse = new ErrorResponse();
    //     List<Error> errores = new ArrayList<>();
    //     fieldErrors.forEach((error)->{
    //         Error err = new Error();
    //         err.setType("Campo : " + ((FieldError) error).getField());
	// 		err.setMessage(error.getDefaultMessage());
	// 		errores.add(err);
    //     });
    //     errorResponse.setMessage("Error en tipo de dato");
    //     errorResponse.setStatus(400);
	// 	errorResponse.setTimestamp(new Date());
    //     errorResponse.setError(errores);
    //     return ResponseEntity.badRequest().body(errorResponse);
    // }
   
}

// @ResponseStatus(HttpStatus.BAD_REQUEST)
// @ExceptionHandler(Exception.class)
// public String generico(Exception e) {
// return e.getMessage();
// }

//  @ExceptionHandler(NoResourceFoundException.class)
//     public String NoResourceFoundException() {
//         return VIEW_ERROR_RESOURCE_FOUND;
//     }
