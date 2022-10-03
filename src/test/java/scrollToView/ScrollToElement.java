package scrollToView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement logo = driver.findElement(By.xpath("//a[@class='btn btn-primary view-all-courses-btn']"));
	
		js.executeScript("arguments[0].scrollIntoView();", logo);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", logo);
		
		Thread.sleep(5000);
		WebElement nextButton = driver.findElement(By.xpath("//span[@class='next']/a"));
		js.executeScript("arguments[0].scrollIntoView();", nextButton);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", nextButton);

		
		//Why Javascript Executor is important in Selenium?
		//identifies object which has hidden elements
		
		
		
	}

}
