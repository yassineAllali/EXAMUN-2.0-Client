package ClientInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Etudiant.Application.Filiere;
import Etudiant.Application.Professeur;
import Serveur.DataBaseManager;
import Serveur.FiliereManager;
import Serveur.ProfManager;

public class AfficherProfs extends JPanel {
	
	JTable table;
	String[][] profs;
	Filiere[] filieres;

	public AfficherProfs(JFrame frame, Professeur admin) 
	{
		DataBaseManager db = new DataBaseManager();
		ProfManager manager = new ProfManager(db.getConnection());
		profs = manager.chercherProfsTableFormat();
		FiliereManager fManager = new FiliereManager(db.getConnection());
		filieres = fManager.chercherFilieres();
		db.closeConnection();
		setFiliere();
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		JPanel northPan = new JPanel();
		northPan.setBackground(new Color(172, 219, 223));
		add(northPan, BorderLayout.NORTH);
		
		JLabel textField = new JLabel();
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/administration.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Administration");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		northPan.add(textField);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(172, 219, 223));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setHorizontalAlignment(SwingConstants.LEADING);
		panel_1.add(btnRetour);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				HomeAdmin newPan = new HomeAdmin(frame, admin);
				frame.setContentPane(newPan);
				frame.revalidate();
			}
		});
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnRetour.setBackground(new Color(57, 47, 90));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(profs ,new String[] {
				"Code National", "Nom", "Prenom", "Filiere", "Date de Naissance"
				});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}

	// setting the Intitule of every Prof instead of the idFiliere
	private void setFiliere()
	{
		for(int i = 0; i < profs.length; i++)
		{
			int idFiliere = Integer.parseInt(profs[i][3]);
			profs[i][3] = determinerFiliere(idFiliere);
		}
	}
	private String determinerFiliere(int idFiliere)
	{
		String filiere = "none";
		for(int i = 0 ; i < filieres.length ; i++)
		{
			if(filieres[i].getIdFiliere() == idFiliere)
			{
				filiere = filieres[i].getIntitule();
				break;
			}
		}
		return filiere;
	}
}
