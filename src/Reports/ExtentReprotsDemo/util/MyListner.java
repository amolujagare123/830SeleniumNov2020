package Reports.ExtentReprotsDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Reports.ExtentReprotsDemo.util.InitExtentReport.initExtentObject;

public class MyListner implements ITestListener {

    public void onTestStart(ITestResult result) {


    }

    public  void onTestSuccess(ITestResult result) {

        System.out.println("onTestSuccess");
    }

    public  void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
    }

    public  void onTestSkipped(ITestResult result) {

        System.out.println("onTestSkipped");
    }


    public  void onStart(ITestContext context) {

        System.out.println("onStart");
    }

    public  void onFinish(ITestContext context) {

        System.out.println("onFinish");
    }


}
