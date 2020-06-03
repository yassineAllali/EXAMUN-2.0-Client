package ClientInterface;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JTextField;

import Etudiant.Application.Etudiant;
import Etudiant.Application.Professeur;
import Etudiant.Validators.UserNameValidator;
import Serveur.DataBaseManager;
import Serveur.EtudiantsManager;
import Serveur.ProfManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EtudiantLogin extends JPanel {
	
	private JTextField codeField;
	/**
	 * Create the panel.
	 */
	public EtudiantLogin(JFrame frame) {
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
		
		codeField = new JTextField();
		codeField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				codeField.setForeground(Color.black);
			}
		});
		codeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codeField.setText("");
		codeField.setBounds(81, 160, 300, 32);
		panel.add(codeField);
		codeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Code National d'Etudiant");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(81, 135, 300, 14);
		panel.add(lblNewLabel_1);
		
		JLabel errorUser = new JLabel("");
		errorUser.setForeground(Color.RED);
		errorUser.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorUser.setBounds(81, 190, 300, 14);
		panel.add(errorUser);
		label.setIcon(poster);
		mainPan.add(label);

		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UserNameValidator codeValidator = new UserNameValidator(codeField.getText());
				//checking if all fields are entered
				if(ComponentManipulator.areEmpty(codeField) || !ComponentManipulator.areValide(codeValidator))
				{
					ComponentManipulator.setEmptyError(codeField, errorUser , "Entrez Votre Code National");
					//Check if the data are valid
					ComponentManipulator.setValideError(codeValidator, errorUser , "Code National Invalide!");
				}
				else
				{
					ComponentManipulator.clearErrors(errorUser);
					DataBaseManager db = new DataBaseManager();
					EtudiantsManager manager = new EtudiantsManager(db.getConnection());
					if( !manager.isExisting(codeField.getText()))
					{
						JOptionPane.showMessageDialog(null, "Code National Introuvable!");
						ComponentManipulator.setError(errorUser, "Code National Introuvable!");
					}
					else
					{
						Etudiant etudiant = manager.chercherEtudiant(codeField.getText());
						db.closeConnection();
						AreYouReady newPan = new AreYouReady(frame,  etudiant);
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
		btnNewButton.setBounds(81, 215, 300, 32);
		panel.add(btnNewButton);
		
		
	}
}
