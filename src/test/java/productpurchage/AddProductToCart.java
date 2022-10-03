package productpurchage;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductToCart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		int j=0;
		String[] itemsToBuy = {"Cucumber","Brocolli","Cauliflower","Carrot"};
		//converting arrays to arrays list
		
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		List<WebElement> product = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		
		
		for(int i=0; i<product.size(); i++) 
		{
			String[] name = product.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			List itemsToBeBuy = Arrays.asList(itemsToBuy);
			
			if(itemsToBeBuy.contains(formattedName))
			{
				
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
				if(j==itemsToBuy.length)
				{
					break;
				}
			}
		}
		

	}

}
