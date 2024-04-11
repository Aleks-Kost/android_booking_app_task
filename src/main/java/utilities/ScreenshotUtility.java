package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public void captureScreenshot(ITestResult result, String status) {
        String destinationDir = "";
        String passFailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        File screenFile = DriverSetup.driver.getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        if (status.equalsIgnoreCase("fail")) {
            destinationDir = "screenshots/Failures";
        } else if (status.equalsIgnoreCase("pass")) {
            destinationDir = "screenshots/Success";
        }

        new File(destinationDir).mkdirs();
        String destinationFile = passFailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            FileUtils.copyFile(screenFile, new File(destinationDir + "/" + destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
