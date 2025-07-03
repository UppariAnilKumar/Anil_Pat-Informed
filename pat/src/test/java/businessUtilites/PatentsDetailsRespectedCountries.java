package businessUtilites;

import java.util.LinkedList;
import java.util.List;
import java.time.temporal.ChronoUnit;

import genericUtilities.DateUtilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class PatentsDetailsRespectedCountries {
//	Logger LOGGER = Logger.getLogger(getClass());
	Logger LOGGER = Logger.getLogger(PatentsDetailsRespectedCountries.class);
	
// creating object for  accessing 	DateUtilities class methods
	DateUtilities DU = new DateUtilities();
	
// create list variable  to store all available dates	
	List<String> dateText = new LinkedList<String>();
	
	
	/**
	 * Method for date validation and printing the difference in days format 
	 * input "elements" accepts List<WebElement>
	 * */
	
	
	public void DateValidationAndDifferences(List<WebElement> elements)
	{
// declaring empty String variables for [publicationDate,filingDate and grantDate]
		String publicationDate = "";
		String filingDate = "";
		String grantDate = "";
		
// printing implementation in try block 		
		try {
			
// for each loop for elements  collection  iteration 			
			for (WebElement ele : elements) {
				String text = ele.getText();
				
//	printing the dates for confirmation			
//				System.out.println(text);
				
//checking for "publication date" in the given collection
				if (text.contains("Publication date")) {
					
//storing publication date 	in a variable 				
					publicationDate = DU.extractDateUsingSplit(text);
					
// adding dates to dateText collection					
					dateText.add(publicationDate);
					
// printing Publication date
					System.out.println("Publication date =" + publicationDate);
				}
				
//checking for " Filing date " in the given collection					
				 else if (text.contains("Filing date")) {
					 
//storing filing  date	in a variable 				
					filingDate = DU.extractDateUsingSplit(DU.putDataInSingleline(text));
					dateText.add(filingDate);
					
// checking Publication date and filing date to make sure variables are non "empty"					
					if (!publicationDate.equals("") && !filingDate.equals("")) {
                     long diffPubFiling = Math.abs(ChronoUnit.DAYS.between(DU.StringToLocalDate(publicationDate), DU.StringToLocalDate(filingDate)));

 // printing the Difference between Publication date and Filing date  
						System.out.println("Difference between Publication date and Filing date are "+ diffPubFiling + " days.");

					}
					System.out.println("Filing date =" + filingDate);
				} 
				
//checking for " grant date " in the given collection			 
				 else if (text.contains("Grant date")) {
					 
//storing grant date  in a variable
					grantDate = DU.extractDateUsingSplit(text);
					dateText.add(grantDate);
					
// checking Publication date and grant  date to make sure variables are non "empty"	
					if (!publicationDate.equals("") && !grantDate.equals("")) {
						long diffPubGrant = Math.abs(ChronoUnit.DAYS.between(DU.StringToLocalDate(publicationDate), DU.StringToLocalDate(grantDate)));

// printing the Difference between Publication date and Grant date 
						System.out.println("Difference between Publication date and Grant date are "+ diffPubGrant + " days.");
					}
					
// checking grant date and filing date to make sure variables are non "empty"	
					 else if (!filingDate.equals("") && !grantDate.equals("")) {
						long diffGrantFiling = Math.abs(ChronoUnit.DAYS.between(DU.StringToLocalDate(grantDate),DU.StringToLocalDate(filingDate)));
// printing the Difference between Grant date and Filing date 
						System.out.println("Difference between Grant date and Filing date are "+ diffGrantFiling + " days.");

					}

					System.out.println("Grant date =" + grantDate);
				}
			}
		} catch (Exception e) {
			
// printing the exception caught in catch block 			
			System.out.println(e.getMessage());
			LOGGER.error(e.getMessage());
		}

	}

}
