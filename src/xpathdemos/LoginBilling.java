package xpathdemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginBilling {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://billing.scriptinglogic.net");


        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='email']"));
        txtUserName.sendKeys("amolujagare@gmail.com");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='password']"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();

        driver.findElement(By.xpath("//a[normalize-space()='View Clients']")).click();

        String user ="ABC";

        driver.findElement(By.xpath("//tr[td/a[text()='"+user+"']]//div")).click(); // click option


        driver.findElement(By.xpath("//tr[td/a[text()='"+user+"']]//a[contains(@href,'form')]")).click(); // click edit



    }
}
