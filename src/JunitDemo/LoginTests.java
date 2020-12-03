package JunitDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {

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


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

      //  WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
       // btnLogin.click();


    }

    @Test
    public  void myLoginTest2() throws InterruptedException {


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("dsds");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("dsd");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        //btnLogin.click();

    }

    @Test
    public  void myLoginTest3() throws InterruptedException {


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
       // btnLogin.click();


    }

}
