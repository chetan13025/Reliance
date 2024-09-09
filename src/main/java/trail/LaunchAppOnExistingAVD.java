package trail;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchAppOnExistingAVD {

    public static void main(String[] args) {
        // Set up Appium DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Default emulator name
        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Blubirch\\Downloads\\RIMS2-relianceQAReseller-1.0.75.apk"); // Path to your APK file
        capabilities.setCapability(AndroidMobileCapabilityType.AVD, "MyNewAVD"); // AVD Name
        capabilities.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
        capabilities.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");
        
        capabilities.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 30000); // Wait for AVD to launch

        // Set Appium server URL
        URL serverURL = null;
        try {
            serverURL = new URL("http://127.0.0.1:4723/wd/hub"); // Default Appium server URL
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Initialize AndroidDriver with Appium server URL and capabilities
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<>(serverURL, capabilities);

            // Wait for the app to launch
            Thread.sleep(10000); // Adjust this duration based on your system
            driver.findElement(By.xpath("com.blubirch.rims.relianceQAReseller:id/edtEmail")).sendKeys("chetan_q_rl");
            driver.findElement(By.xpath("com.blubirch.rims.relianceQAReseller:id/edtPassword")).sendKeys("blubirch@123");
            
            
            
            
            
            

            // Perform operations with the app if needed
            // e.g., driver.findElement(By.id("element_id")).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
//                driver.quit(); // Quit the driver session
            }
        }
    }
}
