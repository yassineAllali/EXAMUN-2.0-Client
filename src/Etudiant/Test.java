package Etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import ClientInterface.ChronoQuestion;
import Etudiant.Application.Etudiant;
import Etudiant.Application.ExamQCM;
import Etudiant.Application.Filiere;
import Etudiant.Application.Personne;
import Etudiant.Application.QuestionQCM;
import Etudiant.Validators.UserNameValidator;
import Serveur.ChoixManager;
import Serveur.DataBaseManager;
import Serveur.EtudiantsManager;
import Serveur.ExamsManager;

public class Test {
	
	public static void testerPersonne()
	{
		Personne p = new Personne("el allali", "yassine", 13 , 6 , 1999);
		System.out.println(p);
	}
	/******************************************************************************/
	public static void testerEtudiant()
	{
		Etudiant e = new Etudiant("el allali", "yassine", 13 , 6 , 1999, 
								"N134186140", 1);
		System.out.println(e);
	}
	/******************************************************************************/

	public static void testerFiliere()
	{
		Filiere f = new Filiere(1, "informatique");
		System.out.println(f);
	}
	/******************************************************************************/
	
	public static void testerQuestionCorrection()
	{
		String i = "Quel est le nom de fondateur de Microsoft";
		String[] choix = { "Jeff Besoss" , "Elon Mask", "Steve Jobs"};
		QuestionQCM qcm = new QuestionQCM( 2 ,1, i , InonceType.TEXT);
		System.out.println(qcm);
		System.out.println("id reponse correcte : " + qcm.getReponseCorrecte());
		/*Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			try
			{
				qcm.setReponse(sc.nextInt());
				flag = false;
				sc.close();
			} catch (Exception e) 
			{
				System.out.println("reponse invalide! choisissez un le nombre de la bonne reponse");
				sc.nextLine();
			}
		}
		//////////////////////
		ExamQCM exam = new ExamQCM(1, "n134186140");
		exam.ajouterQuestion(qcm, 1);
		///////////////////
		CorrecteurQCM correcteur = new CorrecteurQCM(exam);
		if(correcteur.courigerQuestion(qcm))
		{
			System.out.println("Bonne Reponse");
		}
		else
		{
			System.out.println("Reponse incorrecte : la bonne reponse est : " + choix[qcm.getReponseCorrecteInt()]);
		}*/
		
	}
	/**********************************************************************************************/
	public static void testerExam()
	{
		DataBaseManager db = new DataBaseManager();
		ExamsManager manager = new ExamsManager(db.getConnection());
		int idExam = manager.creerExam("N134186140");
		ExamQCM qcm = new  ExamQCM(idExam, 1, "N134186140");
		System.out.println(qcm);
		System.out.println(idExam);
	}
	
	/**************************************************************************************/
	public static void testerDataBaseManager()
	{
		
	}

	public static void testerValidator()
	{
		/*String toValidate;
		Scanner sc = new Scanner(System.in);
		toValidate = sc.nextLine();
		System.out.println(validator.isValide());
		System.out.println(date);*/
	}
	/*************************************************************/

	
	public static void main(String[] args) 
	{
		
	}

}
