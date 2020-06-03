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
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import Etudiant.PartieChrono;
import Etudiant.Application.Etudiant;
import Etudiant.Application.ExamQCM;
import Etudiant.Application.QuestionQCM;
import Etudiant.Application.Reponse;
import Serveur.Client;
import Serveur.DataBaseManager;
import Serveur.ReponsesManager;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Question extends JPanel
{
	private int nombreQuestions, indexQuestion;
	private QuestionQCM question;
	private JRadioButton[] choix;
	private CheckListner checkListner;
	private ChronoQuestion chrono;
	private JLabel chronoLabel;
	private PartieChrono fractions;
	private PartieChrono seconds;
	private JFrame frame;
	private Etudiant etudiant;
	private ExamQCM exam;
	private Client client;
	
	public Question(JFrame frame,Etudiant etudiant, ExamQCM exam, int indexQuestion, Client client)
	{
		this.frame = frame;
		this.exam = exam;
		this.etudiant = etudiant;
		this.client = client;
		nombreQuestions = exam.getNombresQuestions();
		this.indexQuestion = indexQuestion;
		question = (QuestionQCM) exam.getQuestion(indexQuestion);
		choix = new JRadioButton[4];
		chrono = new ChronoQuestion(this);
		fractions = chrono.getParties()[0];
		seconds = chrono.getParties()[1];
		/***************************************************/
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		JPanel northPan = new JPanel();
		northPan.setBorder(new EmptyBorder(0, 0, 5, 0));
		northPan.setBackground(new Color(172, 219, 223));
		add(northPan, BorderLayout.NORTH);
		
		JLabel textField = new JLabel();
		ImageIcon logo = new ImageIcon(Home.class.getResource("/AppRessources/etudiant_female.png"));
		logo = IconManipulator.resizeIcon(logo, 50, 50);
		textField.setIcon(logo);
		textField.setText("Exam En ligne");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 30));
		northPan.add(textField);
		
		JPanel mainPan = new JPanel();
		mainPan.setBackground(new Color(172, 219, 223));
		add(mainPan, BorderLayout.CENTER);
		mainPan.setLayout(new GridLayout(1, 2, 0, 0));
		ImageIcon poster = new ImageIcon(Home.class.getResource("/AppRessources/student_poster.jpg"));
		poster = IconManipulator.resizeIcon(poster, 500, 600);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(172, 219, 223));
		mainPan.add(panel);
		panel.setLayout(null);
		// adding the html tag to wrap content automatically
		JLabel lblNewLabel_1 = new JLabel("<html>" + (String) exam.getQuestion(indexQuestion).getInonce() + "</html>" );
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 85, 358, 162);
		panel.add(lblNewLabel_1);
		
		JLabel questionNumber = new JLabel("Question Num\u00E9ro " + (indexQuestion + 1 ) + ":");
		questionNumber.setForeground(Color.BLACK);
		questionNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		questionNumber.setBounds(40, 40, 300, 23);
		panel.add(questionNumber);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(172, 219, 223));
		mainPan.add(panel_1);
		
		//Chrono
		this.chronoLabel = new JLabel(Integer.toString(seconds.getCounter()) + ":" + Integer.toString(fractions.getCounter()));
		chronoLabel.setBackground(Color.WHITE);
		chronoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chronoLabel.setVerticalAlignment(SwingConstants.TOP);
		chronoLabel.setForeground(Color.BLACK);
		chronoLabel.setFont(new Font("Goudy Stout", Font.PLAIN, 30));
		chronoLabel.setBounds(10, 30, 423, 88);
		panel_1.add(chronoLabel);
		
		JLabel lblChoisirLaBonne = new JLabel("Choisit La bonne R\u00E9ponse :");
		lblChoisirLaBonne.setForeground(Color.BLACK);
		lblChoisirLaBonne.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblChoisirLaBonne.setBounds(40, 200, 300, 23);
		panel_1.add(lblChoisirLaBonne);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(Integer.toString(question.getSeulChoix(0).getId()));
		rdbtnNewRadioButton.setBackground(new Color(172, 219, 223));
		rdbtnNewRadioButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		rdbtnNewRadioButton.setForeground(Color.BLACK);
		rdbtnNewRadioButton.setBounds(40, 230, 21, 23);
		panel_1.add(rdbtnNewRadioButton);
		choix[0] = rdbtnNewRadioButton;
		JLabel lblNewLabel = new JLabel(question.getSeulChoix(0).getText());
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 230, 343, 23);
		panel_1.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(Integer.toString(question.getSeulChoix(1).getId()));
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setBackground(new Color(172, 219, 223));
		rdbtnNewRadioButton_1.setBounds(40, 256, 21, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		choix[1] = rdbtnNewRadioButton_1;
		JLabel lblNewLabel_2 = new JLabel(question.getSeulChoix(1).getText());
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(67, 256, 343, 23);
		panel_1.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(Integer.toString(question.getSeulChoix(2).getId()));
		rdbtnNewRadioButton_2.setForeground(Color.BLACK);
		rdbtnNewRadioButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		rdbtnNewRadioButton_2.setBackground(new Color(172, 219, 223));
		rdbtnNewRadioButton_2.setBounds(40, 282, 21, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		choix[2] = rdbtnNewRadioButton_2;
		JLabel lblNewLabel_3 = new JLabel(question.getSeulChoix(2).getText());
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(67, 282, 343, 23);
		panel_1.add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton(Integer.toString(question.getSeulChoix(3).getId()));
		rdbtnNewRadioButton_3.setForeground(Color.BLACK);
		rdbtnNewRadioButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		rdbtnNewRadioButton_3.setBackground(new Color(172, 219, 223));
		rdbtnNewRadioButton_3.setBounds(40, 308, 21, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		choix[3] = rdbtnNewRadioButton_3;	
		JLabel lblNewLabel_4 = new JLabel(question.getSeulChoix(3).getText());
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(67, 308, 343, 23);
		panel_1.add(lblNewLabel_4);
		
		checkListner = new CheckListner(choix);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				deselectAll();
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setBounds(40, 352, 180, 32);
		panel_1.add(btnAnnuler);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				chrono.stopChrono();
				changeQuestion();
			}
		});
		btnValider.setForeground(Color.WHITE);
		btnValider.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnValider.setBackground(new Color(51, 204, 0));
		btnValider.setBounds(230, 352, 180, 32);
		panel_1.add(btnValider);
		chrono.start();

	}
	/*****************************************************************/
	private boolean isAnswered()
	{
		boolean flag = false;
		for(int i = 0 ; i < 4 ; i++)
		{
			if(choix[i].isSelected())
			{
				flag = true;
				break;
			}
		}
		return flag;
	}
	private int getAnswer()
	{
		int answer = 0;
		for(int i = 0 ; i < 4 ; i++)
		{
			if(choix[i].isSelected())
			{
				answer = Integer.parseInt(choix[i].getText());
				break;
			}
		}
		return answer;
	}
	private void deselectAll()
	{
		for(int i = 0 ; i < 4 ; i++)
		{
			choix[i].setSelected(false);
		}
	}
	
	public void changeQuestion()
	{
		Question.this.indexQuestion++;
		DataBaseManager db = new DataBaseManager();
		ReponsesManager  manager = new ReponsesManager(db.getConnection());
		manager.creerReponse(exam.getIdExam(), question.getId(), getAnswer());
		question.setReponse(new Reponse(exam.getIdExam(), question.getId(), getAnswer()));
		db.closeConnection();
		if(indexQuestion < nombreQuestions )
		{
			Question newPan = new Question(frame, etudiant, exam, Question.this.indexQuestion, client);
			frame.setContentPane(newPan);
			frame.revalidate();
		}
		else
		{
			ThankYou thankyou = new ThankYou(frame, etudiant, exam, client);
			frame.setContentPane(thankyou);
			frame.revalidate();
		}
	}
	
	@Override
	public void repaint() {
		super.repaint();
		if(chronoLabel != null)
			this.chronoLabel.setText(Integer.toString(seconds.getCounter()) + ":" + Integer.toString(fractions.getCounter()));
	}
	
	// getting the chrono label
	public JLabel getChronoLabel()
	{
		return chronoLabel;
	}

}
