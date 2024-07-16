package br.com.patrickriibeiro.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfiguration {
	
	@Bean
	RouteLocator gateWayRouter(RouteLocatorBuilder builder ) {
		Function<PredicateSpec, Buildable<Route>> function = p -> {
				return p.path("/get")
						.filters( f -> f.addRequestHeader("hello", "World"))
						.uri("http://httpbin.org:80");
		};
				
		return builder.routes()
				.route(function)
				.build();
	}
	

}
