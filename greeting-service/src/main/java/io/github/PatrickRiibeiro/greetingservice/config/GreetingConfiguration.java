package io.github.PatrickRiibeiro.greetingservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
@RefreshScope
@ConfigurationProperties(prefix = "greeting-service")
public class GreetingConfiguration {

	private String greeting;
	private String defaultValue;
}
