package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class LoginAssertion {


    @Test (dataProvider = "getData")
    public void myLoginTest(String user, String pass , String url )
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

        String expectd = url;

        String actual = driver.getCurrentUrl();

        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expectd,"the actual Page title is different");

    }


    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fp = new FileInputStream("Data\\data1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet3");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][3]; // (col) 3 inputs as username , password , url
                                            // (row) 4 number of input set (data set)

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            XSSFCell user = row.getCell(0);
            data[i][0] =  user.toString().trim();

            XSSFCell pass = row.getCell(1);
            data[i][1] = pass.toString().trim();

            XSSFCell url = row.getCell(2);
            data[i][2] = url.toString().trim();


        }

        return data;

    }

}
