package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends ExtentReport {
	static AndroidDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc = new DesiredCapabilities();

//        dc.setCapability("deviceName", "Pixel 6 Pro API 31");
		dc.setCapability("deviceName", "Pixel 3 XL API 31");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "uiautomator2");
        dc.setCapability("appplatformVersion", "12.0");
        dc.setCapability("app", "C:\\Users\\lnv0113\\Music\\apk\\TRSTQA100.apk");

        URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();
        driver = new AndroidDriver(url, dc);
      Thread.sleep(5000);

	}
	
	@AfterTest
	public void tearDown()
	{

		driver.quit();
	}
	

}
