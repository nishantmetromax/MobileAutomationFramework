package test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class BrowserLaunch extends BaseClass {
	
	@Test
	public void test() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("test", "demo test case");
        test.log(Status.INFO, "application started");
		

	driver.get("https://www.google.com/");
	Thread.sleep(3000);
	
	System.out.println("Application started");
    test.log(Status.PASS, "open google", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

	
//      driver.quit();
		
	}
	// Method to capture the screen and save the screenshot to a file
    private String captureScreen() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        LocalDateTime timestamp = LocalDateTime.now();
		String timestampString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
        String destFilePath = System.getProperty("user.dir") + "/screenshots/screenshot_" + timestampString + ".png";

        FileUtils.copyFile(srcFile, new File(destFilePath));
        return destFilePath;
    }
}
