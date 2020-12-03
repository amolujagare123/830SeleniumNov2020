package TestNGDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {

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


    @Test
    public void myLoginTest1() throws InterruptedException {


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");




    }

    @Test
    public void myLoginTest2() throws InterruptedException {


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("ere");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admrererin");




    }

    @Test
    public void myLoginTest3() throws InterruptedException {


        driver.get("http://stock.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("");




    }
}
