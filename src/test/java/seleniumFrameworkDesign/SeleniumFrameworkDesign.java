package seleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFrameworkDesign {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(By.id("userEmail")).sendKeys("priyanshu@example.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password@1");
		driver.findElement(By.id("login")).click();

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='mb-3']")));

		List<WebElement> products = driver.findElements(By.cssSelector("div[class*='mb-3']"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector("div[class='card-body'] button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-animating")));
		Thread.sleep(6000);
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("button[routerlink*='cart']"))));
		driver.findElement(By.xpath("//app-dashboard[@class='ng-star-inserted']/app-sidebar/nav/ul/li[4]/button"))
				.click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		// Take away points here is .anyMatch i used
		boolean item = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(item);
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//div[@class='subtotal cf
		// ng-star-inserted']/ul/li[3]/button")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkOut = driver
				.findElement(By.xpath("//div[@class='subtotal cf ng-star-inserted']/ul/li[3]/button"));

		js.executeScript("arguments[0].scrollIntoView();", checkOut);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", checkOut);

		// By.xpath("//input[@placeholder='Select Country']")
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "ind").build().perform();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));

		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

		driver.findElement(By.xpath("//a[contains(@class,'btnn action')]")).click();

		String confirmation = driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();

		Assert.assertTrue(confirmation.equalsIgnoreCase(" Thankyou for the order. "));

		driver.close();

	}

}
