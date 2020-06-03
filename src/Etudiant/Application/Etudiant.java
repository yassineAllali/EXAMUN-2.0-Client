package Etudiant.Application;

import java.sql.Date;

import Etudiant.StringManipulator;

public class Etudiant extends Personne implements IRepondeur
{
	
	private String codeNatinal;
	private int idFiliere;
	
	public Etudiant(String nom, String prenom, int jour, int mois, int annee
				, String codeNatinnal, int idFiliere)
	{
		super(nom, prenom, jour, mois, annee);
		this.codeNatinal = codeNatinnal;
		this.idFiliere = idFiliere;
	}
	
	public Etudiant(String nom, String prenom, Date date, String codeNatinnal, int idFiliere)
	{
		super(nom, prenom, date);
		this.codeNatinal = codeNatinnal;
		this.idFiliere = idFiliere;
	}
	/**************************************************************************************/
	//Setters and Getters 
	public String getCodeNatinnal() {
		return codeNatinal;
	}

	public void setCodeNatinnal(String codeNatinnal) {
		this.codeNatinal = codeNatinnal;
	}

	public int getIdFiliere() {
		return idFiliere;
	}


	public String getCodeNatinal() {
		return codeNatinal;
	}
	
	public String getFullName()
	{
		return StringManipulator.capitalize(nom) 
				+ " " + StringManipulator.capitalize(prenom);
	}

	/**************************************************************************************/
	// Repondre a une question
	
	@Override
	public void repondre(IAnswerable question, Reponse reponse) 
	{
		question.setReponse(reponse);
	}
	
	/**********************************************************************/
	@Override
	public String toString() 
	{
		String etudiant = "Etudiant[Code nationnal :" + this.codeNatinal;
		etudiant += ", Nom : " + this.nom;
		etudiant += ", Prenom : " + this.prenom;
		etudiant += ", Date de naissance : " + this.naissanceStringFormat();
		etudiant += ", ID filiere : " + idFiliere + " ]";
		return etudiant;
	}
	
	/*********************************************************************/
	public static String[] toTable(Etudiant etudiant)
	{
		String[] table = { etudiant.getCodeNatinal(), etudiant.getNom(), etudiant.getPrenom(), 
				etudiant.naissanceStringFormat()};
		return table;
	}

	
}
