package parser.ozon;

import org.openqa.selenium.remote.RemoteWebDriver;

public class App {

    public static void main(String[] args) {
        System.out.println("Start script");
        RemoteWebDriver driver = FirefoxDriver.get();
        Find.start(driver);
        System.out.println("Stop script");
    }
}
