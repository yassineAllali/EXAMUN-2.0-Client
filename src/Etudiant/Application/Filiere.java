package Etudiant.Application;

import java.util.ArrayList;

public class Filiere
{
	private int idFiliere;
	private String Intitule;
	private ArrayList<IPassable> exams;
	
	
	public Filiere(int idFiliere, String intitule)
	{
		super();
		this.idFiliere = idFiliere;
		Intitule = intitule;
		exams = new ArrayList<IPassable>();
	}
	/*******************************************************************/
	// ajouter nouveau exam
	// add new exam
	public void ajouterExam(IPassable exam)
	{
		this.exams.add(exam);
	}
	
	/******************************************************************/
	// Setters and Getters 
	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getIntitule() {
		return Intitule;
	}

	public void setIntitule(String intitule) {
		Intitule = intitule;
	}


	public ArrayList<IPassable> getExams() {
		return exams;
	}

	public void setExams(ArrayList<IPassable> exams) {
		this.exams = exams;
	}
	
	/**************************************************************************/
	@Override
	public String toString() {
		String filiere = "Filiere[ Intitulé : " + this.Intitule;
		filiere += ", Id de la filiere : " + this.idFiliere + " ]";
		return filiere;
	}
	
	//getting a table of filiere in String format
	public static String[] toTable(Filiere filiere)
	{
		String[] table = { Integer.toString(filiere.getIdFiliere()), filiere.getIntitule()};
		return table;
	}

	
}
