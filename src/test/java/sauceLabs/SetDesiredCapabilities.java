package sauceLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

import java.net.URL;

public class SetDesiredCapabilities {

	public static final String USERNAME = "rahul2";
    public static final String ACCESS_KEY = "xxxxx";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		//DesiredCapabilities caps = DesiredCapabilities.chrome();
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platform", "Windows 7");

		caps.setCapability("version", "51.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("http://google.com");

		System.out.println(driver.getTitle());

	}

}
