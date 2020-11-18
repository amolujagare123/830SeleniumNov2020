import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net");


          WebElement txtUserName = driver.findElement(By.id("login-username"));
          txtUserName.sendKeys("admin");


         WebElement txtPassword = driver.findElement(By.id("login-password"));
         txtPassword.sendKeys("admin");

           WebElement btnLogin = driver.findElement(By.name("submit"));
           btnLogin.click();




    }



}
