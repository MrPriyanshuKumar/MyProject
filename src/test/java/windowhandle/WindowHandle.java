package windowhandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		//Switching to other windows
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();
		String parentid = iterate.next();  //this code will look for window id in parent opened window 
		String childid = iterate.next();  //this code will look for window id in child opened window 
		// if one more subwindow is opened then write one more time "String subchildid = iterate.next();"
		
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
		String emailid = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		//Switch back to parent window
		driver.switchTo().window(parentid);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailid);
		

	}

}
