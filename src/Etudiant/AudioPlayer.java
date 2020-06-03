package Etudiant;

//Java program to play an Audio 
//file using Clip Object 
import java.io.File; 
import java.io.IOException;  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class AudioPlayer {

	// to store current position 
	private Clip clip; 
	private Long durationMilisecond;
	private AudioInputStream audioInputStream; 
	private String fileName; 

	// constructor to initialize streams and clip 
	public AudioPlayer(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException 
	{ 
		this.fileName = fileName;
		// create AudioInputStream object 
		audioInputStream = 
				AudioSystem.getAudioInputStream(AudioPlayer.class.getResourceAsStream("/QuestionRessources/" + fileName)); 
		
		// create clip reference 
		clip = AudioSystem.getClip(); 
		
		// open audioInputStream to the clip 
		clip.open(audioInputStream); 
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		durationMilisecond = clip.getMicrosecondLength() / 1000;
	} 

	public static void main(String[] args) throws InterruptedException 
	{ 

			String fileName = "barking.wav"; 
			AudioPlayer audioPlayer;
			try {
				audioPlayer = new AudioPlayer(fileName);
				audioPlayer.play();
				System.out.println("audio Played");
			} catch (UnsupportedAudioFileException e) {
				System.out.println("Format d'audio insuportable");
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			 	
	
	}
	// Method to play the audio 
	public void play() 
	{ 
		//start the clip 
		clip.start(); 
		try {
			System.out.println(durationMilisecond);
			Thread.currentThread().sleep(durationMilisecond);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	} 
	
	// Method to reset audio stream 
	public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
											LineUnavailableException 
	{ 
		audioInputStream = AudioSystem.getAudioInputStream( 
		new File(fileName).getAbsoluteFile()); 
		clip.open(audioInputStream); 
		clip.loop(Clip.LOOP_CONTINUOUSLY); 
	} 

} 
