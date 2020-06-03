package ClientInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Etudiant.PartieChrono;


public class Test extends JFrame {
	
	private int height, width;

	private JPanel contentPane;
	Timer timer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setTitle("Exam 2.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/AppRessources/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		height = 600;
		width = 900;
		int screenHeight  = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - width) / 2;
		int y = (screenHeight - height) / 2;
		setBounds(x, y, width, height);
		//ProfLogin pan = new ProfLogin();
		//EtudiantLogin pan = new EtudiantLogin();
		//AdminLogin pan = new AdminLogin();
		//AreYouReady pan = new AreYouReady();
		//Question pan = new Question();
		//HomeProf pan = new HomeProf();
		//ThankYou pan = new ThankYou(this, new Etudiant("el allali", "yassine", 13, 6,1999,"n134186140", 1));
		//NouveauEtudiant pan = new NouveauEtudiant(this);
		//NouvelleQuestion pan = new NouvelleQuestion(this);
		/*Object[][] etudiant = new Object[1][4];
		etudiant[0][0] = "N134186140";
		etudiant[0][1] = "el allali";
		etudiant[0][2] = "yassine";
		etudiant[0][3] = "13/6/1999";
		//AfficheExams pan = new AfficheExams(etudiant);
		//AfficherEtudiants pan = new AfficherEtudiants(etudiant);
		//HomeAdmin pan = new HomeAdmin();
		//NouveauProf pan = new NouveauProf();
		//AfficherProfs pan = new AfficherProfs(etudiant);
		//
		//NouvelleFiliere pan = new NouvelleFiliere();
		//setContentPane(pan);*/
		
	}

}
