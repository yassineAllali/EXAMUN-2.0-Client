package Etudiant;

import java.util.Calendar;
import java.util.Date;

public class DateHandler 
{
	private Date date;
	public DateHandler(Date date) 
	{
		this.date = date;
	}

	
	public int getJour()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMois()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	public int getAnnee()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
		
	}
}
