package com.ethergit.landing;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(0);

        registry.addResourceHandler("/resources/images/**")
                .addResourceLocations("/resources/images/")
                .setCachePeriod(0);

        registry.addResourceHandler("/resources/scripts/**")
                .addResourceLocations("/resources/scripts/")
                .setCachePeriod(0);

        registry.addResourceHandler("/resources/styles/**")
                .addResourceLocations("/resources/styles/")
                .setCachePeriod(0);
    }
}
