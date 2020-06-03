package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Etudiant.Application.Filiere;
import Etudiant.Application.Professeur;
import Etudiant.Validators.NameValidator;
import Etudiant.Validators.UserNameValidator;
import Serveur.DataBaseManager;
import Serveur.FiliereManager;
import Serveur.ProfManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NouveauProf extends JPanel {

	private JTextField utilisateurField;
	private JComboBox filiereField;
	private JTextField nomField;
	private JTextField prenomField;
	private JDateChooser dateField;
	private Filiere[] filieres;
	public NouveauProf(JFrame frame, Professeur admin) 
	{
		DataBaseManager db = new DataBaseManager();
		FiliereManager filieresManager = new FiliereManager(db.getConnection());
		filieres = filieresManager.chercherFilieres();
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPan = new JPanel();
		northPan.setBackground(new Color(172, 219, 223));
		add(northPan, BorderLayout.NORTH);
		
		JLabel textField = new JLabel();
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/administration.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Administation");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		northPan.add(textField);
		
		JPanel mainPan = new JPanel();
		mainPan.setBackground(new Color(172, 219, 223));
		add(mainPan, BorderLayout.CENTER);
		mainPan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'Utilisateur ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 150, 300, 14);
		mainPan.add(lblNewLabel_1);
		
		
		
		utilisateurField = new JTextField();
		utilisateurField.setText("");
		utilisateurField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		utilisateurField.setColumns(10);
		utilisateurField.setBounds(100, 175, 300, 32);
		mainPan.add(utilisateurField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fili\u00E8re");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(500, 150, 300, 14);
		mainPan.add(lblNewLabel_1_1);
		
		filiereField = new JComboBox();
		filiereField.setBackground(Color.WHITE);
		filiereField.setModel(new DefaultComboBoxModel(getFilieresIntitule()));
		filiereField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		filiereField.setBounds(500, 175, 300, 32);
		mainPan.add(filiereField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(100, 229, 300, 14);
		mainPan.add(lblNewLabel_1_2);
		
		nomField = new JTextField();
		nomField.setText("");
		nomField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomField.setColumns(10);
		nomField.setBounds(100, 254, 300, 32);
		mainPan.add(nomField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(500, 229, 300, 14);
		mainPan.add(lblNewLabel_1_1_1);
		
		prenomField = new JTextField();
		prenomField.setText("");
		prenomField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prenomField.setColumns(10);
		prenomField.setBounds(500, 254, 300, 32);
		mainPan.add(prenomField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date De Naissance");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(500, 308, 300, 14);
		mainPan.add(lblNewLabel_1_1_1_1);
		
		dateField = new JDateChooser();
		dateField.setEnabled(false);
		dateField.getCalendarButton().setEnabled(true);
		dateField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateField.setBounds(500, 333, 300, 32);
		mainPan.add(dateField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nouveau Professeur");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(100, 60, 300, 32);
		mainPan.add(lblNewLabel_1_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 11, 883, 2);
		mainPan.add(separator);
		
		JLabel errorUtilisateur = new JLabel("");
		errorUtilisateur.setForeground(Color.RED);
		errorUtilisateur.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorUtilisateur.setBounds(100, 206, 300, 14);
		mainPan.add(errorUtilisateur);
		
		JLabel errorNom = new JLabel("");
		errorNom.setForeground(Color.RED);
		errorNom.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorNom.setBounds(100, 286, 300, 14);
		mainPan.add(errorNom);
		
		JLabel errorPrenom = new JLabel("");
		errorPrenom.setForeground(Color.RED);
		errorPrenom.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorPrenom.setBounds(500, 286, 300, 14);
		mainPan.add(errorPrenom);
		
		JLabel errorDate = new JLabel("");
		errorDate.setForeground(Color.RED);
		errorDate.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorDate.setBounds(500, 364, 300, 14);
		mainPan.add(errorDate);
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JTextField dateJTextField = (JTextField)dateField.getDateEditor().getUiComponent();
				UserNameValidator userValidator = new UserNameValidator(utilisateurField.getText());
				NameValidator nomValidator = new NameValidator(nomField.getText());
				NameValidator prenomValidator = new NameValidator(prenomField.getText());
				//checking if all fields are entered
				if(ComponentManipulator.areEmpty(utilisateurField, prenomField, nomField, dateJTextField) || 
						!ComponentManipulator.areValide(userValidator, nomValidator, prenomValidator))
				{
					ComponentManipulator.setEmptyError(utilisateurField, errorUtilisateur , "Entrez Un nom d'utilisateur");
					ComponentManipulator.setEmptyError(prenomField, errorPrenom , "Entrez le Prenom du Professeur");
					ComponentManipulator.setEmptyError(nomField, errorNom , "Entrez le Nom du Professeur");
					ComponentManipulator.setEmptyError(dateJTextField, errorDate , "Entrez la Date de Naissance du Professeur");
					//Check if the data are valid
					ComponentManipulator.setValideError(userValidator, errorUtilisateur , "Nom d'Utilisateur Invalide");
					ComponentManipulator.setValideError(prenomValidator, errorPrenom , "Prenom Invalide");
					ComponentManipulator.setValideError(nomValidator, errorNom , "Nom Invalide");
				}
				else
				{
					ComponentManipulator.clearErrors(errorUtilisateur, errorPrenom, errorNom, errorDate);
					ProfManager manager = new ProfManager(db.getConnection());
					if( manager.isExisting(utilisateurField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Ce Professeur Exist Déja!");
						ComponentManipulator.setError(errorUtilisateur, "Ce Professeur Exist Déja!");
					}
					else
					{
						manager.creerProf(utilisateurField.getText(), determineIdFiliere()
								, nomField.getText(),prenomField.getText(), dateField.getDate());
						JOptionPane.showMessageDialog(null, "Professeur Erengistrer avec succès");
						db.closeConnection();
						HomeAdmin newPan = new HomeAdmin(frame, admin);
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
		btnNewButton.setBounds(500, 389, 300, 32);
		mainPan.add(btnNewButton);

	}
	
	private String[] getFilieresIntitule()
	{
		String[] intitules = new String[filieres.length];
		for(int i = 0 ; i < filieres.length ; i++)
		{
			intitules[i] = filieres[i].getIntitule();
		}
		return intitules;
	}
	private int determineIdFiliere()
	{
		int index = 0;
		String selected = (String)filiereField.getSelectedItem();
		for(int i = 0 ; i < filieres.length ; i++)
		{
			if(selected.equals(filieres[i].getIntitule()))
			{
				index = filieres[i].getIdFiliere();
				break;
			}
		}
		return index;
	}
	
}
