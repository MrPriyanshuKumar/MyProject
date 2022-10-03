package learning1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Practice for selecting number of passengers from the dropdown

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
	   
	     driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	     driver.manage().window().maximize();
	     
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
	     
	     Thread.sleep(3000);
	     
	     int i=1;
	     while(i<3) {
	    	 driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
	    	 i++;
	    	 }
    
	  /*   for(int i=1;i<5;i++) 
	     {
	    	 driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click(); 
	     }
	      
	      */
	     Thread.sleep(3000);
	     
	     driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();
	     
        System.out.println( driver.findElement(By.xpath("//*[@id='divpaxinfo']")).getText());
	}

}
//we can use while or For both are same only differece is that in while loop we have write in piece by piece where
//as in for loop we can write all conditions in 1 line only

