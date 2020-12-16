import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

import static util.ConfigReader.*;

public class LoginTestP {

    @Test
    public void myLoginTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        //enter username
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(getUsername());

        //enter password
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(getPassword());

        //click login
        driver.findElement(By.xpath("//input[@value='LOG IN']")).click();



    }

}
