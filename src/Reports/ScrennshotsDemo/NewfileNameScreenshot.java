package Reports.ScrennshotsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewfileNameScreenshot {

    @Test
    public void myTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://scriptinglogic.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

        String filename="screenshot_"+timestamp+".png";

        FileUtils.copyFile(srcFile,new File("D:\\pallavi\\"+filename));


    }


}
