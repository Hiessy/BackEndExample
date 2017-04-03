package org.university.development.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "app/default-values.properties")
public class ServicesConfiguration {

}
