package parser.ozon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BrandProducts {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final List<String> products = new ArrayList<>();

    public List<String> get(){
        return products;
    }
    BrandProducts(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(Integer.parseInt(Property.get("wait-block"))));
        mainPage();
        getElements();
    }

    private void getElements(){
        getElementsPage(getMainBlock());
        List <String> links = getPagesLink();
        int curElement = 1;
        int size = links.size() - 1;
        while(curElement < size){
            driver.manage().deleteAllCookies();
            driver.get(links.get(curElement++));
            getElementsPage(getMainBlock());
            links = getPagesLink();
        }
        System.out.println("Страниц загружено: " + curElement);
    }

    private void mainPage(){
        driver.get(Property.get("url-main-page"));
    }

    private List<String> getPagesLink(){
        List<String> links = new ArrayList<>();
        WebElement mainBlock = driver.findElement(By.xpath(Property.get("xpath-pagination-container")));
        wait.until(d -> mainBlock.isDisplayed());
        mainBlock.findElements(By.xpath(Property.get("xpath-pagination-link")))
                .forEach(elem -> links.add(elem.getAttribute("href")));
        return links;
    }

    private WebElement getMainBlock(){
        WebElement mainBlock = driver.findElement(By.xpath(Property.get("xpath-page-container")));
        wait.until(d -> mainBlock.isDisplayed());
        return mainBlock;
    }

    private void getElementsPage(WebElement mainBlock){
        try {
            Thread.sleep(Integer.parseInt(Property.get("wait-page-load")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mainBlock.findElements(By.xpath(Property.get("xpath-element-text")))
                .forEach(elem -> products.add(elem.getText()));
    }
}
