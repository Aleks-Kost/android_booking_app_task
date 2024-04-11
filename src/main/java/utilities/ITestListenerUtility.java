package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerUtility extends ScreenshotUtility implements ITestListener {

    public void onTestSuccess(ITestResult testRes) {
        captureScreenshot(testRes, "pass");
    }

    public void onTestFailure(ITestResult testRes) {
        captureScreenshot(testRes, "fail");
    }

}