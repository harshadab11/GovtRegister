package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	public static WebDriver driver;
	
	public static void initialization(String browsername)
	{
		if (browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("incognito"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("incognito");
			driver = new ChromeDriver(opt);
		}
		else if(browsername.equalsIgnoreCase("headless"))
		{
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://copyright.gov.in/UserRegistration/frmNewUser.aspx");
	}

}
