package org.一种奇怪的接口实现;

import org.apache.commons.lang3.StringUtils;

public class RoleInfoExtractGatewayFilterFactory {

    public GatewayFilter apply() {
        return (
                (exchange, chain) -> {
                    System.out.println(exchange);
                    System.out.println(chain);
                    return exchange + chain;
                }

        );
    }
}
