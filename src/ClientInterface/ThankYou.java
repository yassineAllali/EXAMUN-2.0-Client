package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Etudiant.StringManipulator;
import Etudiant.Application.Etudiant;
import Etudiant.Application.ExamQCM;
import Serveur.Client;


public class ThankYou extends JPanel 
{

	public ThankYou(JFrame frame, Etudiant etudiant, ExamQCM exam, Client client)
	{
		//envoie d'exam au serveur de correction 
		client.envoyerExam(exam);
		client.shutDown();
		///////////////////////////////
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPan = new JPanel();
		northPan.setBackground(new Color(172, 219, 223));
		add(northPan, BorderLayout.NORTH);
		
		JLabel textField = new JLabel();
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/etudiant_female.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Espace Etudiant");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		northPan.add(textField);
		
		JPanel mainPan = new JPanel();
		mainPan.setBackground(new Color(172, 219, 223));
		add(mainPan, BorderLayout.CENTER);
		mainPan.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel label = new JLabel("");
		ImageIcon poster = new ImageIcon(Home.class.getResource("/AppRessources/thankyou.jpg"));
		poster = IconManipulator.resizeIcon(poster, 500, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 219, 223));
		mainPan.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Au Revoir");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(57,47,90));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(81, 217, 300, 32);
		panel.add(btnNewButton);
		
		JLabel etudiantName = new JLabel("<html>Merci " +  StringManipulator.capitalize(etudiant.getNom()) 
										+ " " + StringManipulator.capitalize(etudiant.getPrenom())+" de passez l'exam avec succès</html>" );
		etudiantName.setForeground(Color.BLACK);
		etudiantName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		etudiantName.setBounds(81, 59, 300, 100);
		panel.add(etudiantName);
		label.setIcon(poster);
		mainPan.add(label);
	}

}
