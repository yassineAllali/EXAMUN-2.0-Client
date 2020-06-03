package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Etudiant.Application.Etudiant;
import Etudiant.Application.ExamQCM;
import Serveur.Client;
import Serveur.DataBaseManager;
import Serveur.ExamsManager;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class AreYouReady extends JPanel 
{
	Client client;
	
	public AreYouReady(JFrame frame, Etudiant etudiant) 
	{
		
		
		/***********************************************************/
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
		ImageIcon poster = new ImageIcon(Home.class.getResource("/AppRessources/student_poster.jpg"));
		poster = IconManipulator.resizeIcon(poster, 500, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 219, 223));
		mainPan.add(panel);
		panel.setLayout(null);
		
		JLabel pretLabel = new JLabel("Est-tu Pr\u00EAt \u00E0 passez l'exam?");
		pretLabel.setForeground(Color.BLACK);
		pretLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		pretLabel.setBounds(81, 183, 300, 23);
		panel.add(pretLabel);
		
		JButton btnNewButton = new JButton("Je suis Pr\u00EAt");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DataBaseManager db = new DataBaseManager();
				ExamsManager manager = new ExamsManager(db.getConnection());
				int id = manager.creerExam(etudiant.getCodeNatinnal());
				ExamQCM exam = new ExamQCM(id, etudiant.getIdFiliere(), etudiant.getCodeNatinnal());
				Question newPan = new Question(frame,etudiant, exam, 0, client);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(57,47,90));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(81, 217, 300, 32);
		panel.add(btnNewButton);
		
		JLabel etudiantName = new JLabel("<html>Bienvenu " + etudiant.getFullName() + "</html>");
		etudiantName.setForeground(Color.BLACK);
		etudiantName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		etudiantName.setBounds(81, 59, 300, 23);
		panel.add(etudiantName);
		
		JLabel connectionInfos = new JLabel("Connection en cours...");
		connectionInfos.setForeground(Color.RED);
		connectionInfos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		connectionInfos.setBounds(81, 149, 300, 23);
		panel.add(connectionInfos);
		label.setIcon(poster);
		mainPan.add(label);
		/***********************************************************************************/
		// Creating new Client
		try 
		{
			client = new Client(etudiant.getFullName());
			connectionInfos.setForeground(Color.GREEN);
			connectionInfos.setText("Connecter");
			btnNewButton.setEnabled(true);
			
		} catch (UnknownHostException e) 
		{
			connectionInfos.setText("Serveur Introuvable!");
			e.printStackTrace();
		} catch (IOException e) 
		{
			connectionInfos.setText("Erreur de Connection!");
			e.printStackTrace();
		}
	}
}
