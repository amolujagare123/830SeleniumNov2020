import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.lifepartner.in/");

        // 1 . find the webelement
        WebElement drpMStatus = driver.findElement(By.name("ms"));


        //2 .create an object of select class , pass the webelemnt into its constructor
        Select selMStatus = new Select(drpMStatus) ;


        // 3. select , using either , visible text, index, value

       // selMStatus.selectByVisibleText("Never married");
        selMStatus.selectByValue("7");



    }
}
