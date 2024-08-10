package web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PRD_upload extends Over_Write_PRD {
	static WebDriver driver;
	static String filePath = ".\\csv_file\\RL_PRD.csv";
	static String absolutePath;
	static WebElement sta;
	static String status;
	static boolean success = false;
	static ArrayList<String> Tag_ids = new ArrayList<>();
public static void web() {
//	public static void main(String[] args) throws CsvException {
		while (!success) {
			try {
				Over_Write_PRD.write();
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(URL);
				driver.findElement(By.xpath(usernamefiledW)).sendKeys(usernameW);
				driver.findElement(By.xpath(passfieldW)).sendKeys(passwordW);
				driver.findElement(By.xpath(signinw)).click();
				driver.findElement(By.xpath(PRD)).click();
				driver.findElement(By.xpath(Create_PRD)).click();
				driver.findElement(By.xpath(Upload)).click();
				driver.findElement(By.xpath(Select_file)).click();
				absolutePath = System.getProperty("user.dir") + "\\" + filePath;
				Runtime.getRuntime().exec("C://autoitfiles/fileupload.exe" + " " + absolutePath);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Confirm)).click();
				Thread.sleep(400);
				driver.navigate().refresh();
				Thread.sleep(10000);
				driver.navigate().refresh();
				sta = driver.findElement(By.xpath(File_status));
				status = sta.getText();
				if (status.equals("Completed")) {
					System.out.println(status);
					success = true;
					System.out.println(Tag_ids);
//				} else if (status.equals("Pending")) {
//					Thread.sleep(3000);
//					driver.navigate().refresh();
//				if (status.equals("Completed")) {
//						System.out.println(status);
//						success = true;
//					}
				} else {
					System.out.println("Halted");
//					tagList.clear();
//					System.out.println(tagList);

				}
			} catch (Exception e) {
				e.printStackTrace(); // Print the exception for debugging purposes
				// You may choose to add a delay or other handling for exceptions if needed
			} finally {
				driver.quit();
			}

		}

	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
		Date now = new Date();
		return sdf.format(now);
	}
}
//	int numberOfUniqueStrings = Article_IDS.size(); // Change this to the number of unique strings you want
//    ArrayList<String> uniqueStrings = generateUniqueStrings(numberOfUniqueStrings);
//    ArrayList<String> uniqueStrings = generateUniqueStrings(numberOfUniqueStrings);

	
//		System.out.println(Article_IDS);
//		System.out.println(Serial1);


