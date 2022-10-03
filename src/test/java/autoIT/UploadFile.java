package autoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://atcattest-denver.accenture.com/atcat/");
		driver.findElement(By.linkText("Non-SSO")).click();
		driver.findElement(By.cssSelector("input[id='user']")).sendKeys("priyanshu.c.kumar");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Fast%$#21");
		driver.findElement(By.cssSelector("input[id='nonSSOClient']")).sendKeys("adapthealth");
		driver.findElement(By.cssSelector("input[id='sub']")).click();
		
		Thread.sleep(60000);
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='vendorProgram']/a/span[2]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='bulkrelease']")).click();
		driver.close();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@id='fileDocument']")).click();
	
		
		//Runtime.getRuntime().exec("C:\\Users\\priyanshu.c.kumar\\OneDrive - Accenture\\Documents\\fileupload.exe");
		
		
	
				
		
				

	}

}
