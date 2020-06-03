package Serveur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import Etudiant.Application.Etudiant;
import Etudiant.Application.Filiere;


public class EtudiantsManager extends TableManager
{

	public EtudiantsManager(Connection connection) 
	{
		super(connection);
		this.table = "etudiants";
		this.generalColumns = new String[5];
		this.generalColumns[0] = "CodeNational";
		this.generalColumns[1] = "idFiliere";
		this.generalColumns[2] = "nom";
		this.generalColumns[3] = "prenom";
		this.generalColumns[4] = "naissance";
		this.generalIndex = "CodeNational";
	}
	
	/***********************************************************************/
	@Override
	protected Object newObject(ResultSet result) 
	{
		try {
			Etudiant etudiant = new Etudiant(result.getString(3), result.getString(4)
					, result.getDate(5), result.getString(1), result.getInt(2));
			return etudiant;
		} catch (SQLException e) 
		{
			System.out.println("Error in creating object from ResultSet");
			e.printStackTrace();
			return null;
		}
	}

	
	/**************************************************************/
	// reading //
	public Etudiant chercherEtudiant(String codeNationnal)
	{
		ResultSet r = readRecord(codeNationnal);
		return (Etudiant) toObject(r);
	}
	
	public Etudiant[] chercherEtudiantsFiliere(int idFiliere)
	{
		ResultSet r = readRecordBasic("idFiliere", idFiliere);
		Object[] etudiants = toObjectsTable(r);
		return Arrays.copyOf(etudiants, etudiants.length, Etudiant[].class);
	}
	
	public String[][] chercherEtudiantTableFormat(int idFiliere)
	{
		Etudiant[] etudiants = chercherEtudiantsFiliere(idFiliere);
		String[][] table = new String[etudiants.length][];
		for(int i = 0 ; i < etudiants.length ; i++)
		{
			table[i] = Etudiant.toTable(etudiants[i]);
		}
		return table;
	}
	
	// Creating // 
	public int creerEtudiant(String code, int idFiliere, String nom, String prenom, Date date)
	{
		Object[] values = {code, idFiliere, nom, prenom, date};
		return createColumnsRecord(values);
	}
	
	// Counting //
	public boolean isExisting(String codeNational)
	{
		if(countRecords(codeNational) <= 0)
			return false;
		else
			return true;
	}
	public int count(String codeNational)
	{
		return countRecords(codeNational);
	}
	
}
