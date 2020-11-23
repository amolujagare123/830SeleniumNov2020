import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/PC/Desktop/Mywebsite/amol.html");

        WebElement multiSelect = driver.findElement(By.id("multiSel"));

        Select selMulti = new Select(multiSelect) ;

        selMulti.selectByIndex(1);
        selMulti.selectByIndex(3);

        Thread.sleep(3000);

        /*selMulti.deselectByIndex(3);

        Thread.sleep(3000);

        selMulti.deselectByIndex(1);*/

        selMulti.deselectAll();
    }
}
