package misllenious;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFromTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys("Rice");
		
		List<WebElement> lists = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredList = lists.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(lists.size(), filteredList.size());

	}

}
