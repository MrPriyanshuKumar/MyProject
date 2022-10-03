package wait;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitLearning {
 static WebDriver driver;
 
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		//Explicit wait
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("driver.findElement(By.xpath(\"//div[@id='finish']/h4\"))")));
		
		
		/*Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) wait).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		//this code is written because upper code will be applied on what objects ..so written
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
		 {
		     public WebElement apply(WebDriver driver) 
		     {
		    	 
		    	if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
		    	{
		    		return driver.findElement(By.xpath("//div[@id='finish']/h4"));
		    	}
		    	else
		    	{
		    		return null;
		    	}
		     }
		   }); */
		 
		 System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
	}
	

	

}
