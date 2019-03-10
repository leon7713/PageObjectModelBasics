package listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static utilities.Utilities.captureScreenshot;

public class CustomListeners extends Page implements ITestListener {

    public CustomListeners() throws IOException {
    }

    public void onTestStart(ITestResult iTestResult) {

        test = rep.startTest(iTestResult.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult iTestResult) {

        test.log(LogStatus.PASS,iTestResult.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " HAS FAILED!!!");
        try {
            captureScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.log(LogStatus.FAIL,result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
        rep.endTest(test);
        rep.flush();
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
