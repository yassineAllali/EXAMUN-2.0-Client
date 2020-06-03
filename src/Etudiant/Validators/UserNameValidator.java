package Etudiant.Validators;

public class UserNameValidator extends RegExValidator
{

	public UserNameValidator(String toValidate) 
	{
		super(toValidate);
		this.regex = "[a-zA-Z0-9 ]+";
	}

}
