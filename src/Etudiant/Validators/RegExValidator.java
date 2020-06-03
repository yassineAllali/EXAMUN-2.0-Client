package Etudiant.Validators;

import java.util.regex.Pattern;

public abstract class RegExValidator extends Validator 
{
	protected String regex;
	public RegExValidator(String toValidate) 
	{
		super(toValidate);
	}
	
	public String getRegex() {
		return regex;
	}
	/********************************************************/
	protected boolean matchesRegex()
	{
		return Pattern.matches(regex, (String)toValidate);
	}
	
	@Override
	public boolean isValide() 
	{
		return matchesRegex();
	}
	
}
