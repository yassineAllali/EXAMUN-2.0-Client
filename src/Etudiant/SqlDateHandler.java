package Etudiant;

import java.sql.Date;
import java.util.Calendar;

public class SqlDateHandler 
{
	private Date sqlDate;
	public SqlDateHandler(Date sqlDate) 
	{
		this.sqlDate = sqlDate;
	}
	
	public java.util.Date getDate()
	{
		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		return utilDate;
	}
	
	public int getJour()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMois()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		return cal.get(Calendar.MONTH);
	}
	
	public int getAnnee()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(sqlDate);
		return cal.get(Calendar.YEAR);
		
	}
	
	
}
