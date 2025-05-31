package com.gamer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * Generate API documentation by knife4j
     * @return
     */
    @Bean
    public GroupedOpenApi gamerApi() {
        log.info("API documentation group initializing...");
        return GroupedOpenApi.builder()
                .group("gamer-api")
                .packagesToScan("com.gamer.controller")
                .build();
    }

    /**
     * Static resources mapping
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("Mapping static resources for Swagger UI...");
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Extend message converters
     * @param converters
     */
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        log.info("Customizing message converters...");
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setObjectMapper(new ObjectMapper());
//        converters.add(0, converter);
//    }

}
