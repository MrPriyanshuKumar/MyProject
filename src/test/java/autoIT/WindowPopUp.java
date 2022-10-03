package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopUp {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		//driver.get("https://the-internet.herokuapp.com/");
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		

	}

}
