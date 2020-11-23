import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxRadio {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/PC/Desktop/Mywebsite/amol.html");


        // lets select checkbox with text selenium & radio button with selenium

       WebElement checkSelenium =  driver.findElement(By.id("check1"));
       checkSelenium.click();

       WebElement radioSelenium = driver.findElement(By.id("rad1"));
       radioSelenium.click();

    }
}
