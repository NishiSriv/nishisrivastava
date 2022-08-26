package TestProject.Tokopedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
private static BaseClass instance;
private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();



private  BaseClass() {
}


public static BaseClass getInstance() {
	if(null==instance) {
		instance= new BaseClass();
	}
	return instance;
}


public WebDriver getDriver() {
	return webdriver.get();
}



public void initializeDriver(String DriverType) {
	if(DriverType=="Chrome")
		{
		WebDriverManager.chromiumdriver().setup();
		webdriver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

	
}

}

}
