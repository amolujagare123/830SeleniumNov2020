import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // maximize

        driver.manage().window().maximize();

        driver.get("http://www.facebook.com");

        driver.navigate().to("http://gmail.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();


    }


}
