//package com.summer.config;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class GlobalHandler implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        MultiValueMap<String, String> queryParams = request.getQueryParams();
//        String username = queryParams.getFirst("username");
//        if(username == null){
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//未登录
//           return exchange.getResponse().setComplete();
//        }else {
//            return chain.filter(exchange);
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
