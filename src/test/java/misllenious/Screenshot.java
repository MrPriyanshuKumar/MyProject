package misllenious;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	public static WebDriver driver;

	public static void tss() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"C:\\Users\\priyanshu.c.kumar\\OneDrive - Accenture\\Documents\\ATCAT\\Adapt Health\\screenshot.png"));
	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.manage().window().maximize();

		tss();

		/*
		 * Date currentDate = new Date(); System.out.println(currentDate); String
		 * screenshotFileName = currentDate.toString().replace(" ", "-").replace(":",
		 * "/");
		 * 
		 * 
		 * File screenshotFile =
		 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(screenshotFile, new
		 * File(".//screenshot/"+screenshotFileName+".png"));
		 */

	}

}
