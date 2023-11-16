package parser.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Find {
    final private static String MAIN_URL = "https://www.ozon.ru/category/apteka-6000/solopharm-72315488/?category_was_predicted=true&deny_category_prediction=true&from_global=true&text=solopharm";
    public static void start(RemoteWebDriver driver){
        System.out.println("Helllloooo");
        driver.get(MAIN_URL);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mainBlock = driver.findElement(By.xpath("//div[@data-widget='megaPaginator']"));
        wait.until(d -> mainBlock.isDisplayed());;
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='tile-hover-target']//span"));
    }
}
