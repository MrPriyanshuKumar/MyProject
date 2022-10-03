package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertJava {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys("Priyanshu");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().accept();
	    
	    driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().dismiss();

	}

}
