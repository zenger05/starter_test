package org.example;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OpenWeatherMapProperties.class)
public class OpenWeatherMapAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public WeatherService weatherService(OpenWeatherMapProperties properties) {
        return new WeatherService(properties.getCity(), new OpenWeatherMapClient(properties.getSdkKey()));
    }
}
