package br.com.patrickriibeiro.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfiguration {

	@Bean
	@Lazy(false)
	List<GroupedOpenApi> apis(SwaggerUiConfigParameters swaggerUiConfigParameters,
			RouteDefinitionLocator locator) {

		var definitios = locator.getRouteDefinitions().collectList().block();

		definitios.stream().filter(routerDefinition -> routerDefinition.getId().matches(".*-service"))
				.forEach(routerDifinition -> {
					String name = routerDifinition.getId();
					swaggerUiConfigParameters.addGroup(name);
					GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
				});

		return new ArrayList<>();
	}

}
