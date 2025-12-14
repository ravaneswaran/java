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

public class RiskDisclosureOnDerivativesWebPage extends WebPage{

    private static final Logger LOGGER = Logger.getLogger(RiskDisclosureOnDerivativesWebPage.class.getName());

    public RiskDisclosureOnDerivativesWebPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver.get("https://kite.zerodha.com/dashboard");
    }

    public void clickIUnderstand() {
        List<WebElement> webElements = this.webDriver.findElements(By.tagName("button"));
        for (WebElement webElement: webElements) {
            String iUnderstand = webElement.getText();
            if("I understand".equals(iUnderstand.trim())){
                LOGGER.info(String.format("button(%s) found...", "I Understand"));
                webElement.click();
                break;
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
        zerodhaWebDriver.login(userId, password).totp(totp).riskDisclosureOnDerivativesPopUp();
    }
}
