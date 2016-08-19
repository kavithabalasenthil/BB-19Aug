package generic_Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	static Process process;
	static AndroidDriver driver;
	
	
	
	public static void start_Server() throws IOException
	{
		String start_server = "D:\\Appium\\node.exe D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
	   process = Runtime.getRuntime().exec(start_server);
	   
	   if (process!=null)
	   {
		   System.out.println("server started");
		  
	   }
	   else
	   {
		   System.out.println("server not started");
	   }
		
	}
	
//####################################################################################################################################	
	
	public static void init_App() throws MalformedURLException{
		
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		
		Capabilities.setCapability("deviceName", "XT1033");
		Capabilities.setCapability("platformName", "Android");
		Capabilities.setCapability("platformVersion", "5.0.2");
		
		Capabilities.setCapability("appPackage", "com.bigbasket.mobileapp");
		Capabilities.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
		
		
	}
	
	//#############################################################################################################################
	public static void stop_Server()
	{
		process.destroy();
	}


	//#####################################################################################################################

	public static void explicit_Wait(WebElement ele, long Time1){
		
		WebDriverWait wait = new WebDriverWait(driver, Time1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}



}

