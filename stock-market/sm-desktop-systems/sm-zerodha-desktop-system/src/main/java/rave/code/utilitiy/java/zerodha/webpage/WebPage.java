package rave.code.utilitiy.java.zerodha.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebPage {

    private static final Logger LOGGER = Logger.getLogger(WebPage.class.getName());

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    public WebPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.actions = new Actions(this.webDriver);
        this.webDriverWait = new WebDriverWait(this.webDriver, Duration.ofMillis(500));
    }

    public void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exception) {
            LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
        }
    }
}
