package br.com.patrickriibeiro.configuration;

//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApiGateWayConfiguration {

	/*@Bean
	RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("hello", "World").addRequestParameter("Hello", "Word"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/cambio-service/**").uri("lb://cambio-service"))
				.route(p -> p.path("/book-service/**").uri("lb://book-service")).build();
	} */

}
