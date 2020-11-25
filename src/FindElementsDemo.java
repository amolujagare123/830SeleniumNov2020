import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsDemo {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net");

        List<WebElement> wbList = driver.findElements(By.tagName("input")); // 3 - user, pass, loginBtn

        // how can i print the total number of web elements that wbList holds ?
        // what is the method , that will give me how many elements are there in the list ?

        System.out.println("total elements : " + wbList.size());
        // 1. set username
        wbList.get(0).sendKeys("admin");

        // 2. set password
        wbList.get(1).sendKeys("admin");

        // 3. click login button
        wbList.get(2).click();


    }
}