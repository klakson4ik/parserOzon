package parser.ozon;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.net.MalformedURLException;
import java.lang.System;
import java.net.URL;
import java.time.Duration;

public class FirefoxDriver {
    private static RemoteWebDriver driver;
    private static void init() {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./geckodriver");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en-GB");
        options.setProfile(profile);
        options.setImplicitWaitTimeout(Duration.ofSeconds(20));
        options.addArguments("--headless=new");
        options.setCapability("pageLoadStrategy", "normal");
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
        }
        catch(MalformedURLException e) {
            driver.quit();
        }
    }

    public static RemoteWebDriver get(){
        init();
        return driver;
    }
}
