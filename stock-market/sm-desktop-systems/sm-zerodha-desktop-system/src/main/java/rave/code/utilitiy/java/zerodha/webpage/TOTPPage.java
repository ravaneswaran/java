package rave.code.utilitiy.java.zerodha.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import rave.code.utilitiy.java.totp.GoogleTOTPAuthenticator;
import rave.code.utilitiy.java.zerodha.webdriver.ZerodhaWebDriver;
import rave.code.utilities.file.UserCredentialsFileReader;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

public class TOTPPage extends WebPage {

    private static final Logger LOGGER = Logger.getLogger(TOTPPage.class.getName());

    public TOTPPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillTOTP(String totp) {
        WebElement totpTextBox = this.webDriver.findElement(By.id("userid"));
        totpTextBox.sendKeys(totp);
        this.clickContinue();
    }

    public void clickContinue() {
    }

    public static void main(String[] args) throws Exception {
        UserCredentialsFileReader userCredentialsFileReader = new UserCredentialsFileReader();
        Map<String, String> keyValue = userCredentialsFileReader.read(new File("/home/ravaneswaran/.username-and-passwords"));
        String userId = keyValue.get("zerodha-kite-userid");
        String password = keyValue.get("zerodha-kite-password");
        GoogleTOTPAuthenticator googleTOTPAuthenticator = new GoogleTOTPAuthenticator();
        String totp = String.valueOf(googleTOTPAuthenticator.getGoogleAuthenticatorTOTP());

        ZerodhaWebDriver zerodhaWebDriver = ZerodhaWebDriver.get();
        zerodhaWebDriver.login(userId, password).totp(totp);
    }
}
