package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataProviderExcelx {

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
    public Object[][] getData() throws IOException {

        FileInputStream fp = new FileInputStream("Data\\data1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2]; // (col) 2 inputs as username & password
                                            // (row) 4 number of input set (data set)

        for(int i=0;i<rowCount;i++)
        {
            XSSFRow row = sheet.getRow(i);

            XSSFCell user = row.getCell(0);
            data[i][0] =  user.toString().trim();

            XSSFCell pass = row.getCell(1);
            data[i][1] = pass.toString().trim();

        }

        return data;

    }

}
