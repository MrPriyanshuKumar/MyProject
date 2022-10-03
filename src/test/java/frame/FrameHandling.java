package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://jqueryui.com/droppable/");
		
		//Switch to frame
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		
		//Drag&Drop using Actions class
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//To get the count of number of frames present in your application
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//To Come out of Frame
		driver.switchTo().defaultContent();
		

	}

}
