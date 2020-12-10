package Reports.ExtentReprotsDemo.util;

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

public class ScreenShot {


    public static String takeScreenshot(WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

        String filename="screenshot_"+timestamp+".png";

        FileUtils.copyFile(srcFile,new File("Reports\\screenshots\\"+filename));

        return  filename;
    }


}
