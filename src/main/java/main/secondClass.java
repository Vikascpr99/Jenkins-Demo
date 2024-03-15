package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class secondClass {
	
	public static void takescreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot scr = (TakesScreenshot) driver;	                                
		File screenshot = scr.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+filename+".png"));
	}

	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		takescreenshot(driver, "file1");
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
