package misllenious;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PartialScreenshot {

	//Taking WebElement partial screenshot in selenium 
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
	    //switching to new Tab or Window
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		
		driver.get("https://rahulshettyacademy.com");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentWindow);
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys(courseName);
		//Take partial Screenshot of web element 
		
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\\\Users\\\\priyanshu.c.kumar\\\\OneDrive - Accenture\\\\Documents\\\\ATCAT\\\\Adapt Health\\\\screenshot.png"));
		//To view files in your local, right click on Screenshot go to properties and copy file location 
		
		//get Height & breadth of the text box 
		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		

	}

}
