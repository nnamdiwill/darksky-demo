package CapGem;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class TestNGListeners implements ITestListener {


    public void onTestStart(ITestResult result) {
        Date currentDate = new Date();
        System.out.println("The current date is " + currentDate);

    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("The test was successful");
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("The test failed");
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
