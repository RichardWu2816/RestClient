package com.ln.rest.client.lnrestclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by richardwu on 8/11/2017.
 */
@Configuration
public class RestClientWebConfig extends WebMvcConfigurerAdapter {

    // see https://stackoverflow.com/questions/27381781/java-spring-boot-how-to-map-my-my-app-root-to-index-html
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wadl").setViewName("index.html");
    }
}


