package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;

public class ExtentReport {


	ExtentReports extent;
	ExtentSparkReporter spark;
	
	@BeforeTest
	public void setupReport() 
	{
	
		extent = new ExtentReports();
        spark = new ExtentSparkReporter("launch_browser.html");
        extent.attachReporter(spark);
	}
	
	@AfterTest
	public void tearDownReport ()
	{

		extent.flush();
		
	}
	

}
