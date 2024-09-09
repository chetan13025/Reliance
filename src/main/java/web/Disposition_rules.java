//package web;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import com.google.common.collect.ImmutableMap;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//public class Disposition_rules extends Properties {
////	public static void main(String[] args) throws MalformedURLException {
//
//
//	public static void BCL() throws MalformedURLException {
////		Properties.pro();
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "chetan");
//		dc.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
//		dc.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//
//		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.id(APK_userfield)).sendKeys(APK_user);
////		timeDevice1 = getCurrentTime();
////		System.out.println("App is visible on Device at: " + timeDevice1);
//		driver.findElement(By.id(APK_passfield)).sendKeys(APK_pass);
//		driver.findElement(By.id(APK_signin)).click();
//		driver.findElement(By.xpath(Item_inward)).click();
//		driver.findElement(By.id(Search_field)).sendKeys("10001738");
//		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
//		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
//		driver.findElement(By.xpath(Article_id_field)).sendKeys("493665897");
//	}
//
//}
