package task;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basetest.BaseClass;
import businessUtilites.PatentsDetailsRespectedCountries;
import genericUtilities.UtilityClassObject;
import genericUtilities.WaitsUtility;

/**
 * 
 * ListenerImplementation.class mapping
 * 
 * **/

@Listeners(listenerimplementation.ListenerImplementation.class)
public class Task2 extends BaseClass {
	Logger LOGGER = Logger.getLogger(Task2.class);
	WaitsUtility WU = new WaitsUtility();
	PatentsDetailsRespectedCountries PDRC= new PatentsDetailsRespectedCountries();
	

	/**
	 * Contains test Script for dates validation of Publication Date, Filing Date  and Grant Date .
	 * 
	 * @throws Exception
	 * 
	 * **/

	@Test
	public void testCase2() throws Exception {
		
		
		 // step:1  wait until element get in to visibility
				WU.explicitWait(UtilityClassObject.getDriver(), "//input[@class='searchField']");
				
		 // step:2  storing element address  in to variable
				WebElement element = UtilityClassObject.getDriver().findElement(By.xpath("//input[@class='searchField']"));

		 // step:3  performing click operation on search bar
				element.sendKeys("rop",Keys.ENTER);


				LOGGER.info("landed in disclaimer page  ");
				UtilityClassObject.getTest().log(Status.INFO, "landed in disclaimer page  ");
		// step:4  wait until Disclaimer  get in to visibility	

				WU.explicitWait(UtilityClassObject.getDriver(), "//button[contains(text(),'I have read and agree to the terms')]");
				
		// step:5  performing click operation on "I have read and agree to the terms " button
//				UtilityClassObject.getDriver().findElement(By.xpath("//button[contains(text(),'I have read and agree to the terms')]")).click();
				UtilityClassObject.getTest().log(Status.INFO, "I have read and agree to the terms  button");
				
		// step:6  wait until patents body or tabs  get in to visibility
				WU.explicitWait(UtilityClassObject.getDriver(), "(//ul[@class='associations flex column']//div[contains(text(),'')])[1]");
				
		// step:7  performing click operation  first patent tab  
				UtilityClassObject.getDriver().findElement(By.xpath("(//ul[@class='associations flex column']//div[contains(text(),'')])[1]")).click();
				UtilityClassObject.getTest().log(Status.INFO, " clicked first patent tab");
				
		// step:8  Switching scroll controller countries patents informations space 		
				UtilityClassObject.getDriver().findElement(By.xpath("//div[@class='bottom flex column c-results']")).click();
				UtilityClassObject.getTest().log(Status.INFO, "Switching scroll controller countries patents informations space");

		// step:9  using robot class to perform page down operation to make country patent information to visibility 
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
				UtilityClassObject.getTest().log(Status.INFO, "perform page down operation to make country patent information to visibility");

				int i = 1;
		// step:10  store table date in   elements variable 
				List<WebElement> elements = UtilityClassObject.getDriver().findElements(By.xpath("(//table[@class='patentDetails noBorder'])[1]//tr"));
				System.out.println("size" + elements.size());
				
		// step:11 validation of  Publication Date, Filing Date , and Grant Date through while loop iteration 		
				UtilityClassObject.getTest().log(Status.INFO, "validation of  Publication Date, Filing Date , and Grant Date through while loop iteration");
				while (true) {

					if (elements.size() <= 3) {
						System.out.println("table has contain only one date or does not contain any date ");
						
		// step:12 Switching to another table  for  Publication Date, Filing Date , and Grant Date if it is not available in previous table			
						elements = UtilityClassObject.getDriver().findElements(By.xpath("(//table[@class='patentDetails noBorder'])[" + (++i) + "]//tr"));
						UtilityClassObject.getTest().log(Status.INFO, "Switching to another table  for  Publication Date, Filing Date , and Grant Date if it is not available in previous table");
						System.out.println("size 2  =" + elements.size());
					} else {
		// step:13 printing respected dates and differences among  Publication Date, Filing Date  and Grant Date .			
						UtilityClassObject.getTest().log(Status.INFO, "printing respected dates and differences among  Publication Date, Filing Date  and Grant Date");
						PDRC.DateValidationAndDifferences(elements);
						break;
					}

				}
				System.out.println("=========================+Test ROP  input done +=========================");

	}
}
