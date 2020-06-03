package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Etudiant.Application.Professeur;
import Etudiant.Validators.UserNameValidator;
import Serveur.DataBaseManager;
import Serveur.ProfManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfLogin extends JPanel 
{
	private JTextField userField;
	/**
	 * Create the panel.
	 */
	public ProfLogin(JFrame frame) 
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
		mainPan.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel label = new JLabel("");
		ImageIcon poster = new ImageIcon(Home.class.getResource("/AppRessources/teacher_poster.jpg"));
		poster = IconManipulator.resizeIcon(poster, 500, 600);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 219, 223));
		mainPan.add(panel);
		panel.setLayout(null);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userField.setText("");
		userField.setBounds(81, 160, 300, 32);
		panel.add(userField);
		userField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur Professeur");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(81, 135, 300, 14);
		panel.add(lblNewLabel_1);
		
		
		JLabel errorUser = new JLabel("");
		errorUser.setForeground(Color.RED);
		errorUser.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorUser.setBounds(81, 192, 300, 14);
		panel.add(errorUser);
		label.setIcon(poster);
		mainPan.add(label);
		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UserNameValidator userValidator = new UserNameValidator(userField.getText());
				//checking if all fields are entered
				if(ComponentManipulator.areEmpty(userField) || !ComponentManipulator.areValide(userValidator))
				{
					ComponentManipulator.setEmptyError(userField, errorUser , "Entrez Votre Nom d'Utilisateur");
					//Check if the data are valid
					ComponentManipulator.setValideError(userValidator, errorUser , "Nom d'utilisateur Invalide!");
				}
				else
				{
					ComponentManipulator.clearErrors(errorUser);
					DataBaseManager db = new DataBaseManager();
					ProfManager manager = new ProfManager(db.getConnection());
					if( !manager.isExisting(userField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Nom d'Utilisateur Introuvable!");
						ComponentManipulator.setError(errorUser, "Nom d'Utilisateur Introuvable!");
					}
					else
					{
						Professeur prof = manager.chercherProf(userField.getText());
						db.closeConnection();
						HomeProf newPan = new HomeProf(frame, prof);
						frame.setContentPane(newPan);
						frame.revalidate();
					}
					db.closeConnection();	
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(57,47,90));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(81, 217, 300, 32);
		panel.add(btnNewButton);

	}
}
