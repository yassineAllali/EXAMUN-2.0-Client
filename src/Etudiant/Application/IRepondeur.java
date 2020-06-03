package Etudiant.Application;

// l'interface IRepondeur donne l'abilite a repondre � un objet qui implement IAnswerable
// IRepondeur 
public interface IRepondeur 
{
	// repondre a un objet Answerable
	// respond to an Aswerable
	public void repondre(IAnswerable question,Reponse reponse);
}
