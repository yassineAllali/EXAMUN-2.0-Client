package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import Etudiant.StringManipulator;
import Etudiant.Application.Filiere;
import Etudiant.Application.Professeur;
import Serveur.DataBaseManager;
import Serveur.FiliereManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class HomeProf extends JPanel {
	/**
	 * Create the panel.
	 */
	public HomeProf(JFrame frame, Professeur prof) 
	{
		DataBaseManager db = new DataBaseManager();
		FiliereManager manager = new FiliereManager(db.getConnection());
		Filiere filiere = manager.chercherFiliere(prof.getIdFiliere());
		String filiereString = StringManipulator.capitalize(filiere.getIntitule());
		String nomProf = StringManipulator.capitalize(prof.getNom()) + " " + StringManipulator.capitalize(prof.getPrenom());
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPan = new JPanel();
		northPan.setBackground(new Color(172, 219, 223));
		add(northPan, BorderLayout.NORTH);
		
		JLabel textField = new JLabel();
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/teacher.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Espace Professeur");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		northPan.add(textField);
		
		JPanel mainPan = new JPanel();
		mainPan.setBackground(new Color(172, 219, 223));
		add(mainPan, BorderLayout.CENTER);
		mainPan.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(295, 0, 700, 600);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(172, 219, 223));
		mainPan.add(panel_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NouveauEtudiant newPan = new NouveauEtudiant(frame, prof);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		ImageIcon newEtudiantIcon = new ImageIcon(Home.class.getResource("/AppRessources/new_etudiant.png"));
		newEtudiantIcon = IconManipulator.resizeIcon(newEtudiantIcon, 90, 90);
		btnNewButton_3.setIcon(newEtudiantIcon);
		btnNewButton_3.setToolTipText("");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(159, 89, 100, 100);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ajouter Etudiant\r\n");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(119, 202, 180, 31);
		panel_1.add(lblNewLabel_1_3);
		
		JButton btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AfficherEtudiants newPan = new AfficherEtudiants(frame, prof);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		ImageIcon afficherEtudiantIcon = new ImageIcon(Home.class.getResource("/AppRessources/afficher_etudiant.png"));
		afficherEtudiantIcon = IconManipulator.resizeIcon(afficherEtudiantIcon, 90, 90);
		btnNewButton_1_2.setIcon(afficherEtudiantIcon);
		btnNewButton_1_2.setToolTipText("");
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(159, 256, 100, 100);
		panel_1.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Afficher Etudiants");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(119, 369, 180, 31);
		panel_1.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				NouvelleQuestion newPan = new NouvelleQuestion(frame, prof);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		ImageIcon newQuestionIcon = new ImageIcon(Home.class.getResource("/AppRessources/new_question.png"));
		newQuestionIcon = IconManipulator.resizeIcon(newQuestionIcon, 90, 90);
		btnNewButton_2_1.setIcon(newQuestionIcon);
		btnNewButton_2_1.setToolTipText("");
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(359, 89, 100, 100);
		panel_1.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ajouter Question\r\n");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(319, 202, 180, 31);
		panel_1.add(lblNewLabel_1_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AfficheExams newPan = new AfficheExams(frame, prof);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		ImageIcon afficherQuestionIcon = new ImageIcon(Home.class.getResource("/AppRessources/afficher_questions.png"));
		afficherQuestionIcon = IconManipulator.resizeIcon(afficherQuestionIcon, 90, 90);
		btnNewButton_1_1_1.setIcon(afficherQuestionIcon);
		btnNewButton_1_1_1.setToolTipText("");
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(359, 256, 100, 100);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Afficher Exams");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(319, 369, 180, 31);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(172, 219, 223));
		panel.setBounds(0, 0, 296, 600);
		mainPan.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Monsieur : " + nomProf);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 100, 244, 27);
		panel.add(lblNewLabel);
		
		JLabel lblFiliereInformatique = new JLabel("Filiere : " + filiereString);
		lblFiliereInformatique.setForeground(Color.BLACK);
		lblFiliereInformatique.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblFiliereInformatique.setBounds(10, 127, 244, 24);
		panel.add(lblFiliereInformatique);
		
		JLabel lblAnneesScolaire = new JLabel("Annees Scolaire : 2020/2021");
		lblAnneesScolaire.setForeground(Color.BLACK);
		lblAnneesScolaire.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAnneesScolaire.setBounds(10, 149, 244, 27);
		panel.add(lblAnneesScolaire);

	}
}
