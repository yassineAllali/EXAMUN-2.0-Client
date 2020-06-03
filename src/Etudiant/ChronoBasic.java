package Etudiant;


public abstract class ChronoBasic extends Thread
{
	protected PartieChrono[] parties;
	//the fraction of the timer
	protected int periode;
	protected volatile boolean running = true;
	
	public ChronoBasic(int periode) 
	{
		setParties();
		this.periode = periode;
	}
	
	public PartieChrono[] getParties()
	{
		return this.parties;
	}
	
	protected abstract void setParties();
	protected abstract void getTimerAction();
	
	@Override
	public void run() {
		super.run();
		while(running)
		{
			getTimerAction();
			try {
				sleep(periode);
			} catch (InterruptedException e) {
				System.out.println("Thread interrumpted");
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public void stopChrono()
	{
		running = false;
	}
}
