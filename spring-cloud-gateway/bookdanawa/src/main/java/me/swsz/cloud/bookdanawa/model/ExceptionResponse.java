package me.swsz.cloud.bookdanawa.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/** Created by sungwonkim on 2021-11-15 */
@Data
@Builder
public class ExceptionResponse {
  private final Date timestamp = new Date();
  private String message;
  private String address;
  private String method;
  private String path;
}
