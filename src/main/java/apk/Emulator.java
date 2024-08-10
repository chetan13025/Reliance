package apk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.annotations.VisibleForTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Emulator {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 4");
		dc.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
		dc.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		DesiredCapabilities dc1 = new DesiredCapabilities();
//		dc1.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		dc1.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
//		dc1.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.31.102:5555");
//		dc1.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
//		dc1.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");
//		URL url1 = new URL("http://127.0.0.1:4723/wd/hub");
//		driver = new AndroidDriver<WebElement>(url1, dc);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	
	}

}
