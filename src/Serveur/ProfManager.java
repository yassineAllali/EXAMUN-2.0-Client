package Serveur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

import Etudiant.Application.Etudiant;
import Etudiant.Application.Professeur;

public class ProfManager extends TableManager
{

	public ProfManager(Connection connection) {
		super(connection);
		this.table = "professeurs";
		this.generalColumns = new String[6];
		this.generalColumns[0] = "nomUtilisateur";
		this.generalColumns[1] = "idFiliere";
		this.generalColumns[2] = "nom";
		this.generalColumns[3] = "prenom";
		this.generalColumns[4] = "naissance";
		this.generalColumns[5] = "admin";
		this.generalIndex = "nomUtilisateur";
	}

	@Override
	protected Object newObject(ResultSet result) 
	{
		try {
			Professeur prof = new Professeur(result.getString(3), result.getString(4)
					,result.getString(1),result.getInt(2), result.getDate(5), result.getInt(6));
			return prof;
		} catch (SQLException e) 
		{
			System.out.println("Error in creating object from ResultSet");
			e.printStackTrace();
			return null;
		}
	}
	/**********************************************************************/
	// Reading //
	
	public Professeur chercherProf(String userName)
	{
		ResultSet r = readColumnsOfRecord(userName);
		return (Professeur)toObject(r);
	}
	 
	// return a table of professeur
	public String[][] chercherProfsTableFormat()
	{
		ResultSet r = readColumnsOfAll();
		Object[] objects = toObjectsTable(r);
		Professeur[] profs = Arrays.copyOf(objects, objects.length, Professeur[].class);
		String[][] table = new String[profs.length][];
		for(int i = 0 ; i < profs.length ; i++)
		{
			table[i] = Professeur.toTable(profs[i]);
		}
		return table;
	}
	
	//creating //
	public int creerProf(String nomUtilisateur, int idFiliere, String nom, String prenom, Date date)
	{
		Object[] values = {nomUtilisateur, idFiliere, nom, prenom, date, 0};
		return createColumnsRecord(values);
	}
	// Counting //
	public boolean isExisting(String nomUtilisateur)
	{
		if(countRecords(nomUtilisateur) <= 0)
			return false;
		else
			return true;
	}
	// test if the prof has admin privileges
	public boolean isAdmin(String nomUtilisateur)
	{
		ResultSet r = readColumnsOfRecordBasic("nomUtilisateur", nomUtilisateur, new String[] {"admin"});
		try {
			if (r.next()) 
			{
				if(r.getInt(1) == 1)
					return true;
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

}
