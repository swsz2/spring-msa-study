package me.swsz2.cloud.gateway.component.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class AccessibleAddressFilter
    extends AbstractGatewayFilterFactory<AccessibleAddressFilter.AccessibleAddresses> {

  private final String UNKNOWN_ADDRESS = "";

  public AccessibleAddressFilter() {
    super(AccessibleAddresses.class);
  }

  @Override
  public GatewayFilter apply(final AccessibleAddresses accessibleAddresses) {
    return (exchange, chain) -> {

      // check configuration validation
      if (!accessibleAddresses.isValid()) {
        throw new RuntimeException("invalid accessible address configuration.");
      }

      // get remote address
      final String address =
          exchange.getRequest().getRemoteAddress() != null
              ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
              : UNKNOWN_ADDRESS;

      // check accessible address for request
      if (!accessibleAddresses.checkAccessibleAddress(address)) {
        throw new RuntimeException("not accessible address : " + address);
      }

      // exchange
      return chain.filter(exchange);
    };
  }

  @Data
  public static class AccessibleAddresses {
    private ArrayList<String> addresses;

    public boolean isValid() {
      return addresses != null && !addresses.isEmpty();
    }

    public boolean checkAccessibleAddress(final String address) {
      return addresses.contains(address);
    }
  }
}
