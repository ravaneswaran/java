package rave.code.java.zerodha.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rave.code.java.totp.GoogleTOTPAuthenticator;
import rave.code.java.zerodha.webdriver.ZerodhaWebDriver;
import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DashboardPage extends WebPage {

    private static final Logger LOGGER = Logger.getLogger(DashboardPage.class.getName());
    private static final String LOGOUT_URL = "https://kite.zerodha.com/logout";

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickUserNavigation() {
        List<WebElement> webElements = this.webDriver.findElements(By.className("right-nav"));
        LOGGER.info(String.format("clickUserNavigation [web elements count : %s ...]", webElements.size()));
        for (WebElement webElement : webElements) {
            List<WebElement> subElements = webElement.findElements(By.className("user-nav"));
            LOGGER.info(String.format("clickUserNavigation [sub elements count : %s ...]", subElements.size()));
            for (WebElement subElement : subElements) {
                subElement.click();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    LOGGER.log(Level.SEVERE, exception.getMessage(), exception);
                }
                break;
            }
        }
    }

    public void clickLogout() {
        List<WebElement> webElements = this.webDriver.findElements(By.className("dropdown-nav-list"));
        LOGGER.info(String.format("clickLogout [web elements count : %s ...]", webElements.size()));
        for (WebElement webElement : webElements) {
            List<WebElement> subElements = webElement.findElements(By.tagName("a"));
            LOGGER.info(String.format("clickLogout [sub elements count : %s ...]", subElements.size()));
            for (WebElement subElement : subElements) {
                String value = subElement.getAttribute("href");
                if(LOGOUT_URL.equals(value.trim())){
                    LOGGER.info(String.format("clickLogout [logout element found...]", subElements.size()));
                    subElement.click();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Map<String, String> keyValue = userCredentialsFileReader.read(new File("stock-market/.username-and-passwords"));
        String userId = keyValue.get("zerodha-kite-userid");
        String password = keyValue.get("zerodha-kite-password");
        GoogleTOTPAuthenticator googleTOTPAuthenticator = new GoogleTOTPAuthenticator();
        String totp = String.valueOf(googleTOTPAuthenticator.getGoogleAuthenticatorTOTP());

        ZerodhaWebDriver zerodhaWebDriver = ZerodhaWebDriver.get();
        zerodhaWebDriver.login(userId, password).totp(totp).riskDisclosureOnDerivativesPopUp().logout();
    }
}
