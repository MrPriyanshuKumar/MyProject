package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisabledOrEnabled {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//this is used to print the line shown in inspect
		System.out.println(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style"));
		
		
		System.out.println(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("0.5"));
		
		if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("0.5")) {
			
			System.out.println("This is expected");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			
		

		

	}

}
