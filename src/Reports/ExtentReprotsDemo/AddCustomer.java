package Reports.ExtentReprotsDemo;

import Reports.ExtentReprotsDemo.util.InitBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddCustomer extends InitBrowser {



    @Test
    public void addCustomerTest() {
        
        driver.get("http://stock.scriptinglogic.net");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[normalize-space()='Add Customer']")).click();


        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Lalita123");


        WebElement contact1 = driver.findElement(By.xpath("//input[@id='buyingrate']"));
        contact1.sendKeys("45454");


        WebElement contact2 = driver.findElement(By.xpath("//input[@id='sellingrate']"));
        contact2.sendKeys("545454");


        WebElement address = driver.findElement(By.xpath("//textarea[@name='address']"));
        address.sendKeys("fdfdf");

        WebElement addButton = driver.findElement(By.xpath("//input[@value='Add']"));

        addButton.click();

        String expected = "Customer Details Added";
        String actual = "";

        try
        {
            actual = driver.findElement(By.xpath("//div[@class='confirmation-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);


        boolean result = actual.contains(expected);

        Assert.assertTrue(result,"Record is not added successfully");

    }

}
