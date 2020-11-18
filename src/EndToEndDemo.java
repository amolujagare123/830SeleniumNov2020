import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EndToEndDemo {

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


           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           WebElement lnkAddCutomer = driver.findElement(By.linkText("Add Customer"));
           lnkAddCutomer.click();


           WebElement txtName = driver.findElement(By.name("name"));
           txtName.sendKeys("Lalita");

           WebElement txtAddreass = driver.findElement(By.name("address"));
           txtAddreass.sendKeys("abcd, pune");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("785748574");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("785748574");


       WebElement btnAdd =  driver.findElement(By.name("Submit"));
        btnAdd.click();



    }



}
