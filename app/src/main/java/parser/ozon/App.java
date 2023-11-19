package parser.ozon;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args)
    {
        System.out.println("Скрипт выполняется...");
        WebDriver driver = Driver.get();
        List<String> products  = new BrandProducts(driver).get();
        try {
            FileAction.write(products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Элементов добавлено: " + products.size());
        System.out.println("Процесс завершен");
        driver.quit();
    }
}
