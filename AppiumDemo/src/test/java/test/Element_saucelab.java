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

public class Element_saucelab extends BaseClass {
	
	@Test
	public void test()  throws InterruptedException, IOException {
        ExtentTest test = extent.createTest("test", "demo test case");
        test.log(Status.INFO, "application started");
	  
//		Test steps
      WebElement opt = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt.click();
      test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

    
      
      WebElement opt1 = driver.findElement(AppiumBy.accessibilityId("menu item about"));
      opt1.click();
      
      Thread.sleep(2000);
      test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

      
      WebElement opt2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt2.click();
      
      Thread.sleep(8000);
      
      WebElement opt21 = driver.findElement(AppiumBy.accessibilityId("menu item qr code scanner"));
      opt21.click();
      
      Thread.sleep(8000);
      
      WebElement opt22 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
      opt22.click();
      test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

      
      Thread.sleep(3000);
      
      WebElement opt23 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt23.click();
      
      Thread.sleep(3000);
    
      WebElement opt3 = driver.findElement(AppiumBy.accessibilityId("menu item geo location"));
      opt3.click();
      
      Thread.sleep(9000);
     
      WebElement opt4 = driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_one_time_button"));
     opt4.click();
     test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());

     Thread.sleep(6000);
     
      WebElement opt24 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt24.click();

      Thread.sleep(3000);

      WebElement opt8 =  driver.findElement(AppiumBy.accessibilityId("menu item drawing"));
      opt8.click();
      
      Thread.sleep(4000);

      WebElement opt9 =  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Image\").instance(1)"));
      opt9.click();
      
      Thread.sleep(3000);
      
      Point location = opt9.getLocation();
      Dimension size = opt9.getSize();
      
      int startX = (location.x + (size.getWidth()/2));
      int startY = location.x + 500;
      
      int endX = startX;
      int endY = (location.y + (size.getHeight()));
      
      PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH,"finger");
      Sequence sequence = new Sequence (finger, 1)
    		  .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY ))
      			.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
      			.addAction(new Pause (finger, Duration.ofMillis(200)))
      			.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
      			.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
      
      driver.perform(Collections.singletonList(sequence));
      Thread.sleep(5000);
      
      test.log(Status.PASS, "clicked on link", MediaEntityBuilder.createScreenCaptureFromPath(captureScreen()).build());
      
      WebElement opt10 =  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt10.click();
      
      Thread.sleep(3000);
      
      WebElement opt11 = driver.findElement(AppiumBy.accessibilityId("menu item reset app"));
      opt11.click();
      
      Thread.sleep(3000);
      
      WebElement opt12 = driver.findElement(AppiumBy.id("android:id/button2"));
      opt12.click();
      
      Thread.sleep(4000);
      
      WebElement opt13 = driver.findElement(AppiumBy.accessibilityId("menu item biometrics"));
      opt13.click();
      
      Thread.sleep(3000);

      
      WebElement opt14 = driver.findElement(AppiumBy.id("android:id/button1"));
      opt14.click();
      
      Thread.sleep(3000);

      
      WebElement opt15 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt15.click();
      Thread.sleep(3000);
      
      WebElement opt16 = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
      opt16.click();
      Thread.sleep(4000);
      
      WebElement opt17 = driver.findElement(AppiumBy.accessibilityId("Username input field"));
      opt17.sendKeys("abc@gmail.com");

      WebElement opt18 = driver.findElement(AppiumBy.accessibilityId("Password input field"));
      opt18.sendKeys("Pass@123");
      
      WebElement opt19 = driver.findElement(AppiumBy.accessibilityId("Login button"));
      opt19.click();
      
      Thread.sleep(3000);

      
      WebElement opt20 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
      opt20.click();


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
