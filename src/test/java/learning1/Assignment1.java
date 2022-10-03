package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).isSelected());
		driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='checkBoxOption1']")).isSelected());

		System.out.println(driver.findElements(By.xpath("//*[@type='checkbox']")).size());

	}

}
