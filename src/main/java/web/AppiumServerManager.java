package web;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumServerManager {

    private static AppiumDriverLocalService appiumService;
    private static AndroidDriver driver;

    // Method to start the Appium server
    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info");

        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
        System.out.println("Appium Server started on: " + appiumService.getUrl().toString());
    }

    // Method to stop the Appium server
    public static void stopServer() {
        if (appiumService != null) {
            appiumService.stop();
            System.out.println("Appium Server stopped.");
        }
    }

    // Method to launch the app
    public static void launchApp() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13"); // Replace with your Android version
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "YourDeviceName"); // Replace with your device/emulator name
        dc.setCapability("appPackage", "com.blubirch.rims.relianceQAReseller");
        dc.setCapability("appActivity", "com.blubirch.commons.presentation.login.LoginActivity");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
            System.out.println("App launched successfully!");
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (WebDriverException e) {
            System.err.println("Failed to create driver session: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServer(); // Start the Appium server
        launchApp();   // Launch the app

        // Add your test automation code here

        stopServer(); // Stop the Appium server
    }
}
