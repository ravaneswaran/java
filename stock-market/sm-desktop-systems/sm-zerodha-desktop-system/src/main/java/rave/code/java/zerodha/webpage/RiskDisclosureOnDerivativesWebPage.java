package rave.code.java.zerodha.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rave.code.java.totp.GoogleTOTPAuthenticator;
import rave.code.java.zerodha.webdriver.ZerodhaWebDriver;
import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

public class RiskDisclosureOnDerivativesWebPage extends WebPage{

    private static final Logger LOGGER = Logger.getLogger(RiskDisclosureOnDerivativesWebPage.class.getName());

    public RiskDisclosureOnDerivativesWebPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickIUnderstand() {
        WebElement webElement = this.webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[6]/div/div[3]/div/div/div/button"));
        webElement.click();
    }

    public static void main(String[] args) throws Exception{
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Map<String, String> keyValue = userCredentialsFileReader.read(new File("/home/ravaneswaran/.username-and-passwords"));
        String userId = keyValue.get("zerodha-kite-userid");
        String password = keyValue.get("zerodha-kite-password");
        GoogleTOTPAuthenticator googleTOTPAuthenticator = new GoogleTOTPAuthenticator();
        String totp = String.valueOf(googleTOTPAuthenticator.getGoogleAuthenticatorTOTP());

        ZerodhaWebDriver zerodhaWebDriver = ZerodhaWebDriver.get();
        zerodhaWebDriver.login(userId, password).totp(totp).riskDisclosureOnDerivativesPopUp();
    }
}
