package au.com.marlo.liquorstore.error;

import au.com.marlo.liquorstore.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

/** Error handler class to map exceptions to a correspondent response to the user. */
@RestControllerAdvice
public class ErrorHandler {

  /**
   * Error handler to map HttpRequestMethodNotSupportedException to bad request 400.
   *
   * @return The Response entity that will be serialized, contenting the status code of the error
   *     and a description.
   */
  @ExceptionHandler({HttpRequestMethodNotSupportedException.class, MethodArgumentNotValidException.class})
  public ResponseEntity<ExceptionMessage> handleBadRequestException() {
    ExceptionMessage exceptionMessage =
        new ExceptionMessage("E_CST_400", "Missing required request parameters");
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }

  /**
   * Error handler to map NoDataFoundException to not found 404.
   *
   * @return The Response entity that will be serialized, contenting the status code of the error
   *     and a description.
   */
  @ExceptionHandler({NoDataFoundException.class})
  public ResponseEntity<ExceptionMessage> handleNotFoundException() {
    ExceptionMessage exceptionMessage = new ExceptionMessage("ERROR_CST_404", "Resource Not Found");
    return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
  }

  /**
   * Error handler to map possible internal exceptions to internal server error 500.
   *
   * @return The Response entity that will be serialized, contenting the status code of the error
   *     and a description.
   */
  @ExceptionHandler({
    HttpServerErrorException.InternalServerError.class,
    Exception.class,
    NullPointerException.class,
    StackOverflowError.class
  })
  public ResponseEntity<ExceptionMessage> handleInternalServerError() {
    ExceptionMessage exceptionMessage =
        new ExceptionMessage("E_CST_500", "An Internal Server Error occurred");
    return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
