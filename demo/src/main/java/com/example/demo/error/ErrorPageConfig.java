package com.example.demo.error;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {


    //EmbeddedServletContainerCustomizer  2.0  之前
    //ConfigurableEmbeddedServletContainer
    @Bean
    public  WebServerFactoryCustomizer<ConfigurableWebServerFactory> containerCustomizer(){

        return  new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                System.out.println("qweqweqweqweqwe");
                ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");

                factory.addErrorPages(errorPage);
            }
        };


    }

}
