package ClientInterface;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

import Etudiant.Validators.Validator;

public class ComponentManipulator
{
	// test if a comonent is emty
	public static boolean isEmpty(JTextComponent component)
	{
		String content = component.getText();
		return content.isEmpty();
	}
	
	// setting a customized message error if the component is emty
	public static void setEmptyError(JTextComponent component, JLabel error, String message)
	{
		if(isEmpty(component))
		{
			error.setText(message);
		}
		else
			error.setText("");
	}
	
	// setting a customized message error if the component is emty
		public static void setValideError(Validator validator, JLabel error, String message)
		{
			if(!validator.isValide() && error.getText().isEmpty())
			{
				error.setText(message);
			}
		}
	
	// clearing all error labels 
	public static void clearErrors(JLabel ...errors)
	{
		for(int i = 0 ; i < errors.length ; i++)
		{
			errors[i].setText("");
		}
	}
	
	 //return true of one of the component is empty 
	public static boolean areEmpty(JTextComponent ...components)
	{
		boolean flag = false;
		for(int i = 0 ; i < components.length ; i++)
		{
			if(isEmpty(components[i]))
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	// return true if all the fields are valid
	public static boolean areValide(Validator ...validators)
	{
		boolean flag = true;
		for(int i = 0 ; i < validators.length ; i++)
		{
			if(!validators[i].isValide())
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	// set a customized error message 
	public static void setError(JLabel error, String message)
	{
		error.setText(message);
	}
	
	// changing the forground of a component to bleck
	public static void changeToBlack(JComponent component)
	{
		component.setForeground(Color.BLACK);
	}
	
	public static void changeToRed(JComponent component)
	{
		component.setForeground(Color.RED);
	}
}
