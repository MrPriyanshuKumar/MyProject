package calender;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateMonth {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
	
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		                          
	//this will select month
		
		while(! driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("November"))
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		} 
		
		//this will select date
		List<WebElement> dateList = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		//grab common attribute //put into list and iterate 
		int allDate = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		
		for(int i=0; i<allDate; i++)
		{
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
		
		if(text.equalsIgnoreCase("23"))
		{
			driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
			break;
		}
		}

	}

}
