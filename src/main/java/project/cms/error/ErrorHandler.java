package project.cms.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.cms.exception.ActivityNotFoundException;
import project.cms.exception.EditionNotFoundException;
import project.cms.exception.EventNotFoundException;
import project.cms.exception.FavoritAlreadyExistException;
import project.cms.exception.UserRegistrationException;

/** Error handler class to map exceptions to a correspondent response to the user. */
@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler({
    UserRegistrationException.class,
    EventNotFoundException.class,
    EditionNotFoundException.class,
    ActivityNotFoundException.class,
    FavoritAlreadyExistException.class
  })
  public ResponseEntity<ExceptionMessage> handleBadRequestException(Exception exception) {
    ExceptionMessage exceptionMessage = new ExceptionMessage("ERROR_409", exception.getMessage());
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }
}
