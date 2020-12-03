package JunitDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlOpenings2 {

    static WebDriver driver;

    @BeforeClass
    public static void mymethod1()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void mymethod2() throws InterruptedException {
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
