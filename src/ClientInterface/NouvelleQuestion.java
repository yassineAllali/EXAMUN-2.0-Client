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

import Etudiant.InonceType;
import Etudiant.Application.Professeur;
import Serveur.ChoixManager;
import Serveur.DataBaseManager;
import Serveur.QuestionsManager;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NouvelleQuestion extends JPanel {

	private JTextField choixField1;
	private JTextField choixField2;
	private JTextField choixField3;
	private JTextField choixField4;
	private JCheckBox correcte1;
	private JCheckBox correcte2;
	private JCheckBox correcte3;
	private JCheckBox correcte4;
	
	private JCheckBox[] choix;
	private CheckListner checkLinstner;
	
	public NouvelleQuestion(JFrame frame, Professeur prof) 
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
		
		JLabel choix1 = new JLabel("Choix 1:");
		choix1.setForeground(Color.BLACK);
		choix1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		choix1.setBounds(100, 250, 300, 14);
		mainPan.add(choix1);
		
		
		
		choixField1 = new JTextField();
		choixField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choixField1.setBounds(100, 275, 250, 32);
		mainPan.add(choixField1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Choix 2:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(500, 250, 300, 14);
		mainPan.add(lblNewLabel_1_1);
		
		choixField2 = new JTextField();
		choixField2.setBackground(Color.WHITE);
		choixField2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choixField2.setBounds(500, 275, 250, 32);
		mainPan.add(choixField2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 11, 883, 2);
		mainPan.add(separator);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nouvelle Question");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(100, 45, 300, 32);
		mainPan.add(lblNewLabel_1_3);
		
		JLabel choix1_1 = new JLabel("Choix 3:");
		choix1_1.setForeground(Color.BLACK);
		choix1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		choix1_1.setBounds(100, 329, 300, 14);
		mainPan.add(choix1_1);
		
		choixField3 = new JTextField();
		choixField3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choixField3.setBounds(100, 354, 250, 32);
		mainPan.add(choixField3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Choix 4:");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(500, 329, 300, 14);
		mainPan.add(lblNewLabel_1_1_1);
		
		choixField4 = new JTextField();
		choixField4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		choixField4.setBackground(Color.WHITE);
		choixField4.setBounds(500, 354, 250, 32);
		mainPan.add(choixField4);
		
		correcte1 = new JCheckBox("");
		correcte1.setBounds(350, 275, 23, 32);
		mainPan.add(correcte1);
		
		correcte3 = new JCheckBox("");
		correcte3.setBounds(350, 354, 23, 32);
		mainPan.add(correcte3);
		
		correcte2 = new JCheckBox("");
		correcte2.setBounds(750, 275, 23, 32);
		mainPan.add(correcte2);
		
		correcte4 = new JCheckBox("");
		correcte4.setBounds(750, 354, 23, 32);
		mainPan.add(correcte4);
		
		JCheckBox[] temp = { correcte1, correcte2, correcte3, correcte4 };
		choix = temp;
		checkLinstner = new CheckListner(choix);
		
		JLabel lblCocherLaOu = new JLabel("Cocher la ou les R\u00E9ponses Correctes !");
		lblCocherLaOu.setIcon(new ImageIcon(NouvelleQuestion.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		lblCocherLaOu.setForeground(Color.BLACK);
		lblCocherLaOu.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 16));
		lblCocherLaOu.setBounds(100, 207, 673, 32);
		mainPan.add(lblCocherLaOu);
		
		JLabel choix1_2 = new JLabel("Inonc\u00E9 :");
		choix1_2.setForeground(Color.BLACK);
		choix1_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		choix1_2.setBounds(100, 88, 300, 20);
		mainPan.add(choix1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 118, 673, 67);
		mainPan.add(scrollPane);
		
		JTextArea inonceField = new JTextArea();
		scrollPane.setViewportView(inonceField);
		inonceField.setWrapStyleWord(true);
		inonceField.setLineWrap(true);
		inonceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel error1 = new JLabel("");
		error1.setForeground(Color.RED);
		error1.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		error1.setBounds(100, 308, 273, 14);
		mainPan.add(error1);
		
		JLabel error2 = new JLabel("");
		error2.setForeground(Color.RED);
		error2.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		error2.setBounds(500, 308, 273, 14);
		mainPan.add(error2);
		
		JLabel error3 = new JLabel("");
		error3.setForeground(Color.RED);
		error3.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		error3.setBounds(100, 388, 273, 14);
		mainPan.add(error3);
		
		JLabel error4 = new JLabel("");
		error4.setForeground(Color.RED);
		error4.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		error4.setBounds(500, 388, 273, 14);
		mainPan.add(error4);
		
		JLabel errorInonce = new JLabel("");
		errorInonce.setForeground(Color.RED);
		errorInonce.setFont(new Font("Sitka Display", Font.PLAIN, 14));
		errorInonce.setBounds(100, 185, 673, 14);
		mainPan.add(errorInonce);
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(ComponentManipulator.areEmpty(choixField1, choixField2, choixField3, choixField4, inonceField) )
				{
					ComponentManipulator.setEmptyError(choixField1, error1 , "Entrez le Choix 1");
					ComponentManipulator.setEmptyError(choixField2, error2 , "Entrez le Choix 2");
					ComponentManipulator.setEmptyError(choixField3, error3 , "Entrez le Choix 3");
					ComponentManipulator.setEmptyError(choixField4, error4 , "Entrez le Choix 4");
					ComponentManipulator.setEmptyError(inonceField, errorInonce , "Entrez l'inonce de la Question !");
				}
				else
				{
					ComponentManipulator.clearErrors(error1, error2, error3, error4, errorInonce);
					DataBaseManager db = new DataBaseManager();
					QuestionsManager questionManager = new QuestionsManager(db.getConnection());
					ChoixManager choixManager = new ChoixManager(db.getConnection());
					int idQuestion = questionManager.creerQuestion(prof.getIdFiliere(), inonceField.getText(), InonceType.TEXT.toString().toLowerCase());
					choixManager.creerChoix(idQuestion, choixField1.getText(), isSelected(correcte1));
					choixManager.creerChoix(idQuestion, choixField2.getText(), isSelected(correcte2));
					choixManager.creerChoix(idQuestion, choixField3.getText(), isSelected(correcte3));
					choixManager.creerChoix(idQuestion, choixField4.getText(), isSelected(correcte4));
					db.closeConnection();
					JOptionPane.showMessageDialog(null, "Question Erengistrer avec succès");
					HomeProf newPan = new HomeProf(frame, prof);
					frame.setContentPane(newPan);
					frame.revalidate();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(57, 47, 90));
		btnNewButton.setBounds(500, 413, 273, 32);
		mainPan.add(btnNewButton);

	}
	
	private void deselectAll()
	{
		for(int i = 0 ; i < 4 ; i++)
		{
			choix[i].setSelected(false);
		}
	}
	private int isSelected(JCheckBox button)
	{
		if(button.isSelected())
			return 1;
		return 0;
	}
}
