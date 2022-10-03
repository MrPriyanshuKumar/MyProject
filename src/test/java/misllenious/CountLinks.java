package misllenious;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//get count of all links of footer & Limiting Web Driver scope
		WebElement footerElement = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		
		System.out.println(footerElement.findElements(By.tagName("a")).size());
		
		//get count of links in one row of footer and click on each link
		WebElement subFooter = footerElement.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(subFooter.findElements(By.tagName("a")).size());
		
		for(int i=1; i<subFooter.findElements(By.tagName("a")).size(); i++)
		{
			String clickOnLinkKeys = Keys.chord(Keys.CONTROL,Keys.ENTER); //this code will do CTRL+click on every link
			
			subFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkKeys);
		}
		
		//get link text from each opened tab
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext())
		{
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}
		

	}

}
