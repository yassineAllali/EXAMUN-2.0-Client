package Etudiant.Application;


// ICorrectable est l'abilite � etre couriger 
// ICorrectable has the ability to be correctd
public interface ICorrectable 
{
	// la reponse d'un IRepondeur
	// respond of a IRepondeur
	public Reponse getReponse();
	// la bonne reponse d'un IAnswerable
	// the correct respond of an IAnswerable
	public Object getReponseCorrecte();
}
