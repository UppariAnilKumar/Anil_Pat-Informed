package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtility {
	public void implicitlyWait(WebDriver driver,int i)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void explicitWait(WebDriver driver,String ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));

	}
	public void explicitWait(WebDriver driver,String ele,int i)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
		
	}

}
