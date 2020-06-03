package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Etudiant.Application.Professeur;
import Etudiant.Validators.NameValidator;
import Etudiant.Validators.UserNameValidator;
import Serveur.DataBaseManager;
import Serveur.EtudiantsManager;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NouveauEtudiant extends JPanel 
{
	private JTextField codeField;
	private JTextField nomField;
	private JTextField prenomField;
	private JDateChooser dateField;
	
	public NouveauEtudiant(JFrame frame, Professeur prof) 
	{
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
		
		JLabel lblNewLabel_1 = new JLabel("Code National d'Etudiant");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 150, 300, 14);
		mainPan.add(lblNewLabel_1);
		
		
		
		codeField = new JTextField();
		codeField.setText("");
		codeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codeField.setColumns(10);
		codeField.setBounds(100, 175, 300, 32);
		mainPan.add(codeField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(100, 232, 300, 14);
		mainPan.add(lblNewLabel_1_2);
		
		nomField = new JTextField();
		nomField.setText("");
		nomField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomField.setColumns(10);
		nomField.setBounds(100, 257, 300, 32);
		mainPan.add(nomField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(500, 232, 300, 14);
		mainPan.add(lblNewLabel_1_1_1);
		
		prenomField = new JTextField();
		prenomField.setText("");
		prenomField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prenomField.setColumns(10);
		prenomField.setBounds(500, 257, 300, 32);
		mainPan.add(prenomField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date De Naissance");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(500, 152, 300, 14);
		mainPan.add(lblNewLabel_1_1_1_1);
		
		dateField = new JDateChooser();
		dateField.setEnabled(false);
		dateField.getCalendarButton().setEnabled(true);
		dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateField.setBounds(500, 177, 300, 32);
		mainPan.add(dateField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nouveau Etudiant");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(100, 60, 300, 32);
		mainPan.add(lblNewLabel_1_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 11, 883, 2);
		mainPan.add(separator);
		
		JLabel errorCode = new JLabel("");
		errorCode.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorCode.setForeground(Color.RED);
		errorCode.setBounds(100, 207, 300, 14);
		mainPan.add(errorCode);
		
		JLabel errorNom = new JLabel("");
		errorNom.setForeground(Color.RED);
		errorNom.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorNom.setBounds(100, 288, 300, 14);
		mainPan.add(errorNom);
		
		JLabel errorPrenom = new JLabel("");
		errorPrenom.setForeground(Color.RED);
		errorPrenom.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorPrenom.setBounds(500, 288, 300, 14);
		mainPan.add(errorPrenom);
		
		JLabel errorDate = new JLabel("");
		errorDate.setForeground(Color.RED);
		errorDate.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorDate.setBounds(500, 207, 300, 14);
		mainPan.add(errorDate);
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JTextField dateJTextField = (JTextField)dateField.getDateEditor().getUiComponent();
				UserNameValidator codeValidator = new UserNameValidator(codeField.getText());
				NameValidator nomValidator = new NameValidator(nomField.getText());
				NameValidator prenomValidator = new NameValidator(prenomField.getText());
				//checking if all fields are entered
				if(ComponentManipulator.areEmpty(codeField, prenomField, nomField,dateJTextField) || 
						!ComponentManipulator.areValide(codeValidator, nomValidator, prenomValidator))
				{
					ComponentManipulator.setEmptyError(codeField, errorCode , "Entrez le Code National d'Etudiant");
					ComponentManipulator.setEmptyError(prenomField, errorPrenom , "Entrez le Prenom d'Etudiant");
					ComponentManipulator.setEmptyError(nomField, errorNom , "Entrez le Nom d'Etudiant");
					ComponentManipulator.setEmptyError(dateJTextField, errorDate , "Entrez la Date de Naissance d'Etudiant");
					//Check if the data are valid
					ComponentManipulator.setValideError(codeValidator, errorCode , "Code d'Etudiant Invalide");
					ComponentManipulator.setValideError(prenomValidator, errorPrenom , "Prenom Invalide");
					ComponentManipulator.setValideError(nomValidator, errorNom , "Nom Invalide");
				}
				else
				{
					ComponentManipulator.clearErrors(errorCode, errorPrenom, errorNom, errorDate);
					DataBaseManager db = new DataBaseManager();
					EtudiantsManager manager = new EtudiantsManager(db.getConnection());
					if( manager.isExisting(codeField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Cet Etudiant Exist Déja!");
						ComponentManipulator.setError(errorCode, "Cet Etudiant Exist Déja!");
					}
					else
					{
						manager.creerEtudiant(codeField.getText(), 1, nomField.getText(),prenomField.getText(), dateField.getDate());
						db.closeConnection();
						JOptionPane.showMessageDialog(null, "Etudiant Erengistrer avec succès");
						HomeProf newPan = new HomeProf(frame, prof);
						frame.setContentPane(newPan);
						frame.revalidate();
					}
					db.closeConnection();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(57, 47, 90));
		btnNewButton.setBounds(500, 313, 300, 32);
		mainPan.add(btnNewButton);	

	}
}
