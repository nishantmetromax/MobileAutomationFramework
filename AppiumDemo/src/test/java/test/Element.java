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
import io.appium.java_client.android.AndroidDriver;

public class Element extends BaseClass{
	
	@Test
	public void test()  throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("test", "demo test case");
        test.log(Status.INFO, "application started");
		
	    
//			Test steps
	      WebElement opt = driver.findElement(AppiumBy.accessibilityId("Views"));
	      opt.click();
	      test.log(Status.PASS, "clicked on view", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

	      
	      WebElement opt1 = driver.findElement(AppiumBy.accessibilityId("Controls"));
	      opt1.click();
	      
	      Thread.sleep(5000);

	      WebElement opt2 = driver.findElement(AppiumBy.accessibilityId("1. Light Theme"));
	      opt2.click();
	      
	      Thread.sleep(3000);
	      
	      WebElement opt3 = driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit"));
	      opt3.sendKeys("element");
	      
	      WebElement checkbox = driver.findElement(AppiumBy.accessibilityId("Checkbox 1"));
	      checkbox.click();
	      
	      WebElement radio = driver.findElement(AppiumBy.accessibilityId("RadioButton 1"));
	      radio.click();
	      
	      WebElement star = driver.findElement(AppiumBy.accessibilityId("Star"));
	      star.click();
	      
	      WebElement toggle = driver.findElement(AppiumBy.id("io.appium.android.apis:id/toggle1"));
	      toggle.click();
	      
	      WebElement spinner = driver.findElement(AppiumBy.id("io.appium.android.apis:id/spinner1"));
	      spinner.click();
	      
	      Thread.sleep(3000);
	      
	      WebElement opt4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Jupiter\")"));
	      opt4.click();
	      
	      test.log(Status.PASS, "all element", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
	 
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
