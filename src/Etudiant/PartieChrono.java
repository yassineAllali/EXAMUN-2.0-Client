package Etudiant;

public class PartieChrono 
{
	//taille : nombre de fractions
	//periode : la duree de chaque fraction
	//counter : point to a specific fraction (0 <= counter < taille)
	private int taille, periode, counter;

	public PartieChrono(int taille, int periode) 
	{
		super();
		this.taille = taille;
		this.periode = periode;
		this.counter = taille - 1;
	}
	
	public int getCounter()
	{
		return this.counter;
	}
	
	// decremente the counter and send a flag when it overflow
	public boolean decrementer()
	{
		if(counter > 0)
		{
			counter--;
			return false;
		}
		else
		{
			counter = taille - 1;
			return true;
		}
	}
	
	//Decremente the counter when another partie overflow
	public boolean decrementer(boolean flag)
	{
		if(flag)
			return decrementer();
		return false;
	}
	
}
