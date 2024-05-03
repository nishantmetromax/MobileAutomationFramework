package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Element_scroll extends BaseClass {
	
	@Test
	public void test() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("test", "demo test case");
        test.log(Status.INFO, "application started");
		
		  
//		Test steps
      WebElement opt = driver.findElement(AppiumBy.accessibilityId("Views"));
      opt.click();
      test.log(Status.PASS, "page option", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

      
      Dimension size = driver.manage().window().getSize();
       int startX = size.getWidth()/2;
       int startY = size.getHeight()/2;
       
       int endX = startX;
       int endY = (int) (size.getHeight()*0.25);
       
       PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH,"finger");
       Sequence sequence = new Sequence (finger, 1)
     		  .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY ))
       			.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
       			.addAction(new Pause (finger, Duration.ofMillis(200)))
       			.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
       			.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
       
       driver.perform(Collections.singletonList(sequence));
       Thread.sleep(2000);
       
       test.log(Status.PASS, "scrolled page successfully", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

//       driver.quit();

      

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
