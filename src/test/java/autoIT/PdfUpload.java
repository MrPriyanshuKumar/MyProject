package autoIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PdfUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		String downloadPath = System.getProperty("user.dir");//to get project path
		
		
		
		WebDriverManager.chromedriver().setup();
		
		//to set path for storing downloaded file in project
		HashMap<String,Object> chromePref = new HashMap<String,Object>();
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("download.default_directory", downloadPath);
		
		//it will decide the preferences of what to be done before executing script
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePref);
		
		
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.xpath("//*[@id='pickfiles']/span")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\priyanshu.c.kumar\\OneDrive - Accenture\\Documents\\Anakage\\filetoupload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id='processTaskTextBtn']")));
		
		driver.findElement(By.cssSelector("span[id='processTaskTextBtn']")).click();
		
		Thread.sleep(60000);
		
		//it will check if your file is present in given folder or not
		File f = new File(downloadPath+"/ilovepdf_pages-to-jpg.zip");
		if(f.exists())
		{
			System.out.println("file found");
			//Assert.assertTrue(f.exists());
			if(f.delete())
			System.out.println("file delated");	
		}
		

	}

}
