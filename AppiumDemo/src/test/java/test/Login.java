package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumBy;

public class Login extends BaseClass{
	
	@Test
	public void test() throws InterruptedException
	{
		ExtentTest test= extent.createTest("test", "demo test case");
		test.log(Status.INFO, "application started");
		
		 WebElement log = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Already an existing user? Click here to Login\")"));
		 log.click();
	     test.log(Status.PASS, "clicked on link");
	       
         Thread.sleep(2000);

         WebElement un = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
         un.sendKeys("smoketest@gmail.com");
         
         test.log(Status.PASS, "entered email id");
         
         WebElement pass = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
         pass.sendKeys("Pass@1234");
         
         test.log(Status.PASS, "entered password");
         
         WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sign In\")"));
         button.click();
         
//       test.log(Status.PASS, "signed in successfully");
         
         Thread.sleep(4000);
         
         String buttonText = button.getText();
         if(buttonText.equals("Sign In")) {
             test.log(Status.PASS, "Signed in successfully");
         } else {
             test.log(Status.FAIL, "Failed to sign in");
         }
 
     }

	

}
