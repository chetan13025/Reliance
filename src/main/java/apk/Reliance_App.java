package apk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.opencsv.exceptions.CsvException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;
import web.Over_Write_PRD;
import web.PRD_upload;
import web.Properties;

public class Reliance_App extends PRD_upload {
	static AndroidDriver<WebElement> driver;
	static String timeDevice1;
	static String ird;
	static int i;
	static int j;
	static int k;
	static String Article_ID;
	static String serial_no1;

	public static void main(String[] args) throws CsvException, MalformedURLException {

//	public static void Launch() throws MalformedURLException, InterruptedException, CsvException {
		PRD_upload.web();
//		Properties.pro();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "chetan");
		dc.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
		dc.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id(APK_userfield)).sendKeys(APK_user);
		timeDevice1 = getCurrentTime();
		System.out.println("App is visible on Device at: " + timeDevice1);
		driver.findElement(By.id(APK_passfield)).sendKeys(APK_pass);
		driver.findElement(By.id(APK_signin)).click();
		driver.findElement(By.xpath(Item_inward)).click();
		ird = Over_Write_PRD.getIRD();
		System.out.println(ird);
		driver.findElement(By.id(Search_field)).sendKeys(ird);
		driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
		for (i = 0; i <= Article_IDS.size(); i++) {
			try {
//				driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.TAB));
//				driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.TAB));
				Article_ID = Article_IDS.get(i);
				driver.findElement(By.xpath(Article_id_field)).sendKeys(Article_ID);
				driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
//				driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
//				Thread.sleep(5000);
				for ( j =i ; i <=Serial1.size(); i++) {
//					if (i<=1) {
					serial_no1=Serial1.get(j);
					driver.findElement(By.xpath(Serail_field)).sendKeys(serial_no1);
					driver.findElement(By.id(GradeItem)).click();
					driver.findElement(By.xpath(CheckBox1)).click();
					driver.findElement(By.xpath(CheckBox2)).click();
					driver.findElement(By.id(Next)).click();
//					}
					driver.findElement(By.id(Missing)).click();
					driver.findElement(By.xpath(None1)).click();
					driver.findElement(By.id(Ok)).click();
					driver.findElement(By.id(Defective)).click();
					driver.findElement(By.xpath(None2)).click();
					driver.findElement(By.id(Ok));
					driver.findElement(By.id(Complete)).click();
					driver.findElement(By.id(Proceed)).click();

					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
