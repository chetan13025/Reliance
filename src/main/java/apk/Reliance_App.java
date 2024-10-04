package apk;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
// import com.google.common.collect.ImmutableMap;
import com.opencsv.exceptions.CsvException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.remote.MobileCapabilityType;
import web.Over_Write_PRD;
import web.PRD_upload;
// import web.Properties;

public class Reliance_App extends PRD_upload {
	static AndroidDriver<WebElement> driver;
	static String timeDevice1;
	static String ird;
	static int i;
	static int j;
	static int k;
	static String Article_ID;
	static String serial_no1;
	static String Tag_name;

	public static void main(String[] args) throws CsvException, MalformedURLException, InterruptedException {
		// Loop:
		// public static void Launch() throws MalformedURLException,
		// InterruptedException, CsvException {
		PRD_upload.web();
		// Properties.pro();
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
		outerLoop: for (i = 0; i <= Article_IDS.size(); i++) {
			driver.findElement(By.id(Search_field)).sendKeys(ird);
			driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
			Thread.sleep(100);
			// driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action",
			// "search"));
			// try {
			// driver.pressKey(new
			// io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.TAB));
			// driver.pressKey(new
			// io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.TAB));
			Article_ID = Article_IDS.get(i);
			driver.findElement(By.xpath(Article_id_field)).sendKeys(Article_ID);
			driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(AndroidKey.ENTER));
			// driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action",
			// "search"));
			// Thread.sleep(5000);
			for (j = i; j <= Serial1.size(); j++) {
				serial_no1 = Serial1.get(j);
				driver.findElement(By.xpath(Serail_field)).sendKeys(serial_no1);
				driver.findElement(By.id(GradeItem)).click();
				driver.findElement(By.xpath(CheckBox1)).click();
				Thread.sleep(100);
				driver.findElement(By.xpath(CheckBox2)).click();
				driver.findElement(By.id(Next)).click();
				driver.findElement(By.id(Proceed)).click();
				for (k = j; k < tagList.size(); k++) {
					Tag_name = tagList.get(k);
					driver.findElement(By.xpath(Tag_filed)).sendKeys(Tag_name);
					if (k == tagList.size() - 1) {
						// If this is the last item, do not click AddItem, click CompleteIRD
						driver.findElement(By.id(CompleteIRD)).click();
						timeDevice1 = getCurrentTime();
						System.out.println("App Completed time " + timeDevice1);
						break outerLoop;
					} else {
						// For all other items, click AddItem
						driver.findElement(By.id(AddItem)).click();
						Thread.sleep(3000);
					}
					continue outerLoop;
				}
			}
			// break;
		}
		// continue Loop;
	}
}
