package parser.ozon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.lang.System;
import java.time.Duration;

public class Driver {
    private static WebDriver driver;
    private static void init() {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", Property.get("geckodriver-path"));
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override", Property.get("user-agent"));
        options.setProfile(profile);
        options.setImplicitWaitTimeout(Duration.ofSeconds(Integer.parseInt(Property.get("wait-driver"))));
        if(Property.get("headless").equals("true")) options.addArguments("-headless");
        options.setCapability("pageLoadStrategy", "normal");
            driver = new FirefoxDriver(options);
    }

    public static WebDriver get(){
        init();
        return driver;
    }
}
