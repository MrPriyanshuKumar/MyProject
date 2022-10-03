package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//dropdowns with "Select" tag  static

public class DropdownSelectors {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	     driver.manage().window().maximize();
	     
	     WebElement staticDropdown = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
	     
	     Thread.sleep(3000);
	     Select dropdown = new Select(staticDropdown);
	     dropdown.selectByValue("INR");
	     System.out.println(dropdown.getFirstSelectedOption().getText());
	     
	     Thread.sleep(3000);
	     dropdown.selectByIndex(3);
	     System.out.println(dropdown.getFirstSelectedOption().getText());
	     

	}

}
