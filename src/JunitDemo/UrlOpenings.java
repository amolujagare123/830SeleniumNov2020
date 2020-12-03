package JunitDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlOpenings {

    WebDriver driver;

    @Before
    public void mymethod1()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After
    public void mymethod2() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void myLoginTest1() throws InterruptedException {


        driver.get("http://gmail.com");

    }

    @Test
    public void myLoginTest2() throws InterruptedException {


        driver.get("http://facebook.com");

    }

    @Test
    public void myLoginTest3() throws InterruptedException {


        driver.get("http://twitter.com");

    }


}
