package rave.code.nse.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import rave.code.java.system.StockMarketSystemProperties;


@SpringBootApplication
public class NSEIndiaSpringBootWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NSEIndiaSpringBootWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        StockMarketSystemProperties.loadProperties();
        return builder.sources(NSEIndiaSpringBootWebApplication.class);
    }

}
