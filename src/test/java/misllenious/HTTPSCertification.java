package misllenious;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTTPSCertification {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();  //code to open the restricted URL
		option.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");//code to handle all proxy things
		option.setCapability("Proxy", proxy);//code to set proxy
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionkeys");
		
		option.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking")); //code to block popup
		
		System.out.println(driver.getTitle());
		
		//Code to download file in specified location
		Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path/priyanshu.c.kumar");
        option.setExperimentalOption("prefs", prefs);
		
		
		//URL - https://chromedriver.chromium.org/
		
		

	}

}
