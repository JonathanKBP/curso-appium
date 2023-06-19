package br.com.jonathan.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
			//createTestObjectDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appium:deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
	    //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
	    //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
//	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "\\Users\\Jonathan\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_1_2.apk");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "\\Users\\Jonathan\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");
//	    desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
//	    desiredCapabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");
	    
	    try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    driver.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
//	    driver.findElement(By.xpath("//*[@text='OK']")).click();
	}
	
    private static void createTestObjectDriver() {
    	MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("deviceName","Samsung Galaxy S9 Plus FHD GoogleAPI Emulator");
//        caps.setCapability("platformVersion","8.1");
//        caps.setCapability("appiumVersion", "1.9.1");
    	
    	caps.setCapability("automationName", "UiAutomator2");
    	
    	
        caps.setCapability("browserName", "");
    	caps.setCapability("platformName", "Android");
//    	caps.setCapability("platformVersion", "11");
    	caps.setCapability("deviceName", "Samsung_Galaxy_S9_free");
    	caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
    	MutableCapabilities sauceOptions = new MutableCapabilities();
    	sauceOptions.setCapability("username", "oauth-oldbutpuregold7-65c3b");
    	sauceOptions.setCapability("accessKey", "06edba44-07e4-4389-aec3-ac6aed87148e");
    	caps.setCapability("sauce:options", sauceOptions);
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("https://oauth-oldbutpuregold7-65c3b:06edba44-07e4-4389-aec3-ac6aed87148e@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
