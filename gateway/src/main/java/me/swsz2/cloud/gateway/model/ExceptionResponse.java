package me.swsz2.cloud.gateway.model;

import lombok.Builder;
import lombok.Data;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Date;

/** Created by sungwonkim on 2021-11-15 */
@Data
@Builder
public class ExceptionResponse {
  private final Date timestamp = new Date();
  private String message;
  private InetSocketAddress address;
  private String method;
  private URI path;
}
