package main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class automateirctc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Helllo this is revision project for Automation");
		
//		WebDriver driver = new ChromeDriver();		//Using WebDriver interface to use chrome as chromedriver
		WebDriver driver = new EdgeDriver();
		Actions action = new Actions(driver);		//Using Action class.
		JavascriptExecutor js = (JavascriptExecutor) driver;		// JavaExecutor class 
		secondClass sc = new secondClass();
		driver.get("https://www.irctc.co.in/nget/train-search");	// getting url
		driver.manage().window().maximize();		//Maximizing window size
		Thread.sleep(3000);
		
		
		String parent_Window = driver.getWindowHandle();	//Parent windowHandle
		System.out.println(parent_Window);			//Parent window 
		WebElement path = driver.findElement(By.xpath("//label[text()='HOLIDAY PACKAGES']"));	// Holiday Packages in Irctc UI
		action.moveToElement(path).click().perform();         //Action class to move to the specific element on webpages,
//		driver.findElement(By.xpath("//label[text()='HOLIDAY PACKAGES']")).click();		//
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		Set <String> child_window = driver.getWindowHandles();
		for (String child : child_window) {
			System.out.println(child);
			if(!child.equals(parent_Window)) {
				driver.switchTo().window(child);
				WebElement wb = driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/filterdata/div[2]/div[3]/h3"));
				Point p = wb.getLocation();
				int x = p.getX();
				int y = p.getY();
				System.out.println("Dimension :- "+x+" and "+y);
				js.executeScript("window.scrollBy("+x +","+y +");");
				System.out.println("Text is: "+wb.getText());
				js.executeScript("arguments[0].scrollIntoView();", wb);
//				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//*[@id=\"leftFilter\"]/filterdata/div[2]/div[3]/ul/li[44]/label")).click();
				System.out.println("Title of the webpage :- "+driver.getTitle());
				
				
				for(int i=2; i<6; i++) {
					WebElement text = driver.findElement(By.xpath("/html/body/app-root/tourpackagelist/div[2]/div/div[3]/div/div["+i+"]/div/div[2]/div/h5"));
//					WebElement duration = driver.findElement(By.xpath("/html/body/app-root/tourpackagelist/div[2]/div/div[3]/div/div["+i+"]/div/div[2]/div/div/div["+j+"]/strong"));
					String listName = text.getText();
					System.out.println(listName);
					}
				
				String price = driver.findElement(By.xpath("//div[@class = 'right-searchpack']/strong")).getText();
				System.out.println("Fair Price : "+price);
				
				Thread.sleep(5000);
				System.out.println("Dedicated Cookies :- "+driver.manage().getCookies());
				driver.close();
			}
			
			
			driver.switchTo().window(parent_Window);
			Thread.sleep(3000);
			
		}
		driver.quit();
		System.out.println("Done");
		
		//

	}

}
