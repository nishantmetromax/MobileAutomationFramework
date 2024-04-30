package test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Login_Screenshot_report extends BaseClass {
	
	 @Test
	    public void test() throws InterruptedException, IOException {
	        ExtentTest test = extent.createTest("test", "demo test case");
	        test.log(Status.INFO, "application started");

	        WebElement log = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Already an existing user? Click here to Login\")"));
	        log.click();
	        test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

	        Thread.sleep(2000);

	        WebElement un = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
	        un.sendKeys("smoketest@gmail.com");
	        test.log(Status.PASS, "entered email id");

	        WebElement pass = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
	        pass.sendKeys("Pass@1234");
	        test.log(Status.PASS, "entered password", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

	        WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")"));
	        button.click();
	        test.log(Status.PASS, "signed in successfully");

	        Thread.sleep(4000);
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
