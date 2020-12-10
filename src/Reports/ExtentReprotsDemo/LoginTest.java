package Reports.ExtentReprotsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Reports.ExtentReprotsDemo.util.ScreenShot.takeScreenshot;

public class LoginTest {

    ExtentReports extent;

    @BeforeClass
    public void init()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Project information title");
        reporter.config().setReportName("All regression test");


        extent.setSystemInfo("Project name","Billing");
        extent.setSystemInfo("Developers name","Dhanashri");
        extent.setSystemInfo("Testers name","Shilpa");
        extent.setSystemInfo("Test Lead","Lalita");
        extent.setSystemInfo("Start date","10/12/2020");
        extent.setSystemInfo("Location","Banglore");
    }





    @Test
    public void myLoginTestValid() throws InterruptedException, IOException {

        ExtentTest test = extent.createTest("myLoginTestValid");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("http://stock.scriptinglogic.net");

        test.info("URL is opened");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "http://stock.scriptinglogic.net/dashboard.php";

        String actual = driver.getCurrentUrl();

        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expectd, "the actual URL is different");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }
       // extent.flush();

    }

    @Test
    public void myLoginTestInValid() throws InterruptedException, IOException {

        ExtentTest test = extent.createTest("myLoginTestInValid");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("http://stock.scriptinglogic.net");

        test.info("URL is opened");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("6565");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("6565");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "http://stock.scriptinglogic.net/dashboard.php";

        String actual = driver.getCurrentUrl();

        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expectd, "the actual URL is different");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }
       // extent.flush();

    }

    @Test
    public void myLoginTestBlank() throws InterruptedException, IOException {

        ExtentTest test = extent.createTest("myLoginTestBlank");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("http://stock.scriptinglogic.net");

        test.info("URL is opened");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectd = "http://stock.scriptinglogic.net/dashboard.php";

        String actual = driver.getCurrentUrl();

        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expectd, "the actual URL is different");
            test.pass("test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }


    }

    @AfterClass
    public void afterAllTests()
    {
        extent.flush();
    }

}
