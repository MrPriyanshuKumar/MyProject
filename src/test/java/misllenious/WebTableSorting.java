package misllenious;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSorting {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		// Click on the column

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture all web elements to list

		List<WebElement> lists = driver.findElements(By.xpath("//tr/td[1]"));

		// Capture text of all web elements to new (original) list

		List<String> originalList = lists.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list of step 3 -> sorted list

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs Sorted list

		Assert.assertTrue(sortedList.equals(originalList));

		// scan the new column with getText ->Beans -> print the price of Beans

		lists.stream().filter(s -> s.getText().contains("Beans")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());


	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}

	

}
