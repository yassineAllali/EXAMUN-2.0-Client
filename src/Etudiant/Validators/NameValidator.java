package Etudiant.Validators;

public class NameValidator extends RegExValidator
{

	public NameValidator(String toValidate) 
	{
		super(toValidate);
		this.regex = "[a-zA-Z ]+";
	}
	
}
