package Reports.ExtentReprotsDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static Reports.ExtentReprotsDemo.util.InitExtentReport.initExtentObject;
import static Reports.ExtentReprotsDemo.util.InitExtentReport.takeScreenshot;

public class MyListnersExtentReport extends InitBrowser implements ITestListener {

    //-
    ExtentReports extent;
    ExtentTest test;

    public  void onStart(ITestContext context) {

        extent = initExtentObject();
    }

    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    public  void onTestSuccess(ITestResult result) {
        test.pass(result.getMethod().getMethodName()+":This method is passed");


    }

    public  void onTestFailure(ITestResult result) {
        test.info(result.getMethod().getMethodName()+
                ":This method is failed");

        test.fail(result.getThrowable().getMessage());

        try {
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public  void onTestSkipped(ITestResult result) {

        System.out.println("onTestSkipped");
    }




    public  void onFinish(ITestContext context) {

        extent.flush();
    }

}
