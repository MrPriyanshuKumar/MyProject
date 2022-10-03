package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDynamic {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		driver.findElement(By.xpath("//a[@value='PAT']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		//driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[2]/td[4]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		
		//count the number of checkbox
		System.out.println(driver.findElements(By.xpath("input[type='checkbox']")).size());

	}

}
