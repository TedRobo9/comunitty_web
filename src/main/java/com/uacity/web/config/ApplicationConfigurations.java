package com.uacity.web.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ted on 16/4/23.
 */

@Configuration
@ComponentScan("com.uacity.web.*")
@EnableConfigurationProperties(value = {ConnectionSettings.class})
public class ApplicationConfigurations {

//    @Bean
//    public Filter webFilter() {
//        return new ShallowEtagHeaderFilter();
//    }

    public static void main( String[] args ) {
        SpringApplication.run(ApplicationConfigurations.class, args);
    }
}
