package Etudiant.Application;

import java.sql.Date;

public class Professeur extends Personne
{
	private String nomUtilisateur;
	private int idFiliere;
	private boolean admin;
	
	public Professeur(String nom, String prenom,String nomUtilisateur, int idFiliere, Date date,  boolean admin) {
		super(nom, prenom, date);
		this.nomUtilisateur = nomUtilisateur;
		this.idFiliere = idFiliere;
		this.admin = admin;
	}
	public Professeur(String nom, String prenom,String nomUtilisateur, int idFiliere, Date date, int admin) {
		super(nom, prenom, date);
		this.nomUtilisateur = nomUtilisateur;
		this.idFiliere = idFiliere;
		this.admin = intToAdmin(admin);
	}
	
	private boolean intToAdmin(int admin)
	{
		if(admin == 1)
			return true;
		return false;
	}
	/********************************************************************/
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public int getIdFiliere() {
		return idFiliere;
	}
	public boolean isAdmin() {
		return admin;
	}
	//////////////////////////////////////////////////////////////////////
	public static String[] toTable(Professeur prof)
	{
		String[] table = { prof.getNomUtilisateur(), prof.getNom(), prof.getPrenom(), 
				Integer.toString(prof.getIdFiliere()), prof.naissanceStringFormat()};
		return table;
	}
	
	
}
