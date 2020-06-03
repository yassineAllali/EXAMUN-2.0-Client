package Serveur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import Etudiant.Application.Filiere;
import Etudiant.Application.Professeur;



public class FiliereManager extends TableManager
{

	public FiliereManager(Connection connection) {
		super(connection);
		this.table = "filieres";
		this.generalColumns = new String[2];
		this.generalColumns[0] = "id";
		this.generalColumns[1] = "intitule";
		this.generalIndex = "id";
	}
	
	/***************************************************************/
	@Override
	protected Object newObject(ResultSet result) 
	{
		try 
		{
			Filiere filiere = new Filiere(result.getInt(1), result.getString(2));
			return filiere;
		} catch (SQLException e) 
		{
			System.out.println("Error in creating object from ResultSet");
			e.printStackTrace();
			return null;
		}
	}
	/***********************************************************************************/
	// reading //
	public Filiere[] chercherFilieres()
	{
		ResultSet r = readAll();
		Object[] filieres = toObjectsTable(r);
		return Arrays.copyOf(filieres, filieres.length, Filiere[].class);
	}
	
	// return a table of filiere in String format
	public String[][] chercherFiliereTableFormat()
	{
		Filiere[] filieres = chercherFilieres();
		String[][] table = new String[filieres.length][];
		for(int i = 0 ; i < filieres.length ; i++)
		{
			table[i] = Filiere.toTable(filieres[i]);
		}
		return table;
	}
	
	public Filiere chercherFiliere(int idFiliere)
	{
		ResultSet r = readColumnsOfRecord(idFiliere);
		return (Filiere) toObject(r);
	}
	//Creating //
	public int creerFiliere(String intitule)
	{
		return createColumnsRecordBasic(new String[] {"intitule"}, new Object[] {intitule});
	}
	
	// Counting //
	public boolean isExisting(String intitule)
	{
		if(countRecordsBasic("intitule", intitule) <= 0)
			return false;
		else
			return true;
	}
	public int count(String intitule)
	{
		return countRecordsBasic("intitule", intitule);
	}
	
}
