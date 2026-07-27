package rave.code.nse.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import rave.code.java.system.StockMarketSystemProperties;
import rave.code.utility.log.JavaUtilLogDecor;
import rave.code.utility.log.message.JavaUtilLogMessage;

import java.util.logging.Logger;


@SpringBootApplication
public class NSEIndiaSpringBootWebApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = Logger.getLogger(NSEIndiaSpringBootWebApplication.class.getName());

    public static void main(String[] args) {
        JavaUtilLogDecor.setupLogDecor();
        SpringApplication.run(NSEIndiaSpringBootWebApplication.class, args);
        JavaUtilLogMessage logMessage = new JavaUtilLogMessage("NSE-India Web Application has been started");
        LOGGER.info(logMessage.getDecoratedLogMessage());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        StockMarketSystemProperties.loadProperties();
        return builder.sources(NSEIndiaSpringBootWebApplication.class);
    }

}
