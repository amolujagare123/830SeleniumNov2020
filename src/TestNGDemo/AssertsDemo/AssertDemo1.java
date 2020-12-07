package TestNGDemo.AssertsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertDemo1 {

    @Test
    public void myLoginTest1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "http://stock.scriptinglogic.net/dashboard.php1";

        String actual = driver.getCurrentUrl();

        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expectd,"the actual URL is different");


    }
}
