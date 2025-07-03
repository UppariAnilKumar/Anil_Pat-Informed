package genericUtilities;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtilities {
	
	public  String extractDateUsingSplit(String input) 
	{
	    String[] parts = input.split(" ");
	    for (String part : parts) {
	        if (part.matches("\\d{4}-\\d{2}-\\d{2}"))
	        {
	            return part;
	        }
	    }
	    return "Date not found";
	}
	
	public  String extractDate(String input) 
	{
	   
	    String dateFormat = "\\d{4}-\\d{2}-\\d{2}";
	   Pattern pattern = Pattern.compile(dateFormat);
	   Matcher matcher = pattern.matcher(input);

	    if (matcher.find())
	    {
	        return matcher.group();
	    } 
	    else 
	    {
	        return "Date not found";
	    }
	}

	public String putDataInSingleline(String data) 
	{
	    String[] p = data.split("\\r?\\n");
	    return p[0] + "  " + p[1];
	}

	 public LocalDate StringToLocalDate(String dateinput) 
	    {
	        LocalDate localDate = LocalDate.parse(dateinput);
	         return  localDate;
	    }
}
