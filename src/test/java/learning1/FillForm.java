package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FillForm {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/form-comp/div/form/div[1]/input")).sendKeys("priyanshu");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("priyanshu.c.kumar@gmail.com");
		driver.findElement(By.cssSelector("input[id='exampleInputPassword1']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		WebElement staticDropdown = driver.findElement(By.xpath("//*[@id='exampleFormControlSelect1']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Male");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		
		driver.findElement(By.cssSelector("input[id='inlineRadio1']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).click();
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		
		WebElement text = driver.findElement(By.xpath("/html/body/app-root/form-comp/div/div[2]/div"));
		System.out.println(text.getText());
		
		//driver.findElement(By.xpath("/html/body/app-root/form-comp/div/div[2]/div")).getText();
		//Assert.assertEquals("driver.findElement(By.xpath(\"/html/body/app-root/form-comp/div/div[2]/div\")).getText()" , "Success! The Form has been submitted successfully!.");
		
		

	}

}
