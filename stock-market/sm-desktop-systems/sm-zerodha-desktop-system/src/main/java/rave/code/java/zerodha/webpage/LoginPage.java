package rave.code.java.zerodha.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rave.code.java.zerodha.webdriver.ZerodhaWebDriver;
import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class LoginPage extends WebPage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver.get("https://kite.zerodha.com");
    }

    public void fillUserId(String userId) {
        this.webDriver.findElement(By.id("userid")).sendKeys(userId);
    }

    public void fillPassword(String password) {
        this.webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLogin() {
        List<WebElement> webElements = this.webDriver.findElements(By.tagName("button"));
        for (WebElement webElement: webElements) {
            String login = webElement.getText();
            if("Login".equals(login.trim())){
                LOGGER.info(String.format("button(%s) found...", "Login"));
                webElement.click();
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ZerodhaWebDriver zerodhaWebDriver = ZerodhaWebDriver.get();
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();

        Map<String, String> keyValue = userCredentialsFileReader.read(new File("stock-market/.username-and-passwords"));
        String userId = keyValue.get("zerodha-kite-userid");
        String password = keyValue.get("zerodha-kite-password");

        zerodhaWebDriver.login(userId, password);
    }
}
