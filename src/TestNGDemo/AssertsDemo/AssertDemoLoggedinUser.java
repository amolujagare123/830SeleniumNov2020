package TestNGDemo.AssertsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertDemoLoggedinUser {

    @Test
    public void myLoginTest1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin1");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "Logged in as";

        String actual = "";

        try {

             actual = driver.findElement(By.xpath("//a[contains(@class,'user')]")).getText();
        }
        catch (Exception e)
        {

        }


        System.out.println("actual="+actual);

           boolean result = actual.contains(expectd);

           Assert.assertTrue(result,"the text is absent or incorrect");


        // check whether the actual result string contains the expected result string


      /*  Assert.assertEquals(actual,expectd,
                "the dashboard link is not present on the web page");*/


    }
}
