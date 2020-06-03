package Etudiant.Validators;

public abstract class Validator 
{
	protected Object toValidate;
	public Validator(Object toValidate) 
	{
		this.toValidate = toValidate;
	}
	
	public abstract boolean isValide();

	public Object getToValidate() 
	{
		return toValidate;
	}

}
