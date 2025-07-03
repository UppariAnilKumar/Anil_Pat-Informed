package basetest;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import genericUtilities.UtilityClassObject;
import genericfileutility.FileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Contains TestNg Annotations
 */
@Listeners(listenerimplementation.ListenerImplementation.class)
public class BaseClass {
	public WebDriver sdriver = null;
	public FileUtility flib = new FileUtility();
	
//	step: 1 making  the driver reference global and logger implementation
	public WebDriver driver = null;
	Logger LOGGER = Logger.getLogger(BaseClass.class);
	
// step : 2	implementation for  browser launching in " incognito " mode before getting into required web page
	
//	@Parameters("Browser")
//	@BeforeClass(groups = { "Smoke", "Regression" })
	@BeforeClass(alwaysRun = true)
	/**
	 * 
	 * @BeforeClass Implementation for browser Switching and launching
	 * 
	 * **/
	public void BC(/* String Browser */) throws Throwable {
		System.out.println("==Launch Browser==");
		// Read data from properties file
//		String browser = Browser; 

		String browser =System.getProperty("browser" , flib.getDataFromPropertiesFile("Browser"));
//		String browser = flib.getDataFromPropertiesFile("Browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
		    options.addArguments("-inprivate"); 
			driver = new EdgeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("-private");
			driver = new FirefoxDriver(options);
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		
		UtilityClassObject.setDriver(driver);
		sdriver=UtilityClassObject.getDriver();
		
		
		LOGGER.info(" driver launced in Incognito mode ");
// step : 3 landing into pat-informed web page
		UtilityClassObject.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		UtilityClassObject.getDriver().manage().window().maximize();
		UtilityClassObject.getDriver().get("https://patinformed.wipo.int");
		LOGGER.info("naviagated to patinformed website ");
	}


// step: 4 Close browser window  
	/**
	 * 
	 * @AfterClass Implementation close browser window 
	 * 
	 * **/
@AfterClass(alwaysRun = true)
public void closeBrowser()
{
//	driver.close();
	 UtilityClassObject.unloadDriver();
     UtilityClassObject.unloadTest();
	LOGGER.info("   browser window closed ");
}

}

//@BeforeClass(alwaysRun = true)
//public void browserLaunching()
//{   
//	ChromeOptions opt = new ChromeOptions();
//	opt.addArguments("--incognito");
//	driver = new ChromeDriver(opt);
//	LOGGER.info(" driver launced in Incognito mode ");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//// step : 3 landing into pat-informed web page
//	driver.get("https://patinformed.wipo.int");
//	driver.manage().window().maximize();
//	LOGGER.info("naviagated to patinformed website ");
//}