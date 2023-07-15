package project.cms.error;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Model class to define the exception message which will be exhibited to the user when him perform
 * a request that will return an error status code.
 */
@AllArgsConstructor
@Data
public class ExceptionMessage {
  private String errorCode;
  private String description;
}
