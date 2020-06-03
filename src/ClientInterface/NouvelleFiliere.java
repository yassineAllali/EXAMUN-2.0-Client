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
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Etudiant.Application.Professeur;
import Etudiant.Validators.NameValidator;
import Serveur.DataBaseManager;
import Serveur.FiliereManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NouvelleFiliere extends JPanel {

	private JTextField intituleFieled;
	public NouvelleFiliere(JFrame frame, Professeur admin) 
	{

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
		
		JLabel lblNewLabel_1 = new JLabel("Intitul\u00E9");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 150, 300, 14);
		mainPan.add(lblNewLabel_1);
		
		
		
		intituleFieled = new JTextField();
		intituleFieled.setText("");
		intituleFieled.setFont(new Font("Tahoma", Font.PLAIN, 14));
		intituleFieled.setColumns(10);
		intituleFieled.setBounds(100, 175, 300, 32);
		mainPan.add(intituleFieled);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nouvelle Fili\u00E8re");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(100, 60, 300, 32);
		mainPan.add(lblNewLabel_1_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 11, 883, 2);
		mainPan.add(separator);
		
		JLabel errorIntitule = new JLabel("");
		errorIntitule.setForeground(Color.RED);
		errorIntitule.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorIntitule.setBounds(100, 208, 300, 14);
		mainPan.add(errorIntitule);
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				NameValidator intituleValidator = new NameValidator(intituleFieled.getText());
				//checking if all fields are entered
				if(ComponentManipulator.areEmpty(intituleFieled) || !ComponentManipulator.areValide(intituleValidator))
				{
					ComponentManipulator.setEmptyError(intituleFieled, errorIntitule , "Entrez Un Intitule!");
					//Check if the data are valid
					ComponentManipulator.setValideError(intituleValidator, errorIntitule , "Intitule Invalide");
				}
				else
				{
					ComponentManipulator.clearErrors(errorIntitule);
					DataBaseManager db = new DataBaseManager();
					FiliereManager manager = new FiliereManager(db.getConnection());
					if( manager.isExisting(intituleFieled.getText()))
					{
						JOptionPane.showMessageDialog(null, "Cette Filiere Exist Déja!");
						ComponentManipulator.setError(errorIntitule, "Cette Filiere Exist Déja!");
					}
					else
					{
						manager.creerFiliere(intituleFieled.getText());
						JOptionPane.showMessageDialog(null, "Filiere Erengistrer avec succès");
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
		btnNewButton.setBounds(500, 174, 300, 32);
		mainPan.add(btnNewButton);

	}

}
