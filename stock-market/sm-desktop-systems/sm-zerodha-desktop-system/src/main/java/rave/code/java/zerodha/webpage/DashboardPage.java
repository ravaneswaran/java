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
import java.util.logging.Logger;

public class DashboardPage extends WebPage {

    private static final Logger LOGGER = Logger.getLogger(DashboardPage.class.getName());

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickUserNavigation() {
        WebElement webElement = this.webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/div/nav/a"));
        webElement.click();
    }

    public void clickLogout() {
        WebElement webElement = this.webDriver.findElement(By.xpath("//*[@id=\"account-nav-items\"]/ul/li[7]/a"));
        webElement.click();
    }

    public void clickTradingStocks() {
        WebElement webElement = this.webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div/div[3]/div/div/div/a[7]"));
        webElement.click();
        this.pause(500);
    }

    public void clearTradingStocks() {
        List<WebElement> webElements = this.webDriver.findElements(By.cssSelector("div[data-id]"));
        int size = webElements.size();
        for (int index = size - 1; index >= 0; index--) {
            this.actions.moveToElement(webElements.get(index)).pause(200).perform();
        }
    }

    public static void main(String[] args) throws Exception {
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Map<String, String> keyValue = userCredentialsFileReader.read(new File("stock-market/.username-and-passwords"));
        String userId = keyValue.get("zerodha-kite-userid");
        String password = keyValue.get("zerodha-kite-password");
        GoogleTOTPAuthenticator googleTOTPAuthenticator = new GoogleTOTPAuthenticator();
        String totp = String.valueOf(googleTOTPAuthenticator.getGoogleAuthenticatorTOTP());

        ZerodhaWebDriver zerodhaWebDriver = ZerodhaWebDriver.get();
        zerodhaWebDriver.login(userId, password).totp(totp).riskDisclosureOnDerivativesPopUp().clickTradingStocks().clearTradingStocks();
    }
}
