package org.一种奇怪的接口实现;

public interface GatewayFilter {
    String filter(String exchange, Integer chain);
}
