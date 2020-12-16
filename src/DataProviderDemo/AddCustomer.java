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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddCustomer {



    WebDriver driver;
    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://stock.scriptinglogic.net");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
        txtUserName.sendKeys("admin");


        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test (dataProvider = "getData")
    public void addCustomerTest(String cname,String con1,
                                String con2, String add) {

        driver.findElement(By.xpath("//a[normalize-space()='Add Customer']")).click();

        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys(cname);


        WebElement contact1 = driver.findElement(By.xpath("//input[@id='buyingrate']"));
        contact1.sendKeys(con1);


        WebElement contact2 = driver.findElement(By.xpath("//input[@id='sellingrate']"));
        contact2.sendKeys(con2);


        WebElement address = driver.findElement(By.xpath("//textarea[@name='address']"));
        address.sendKeys(add);

        WebElement addButton = driver.findElement(By.xpath("//input[@value='Add']"));

       addButton.click();

        /*String expected = "Customer Details Added";
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

        Assert.assertTrue(result,"Record is not added successfully");*/

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\data1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Add Customer");

        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][4];

        for(int i =0; i<rowCount-1 ;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

           /* XSSFCell name = row.getCell(0);
            data[i][0] = name.toString().trim();

            XSSFCell contact1 = row.getCell(1);
            data[i][1] = contact1.toString().trim();

            XSSFCell contact2 = row.getCell(2);
            data[i][2] = contact2.toString().trim();

            XSSFCell address = row.getCell(3);
            data[i][3] = address.toString().trim();*/


           for(int j=0;j<4;j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.toString().trim();
            }

        }

        return  data;
    }
}
