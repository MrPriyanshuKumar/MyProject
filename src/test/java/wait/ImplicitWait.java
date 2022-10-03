package wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//ExplicitWait
		
		

		String[] itemsToBuy = { "Cucumber", "Brocolli", "Cauliflower", "Carrot" };
		// converting arrays to arrays list

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		addToCart(driver, itemsToBuy);
		driver.findElement(By.xpath("//*[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//WebDriverWait w =new WebDriverWait(driver,5);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='promoInfo']")).getText());
		

		
		
		
	}

	public static void addToCart(WebDriver driver, String[] itemsToBuy) {
		int j = 0;
		List<WebElement> product = driver.findElements(By.cssSelector("h4[class='product-name']"));
		
		
		
		
    
		for (int i = 0; i < product.size(); i++) {
			String[] name = product.get(i).getText().split("-");
			String formattedName = name[0].trim();

			List itemsToBeBuy = Arrays.asList(itemsToBuy);

			if (itemsToBeBuy.contains(formattedName)) {

				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

				if (j == itemsToBuy.length) {
					break;
				}
			}
		}
	}

	
	
}
