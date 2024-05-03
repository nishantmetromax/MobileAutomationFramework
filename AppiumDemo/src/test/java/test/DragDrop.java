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
import org.openqa.selenium.Point;
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

public class DragDrop extends BaseClass {
	
	@Test
	public void test() throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("test", "demo test case");
        test.log(Status.INFO, "application started");
		  
//		Test steps
      WebElement opt = driver.findElement(AppiumBy.accessibilityId("Views"));
      opt.click();
      
      Thread.sleep(3000);
      
      WebElement opt1 = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
      opt1.click();
      test.log(Status.PASS, "target and source", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

      
      WebElement source = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
      
      WebElement target = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
      
      Point sourceCenter= getCenter(source);
      Point targetCenter= getCenter(target);
      
      PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH,"finger");
      Sequence sequence = new Sequence (finger, 1)
    		  .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter))
      			.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      			.addAction(new Pause (finger, Duration.ofMillis(500)))
      			.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), targetCenter))
      			.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
      
      driver.perform(Collections.singletonList(sequence));
      Thread.sleep(2000);
      
      test.log(Status.PASS, "drag and drop success", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

//      driver.quit();
      
	}
      
      private static Point getCenter(WebElement element)
      {
//      location of element
      Point location = element.getLocation();
      
//      dimension of element
      Dimension size= element.getSize();
      
//      center point
      Point center= new Point (location.x + size.width/2, location.y+ size.height/2);
      
      return center;
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
