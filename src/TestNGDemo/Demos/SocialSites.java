package TestNGDemo.Demos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SocialSites {

    WebDriver driver;

    @BeforeMethod
    public void myMethod1()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void mymethod2()
    {
        driver.close();
    }


    @Test (priority = 1)
    public void facebook()  {

        driver.get("http://facebook.com");
    }


    @Test(priority = 2)
    public void twitter()  {

        driver.get("http://twitter.com");
    }


    @Test(priority = 3)
    public void instagram()  {

        driver.get("http://instagram.com");
    }



}
