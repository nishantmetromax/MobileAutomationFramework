package test;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Signup extends BaseClass {

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Test
	public void test() throws InterruptedException{
		
			WebElement ln = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
	         ln.sendKeys("jay");
	         
	         WebElement fn = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
	         fn.sendKeys("sharma");
	         
	         takeScreenshot("lastname");

	         WebElement con = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	         con.click();
	         
	         WebElement cont = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	         cont.click();

	         TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

	         PointOption start = PointOption.point(1315, 1464);
	         PointOption end = PointOption.point(164, 1460);

	         touchAction.press(start).waitAction().moveTo(end).release().perform();

	         PointOption start1 = PointOption.point(1300, 1450);
	         PointOption end1 = PointOption.point(121, 1469);

	         touchAction.press(start1).waitAction().moveTo(end1).release().perform();

	         PointOption start2 = PointOption.point(1276, 1474);
	         PointOption end2 = PointOption.point(92, 1493);

	         touchAction.press(start2).waitAction().moveTo(end2).release().perform();

	         WebElement conti = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	         conti.click();

	         Thread.sleep(8000);
	         
	         takeScreenshot("programs");
	         
	         WebElement program = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"More Energy\")"));
	         program.click();

	         Thread.sleep(5000);

	         WebElement calendar = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"DD/MM/YYYY\")"));
	         calendar.click();

	         WebElement date = driver.findElement(AppiumBy.accessibilityId("08 April 2006"));
	         date.click();
	         
	         takeScreenshot("dob");

	         Thread.sleep(2000);

	         WebElement done = driver.findElement(AppiumBy.id("android:id/button1"));
	         done.click();

	         Thread.sleep(2000);

	         WebElement don = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	         don.click();
	         
	         takeScreenshot("gender");
	         
	         WebElement gender = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Male\")"));
	         gender.click();

	         Thread.sleep(2000);

	         WebElement donee = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Continue\")"));
	         donee.click();

	         Thread.sleep(2000);

	         WebElement signup = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign Up\")"));
	         signup.click();

	         WebElement button = driver.findElement(AppiumBy.className("android.widget.Button"));
	         button.click();

	         Thread.sleep(2000);

	         // Generate random email
	         String randomEmail = "user" + new Random().nextInt(1000) + "@example.com";

	         // Generate random phone number
	         String randomPhoneNumber = generateRandomPhoneNumber();

	         // Find the email field and enter the random email
	         WebElement emailField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
	         emailField.sendKeys(randomEmail);

	         // Find the phone number field and enter the random phone number
	         WebElement phoneNumberField = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
	         phoneNumberField.sendKeys(randomPhoneNumber);

	         WebElement pass = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(4)"));
	         pass.sendKeys("Pass@123");
	         
	         takeScreenshot("signup");
	         
	         WebElement sign = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign Up\")"));
	         sign.click();

	         Thread.sleep(3000);

	         PointOption tapPoint = PointOption.point(252, 1174);

	         new TouchAction(driver)
	                 .press(tapPoint)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint1 = PointOption.point(362, 2150);

	         new TouchAction(driver)
	                 .press(tapPoint1)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint2 = PointOption.point(679, 2164);

	         new TouchAction(driver)
	                 .press(tapPoint2)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint3 = PointOption.point(931, 2146);

	         new TouchAction(driver)
	                 .press(tapPoint3)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint4 = PointOption.point(371, 2329);

	         new TouchAction(driver)
	                 .press(tapPoint4)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint8 = PointOption.point(679, 2329);

	         new TouchAction(driver)
	                 .press(tapPoint8)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint5 = PointOption.point(935, 2352);

	         new TouchAction(driver)
	                 .press(tapPoint5)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();

	         PointOption tapPoint6 = PointOption.point(1247, 2696);

	         new TouchAction(driver)
	                 .press(tapPoint6)
	                 .waitAction(WaitOptions.waitOptions(Duration.ofMillis(50)))
	                 .release()
	                 .perform();


	         Thread.sleep(2000);

	         WebElement signed = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Verify & Continue\")"));
	         signed.click();

	         Thread.sleep(5000);
	         
	         takeScreenshot("consent");

	         WebElement accept = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accept\")"));
	         accept.click();

	      
	     }
	    
	    private static void takeScreenshot(String fileName) {
	    	 try{
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			LocalDateTime timestamp = LocalDateTime.now();
			String timestampString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String screenshotDir = "C:\\Users\\lnv0113\\Music\\eclipse-jee-2024-03-R-win32-x86_64\\AppiumDemo\\screenshot\\";
			String screenshotFilePath = screenshotDir + fileName + "_" + timestampString + ".png";
			
	        File screenshotFolder = new File(screenshotDir);
	        if (!screenshotFolder.exists()) {
	            screenshotFolder.mkdirs();
	        }
	       
			screenshotFile.renameTo(new File(screenshotFilePath));

			System.out.println("Screenshot saved to: " + screenshotFilePath);
	    }catch (Exception e) {
	        e.printStackTrace();
	    }

	   }

	     private static String generateRandomPhoneNumber() {
	         StringBuilder phoneNumber = new StringBuilder();
	         Random random = new Random();
	         for (int i = 0; i < 10; i++) {
	             phoneNumber.append(random.nextInt(10));
	         }
	         return phoneNumber.toString();
	     }


	
}
