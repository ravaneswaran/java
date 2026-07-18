package rave.code.utilitiy.java.zerodha.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import rave.code.utilitiy.java.zerodha.webpage.DashboardPage;
import rave.code.utilitiy.java.zerodha.webpage.LoginPage;
import rave.code.utilitiy.java.zerodha.webpage.RiskDisclosureOnDerivativesWebPage;
import rave.code.utilitiy.java.zerodha.webpage.TOTPPage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ZerodhaWebDriver {

    private static final Logger LOGGER = Logger.getLogger(ZerodhaWebDriver.class.getName());
    private static ZerodhaWebDriver stockMarketWebDriver;
    private WebDriver webDriver;

    private ZerodhaWebDriver() {
        ChromeOptions options = new ChromeOptions();

        // Recommended options
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        // Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setBinary(new File("/usr/bin/google-chrome"));

        this.webDriver = new ChromeDriver(options);
    }

    public static final ZerodhaWebDriver get() {
        if (null == ZerodhaWebDriver.stockMarketWebDriver) {
            ZerodhaWebDriver.stockMarketWebDriver = new ZerodhaWebDriver();
        }
        return ZerodhaWebDriver.stockMarketWebDriver;
    }

    public ZerodhaWebDriver login(String userId, String password) {
        LOGGER.info(this.webDriver.getCurrentUrl());
        LoginPage loginPage = new LoginPage(this.webDriver);
        loginPage.fillUserId(userId);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        return this;
    }

    public ZerodhaWebDriver totp(String totp) {
        LOGGER.info(this.webDriver.getCurrentUrl());
        TOTPPage totpPage = new TOTPPage(this.webDriver);
        totpPage.fillTOTP(totp);
        totpPage.clickContinue();
        return this;
    }

    public ZerodhaWebDriver riskDisclosureOnDerivativesPopUp() {
        LOGGER.info(this.webDriver.getCurrentUrl());
        RiskDisclosureOnDerivativesWebPage riskDisclosureOnDerivativesWebPage = new RiskDisclosureOnDerivativesWebPage(this.webDriver);
        riskDisclosureOnDerivativesWebPage.clickIUnderstand();
        return this;
    }

    public ZerodhaWebDriver logout(){
        LOGGER.info(this.webDriver.getCurrentUrl());
        DashboardPage dashboardPage = new DashboardPage(this.webDriver);
        dashboardPage.clickUserNavigation();
        dashboardPage.clickLogout();
        return this;
    }

    public ZerodhaWebDriver clickTradingStocks(){
        LOGGER.info(this.webDriver.getCurrentUrl());
        DashboardPage dashboardPage = new DashboardPage(this.webDriver);
        dashboardPage.clickTradingStocks();
        return this;
    }

    public ZerodhaWebDriver clearTradingStocks(){
        LOGGER.info(this.webDriver.getCurrentUrl());
        DashboardPage dashboardPage = new DashboardPage(this.webDriver);
        dashboardPage.clearTradingStocks();
        return this;
    }
}
