package com.example.reactive.router;

import com.example.reactive.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction()
    {
        return RouterFunctions.route()
                .GET("/router/customers",handler::loadCustomers)
                .build();
    }
}
