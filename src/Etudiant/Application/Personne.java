package Etudiant.Application;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Etudiant.DateHandler;
import Etudiant.SqlDateHandler;

public class Personne implements Serializable 
{
	protected String nom, prenom;
	protected GregorianCalendar naissance;
	
	public Personne(String nom, String prenom, int jour,int mois, int annee) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = new GregorianCalendar(annee, mois, jour);
	}
	
	public Personne(String nom, String prenom, Date date)
	{	
		SqlDateHandler sqlDate = new SqlDateHandler(date);
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = new GregorianCalendar(sqlDate.getJour(), sqlDate.getMois(), sqlDate.getAnnee());
	}
	public Personne(String nom, String prenom, java.util.Date date)
	{	
		DateHandler d = new DateHandler(date);
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = new GregorianCalendar(d.getJour(), d.getMois(), d.getAnnee());
	}

/********************************************************************************/
	/* Setters and Getters */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public GregorianCalendar getNaissance() {
		return naissance;
	}

	public void setNaissance(GregorianCalendar naissance) {
		this.naissance = naissance;
	}
	
	/********************************************************/
	//getting naissances informations
	
	//avoir le jour de naissance
	public int getJourNaissance()
	{
		return this.naissance.get(Calendar.DATE);
	}
	//avoir le mois de naissance
	public int getMoisNaissance()
	{
		return this.naissance.get(Calendar.MONTH);
	}
	//avoir l'annee de naissance
	public int getAnneeNaissance()
	{
		return this.naissance.get(Calendar.YEAR);
	}
	/************************************************************/
	public String naissanceStringFormat()
	{
		return this.getJourNaissance() + "/" + this.getMoisNaissance() + "/" + this.getAnneeNaissance();
	}
	
	@Override
	public String toString() 
	{
		String personne = "Personne[ Nom : " + this.nom;
		personne += ", Prenom : " + this.prenom;
		personne += ", Date de naissance : " + this.naissanceStringFormat() + " ]";
		return personne;
	}
	
}
