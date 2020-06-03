package ClientInterface;



import java.awt.Color;

import Etudiant.ChronoBasic;
import Etudiant.PartieChrono;

public class ChronoQuestion extends ChronoBasic{

	private Question pan;
	public ChronoQuestion(Question pan) 
	{
		//setting the periode of timer
		super(10);
		this.pan = pan;
	}

	@Override
	protected void setParties() 
	{
		parties = new PartieChrono[2];
		parties[0] = new PartieChrono(100, 10);
		parties[1] = new PartieChrono( 30 , 1000);
	}


	@Override
	synchronized public void getTimerAction() 
	{	
		//Decrementing the fraction of seconds
		//Seconds partie decremente when fraction overflow
		if(parties[1].decrementer(parties[0].decrementer()))
		{
			pan.changeQuestion();
			stopChrono();
		}
		else
		{
			//Changing the color of the chrono when it's near to overflow
			if(parties[1].getCounter() <= 10)
				pan.getChronoLabel().setForeground(Color.RED);
			pan.repaint();
		}
	}


}
