package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo {

  /*  public static WebDriver driver;
    @BeforeMethod
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    */

    @Test (dataProvider = "getData")
    public void myLoginTest(String user, String pass )
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys(user);


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys(pass);

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "POSNIC - Dashboard";

        String actual = driver.getTitle();

        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expectd,"the actual Page title is different");

    }


    @DataProvider
    public Object[][] getData()
    {

        Object[][] data = new Object[4][2]; // (col) 2 inputs as username & password
                                            // (row) 3 number of input set (data set)
        data[0][0] = "admin";
        data[0][1] = "admin"; // 1st row


        data[1][0] = "wewe";
        data[1][1] = "554@#"; // 2nd row

        data[2][0] = "";
        data[2][1] = ""; // 2nd row

        data[3][0] = "1234";
        data[3][1] = "1111"; // 2nd row

        return data;

    }

}
