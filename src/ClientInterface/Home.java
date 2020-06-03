package ClientInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame 
{
	private int height, width;
	private JPanel contentPane;
	private JLabel textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home()
	{
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("Exam 2.0");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/AppRessources/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		height = 600;
		width = 900;
		int screenHeight  = Toolkit.getDefaultToolkit().getScreenSize().height;
		int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
		int x = (screenWidth - width) / 2;
		int y = (screenHeight - height) / 2;
		setBounds(x, y, width, height);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPan = new JPanel();
		northPan.setBackground(new Color(172,219,223));
		contentPane.add(northPan, BorderLayout.NORTH);
		
		textField = new JLabel();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/logo.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Exam 2.0");
		northPan.add(textField);
		
		JPanel southPan = new JPanel();
		contentPane.add(southPan, BorderLayout.SOUTH);
		southPan.setBackground(new Color(172,219,223));
		
		JLabel lblNewLabel = new JLabel("Developed By : Yassine El Allali");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		southPan.add(lblNewLabel);
		
		JPanel mainPan = new JPanel();
		contentPane.add(mainPan, BorderLayout.CENTER);
		mainPan.setBackground(new Color(172,219,223));
		mainPan.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				EtudiantLogin newPan = new EtudiantLogin(Home.this);
				setContentPane(newPan);
				revalidate();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setToolTipText("");
		ImageIcon etudiantIcon = new ImageIcon(Home.class.getResource("/AppRessources/etudiant_male.png"));
		etudiantIcon = IconManipulator.resizeIcon(etudiantIcon, 150, 150);
		btnNewButton.setIcon(etudiantIcon);
		btnNewButton.setBounds(112, 120, 150, 150);
		mainPan.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Espace Etudiant");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(87, 281, 200, 26);
		mainPan.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ProfLogin newPan = new ProfLogin(Home.this);
				setContentPane(newPan);
				revalidate();
			}
		});
		ImageIcon professeurIcon = new ImageIcon(Home.class.getResource("/AppRessources/teacher.png"));
		professeurIcon = IconManipulator.resizeIcon(professeurIcon, 150, 150);
		btnNewButton_3.setIcon(professeurIcon);
		btnNewButton_3.setToolTipText("");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(375, 120, 150, 150);
		mainPan.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Espace Professeur");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(350, 281, 200, 26);
		mainPan.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminLogin newPan = new AdminLogin(Home.this);
				setContentPane(newPan);
				revalidate();
			}
		});
		ImageIcon administrationIcon = new ImageIcon(Home.class.getResource("/AppRessources/administration.png"));
		administrationIcon = IconManipulator.resizeIcon(administrationIcon, 150, 150);
		btnNewButton_1.setIcon(administrationIcon);
		btnNewButton_1.setToolTipText("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(637, 120, 150, 150);
		mainPan.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Administration");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(612, 281, 200, 26);
		mainPan.add(lblNewLabel_1_2);
	}
}
