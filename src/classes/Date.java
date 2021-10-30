package classes;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 * @author GerlariMin
 * Classe générant les dates utilisées dans le projet.
 *
 */
public class Date 
{
	// Attribut qui permettra de convertir Calendar.DAY_OF_WEEK en String
	private String[] convertionJourSemaine = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	// Attribut qui permettra de convertir Calendar.MOUNTH en String
	private String[] convertionMois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
	// Attribut pour indiquer le nombre de jours d'un mois
	private int[] nombreJoursMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	// jour du mois
	private int jour;
	// jour de la semaine
	private int jourSemaine;
	// mois
	private int mois;
	// année
	private int annee;
	
	/**
	 * Instanciation par défaut
	 */
	public Date () 
	{
		GregorianCalendar aujourdhui = new GregorianCalendar();
		this.jour = aujourdhui.get(Calendar.DAY_OF_MONTH);
		this.mois = aujourdhui.get(Calendar.MONTH);
		this.annee = aujourdhui.get(Calendar.YEAR);
		this.jourSemaine = aujourdhui.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Instanciation paramétrée
	 * @param unJour
	 * @param unMois
	 * @param uneAnnee
	 */
	public Date (int unJour, int unMois, int uneAnnee) 
	{
		this.jour = unJour;
		this.mois = unMois;
		this.annee = uneAnnee;
		this.jourSemaine = new GregorianCalendar(this.annee, this.mois, this.jour).get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Indique si l'année courante est bissextile
	 * @return boolean - si l'année courante est bissextile
	 */
	public boolean estBissextile() 
	{
		return (this.annee % 4 == 0 && (this.annee % 100 != 0 || this.annee % 400 == 0) );
	}
	
	/**
	 * Indique le nombre de jours du mois courant
	 * @return int - nombre de jours d'un mois donné
	 */
	public int retournerDernierJourDuMois(int unMois)
	{
		// On vérifie qu'il sagit d'une année bisextile si c'est le mois de Février
		if(unMois == 1 && this.estBissextile()) 
		{
			return 29;
		} 
		else 
		{
			return this.nombreJoursMois[unMois];
		}
	}
	
	/**
	 * Retourne un tableau de chiffres correspondant aux indices des jours de semaine du mois courant
	 * @return
	 */
	public int[] retournerJourSemaineMoisCourant() 
	{
		int indiceMax = this.retournerDernierJourDuMois(this.mois);
		int[] retour = new int[indiceMax];
		for(int indice = 1; indice <= indiceMax; indice++) 
		{
			retour[indice-1] = new GregorianCalendar(this.annee, this.mois, indice).get(Calendar.DAY_OF_WEEK);
		}
		return retour;
	}
	
	/**
	 * Retourne un tableau de chiffres correspondant aux indices des jours de semaine du mois donné
	 * @param unMois
	 * @return
	 */
	public int[] retournerJourSemaineMois(int unMois) 
	{
		int indiceMax = this.retournerDernierJourDuMois(unMois);
		int[] retour = new int[indiceMax];
		for(int indice = 1; indice <= indiceMax; indice++) 
		{
			retour[indice-1] = new GregorianCalendar(this.annee, unMois, indice).get(Calendar.DAY_OF_WEEK);
		}
		return retour;
	}
	
	/**
	 * Retourne l'indice du mois courant
	 * @return
	 */
	public String retournerMoisCourant() 
	{
		return this.convertionMois[this.mois];
	}
	
	/**
	 * Retourne l'indice du mois donné
	 * @param unMois
	 * @return
	 */
	public String retournerMois(int unMois) 
	{
		return this.convertionMois[unMois];
	}
	
	/**
	 * Retourne une chaîne de caractères correspondant à la date courante
	 * @return String
	 */
	public String retournerDate() 
	{
		return this.convertionJourSemaine[this.jourSemaine-1] + " " + this.jour + " " + this.convertionMois[this.mois] + " " + this.annee;
	}
	
	/**
	 * Retourne une chaîne de caractères correspondant a une date precise
	 * @param unJour
	 * @param unMois
	 * @return
	 */
	public String retournerDatePrecise(int unJour, int unMois) 
	{
		return this.convertionJourSemaine[new GregorianCalendar(this.annee, unMois, unJour).get(Calendar.DAY_OF_WEEK) - 1] + " " + unJour + " " + this.convertionMois[unMois] + " " + this.annee;
	}

	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * @param jour the jour to set
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * @return the jourSemaine
	 */
	public int getJourSemaine() {
		return jourSemaine;
	}

	/**
	 * @param jourSemaine the jourSemaine to set
	 */
	public void setJourSemaine(int jourSemaine) {
		this.jourSemaine = jourSemaine;
	}

	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * @param mois the mois to set
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}

	/**
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	/**
	 * @return String
	 */
	public String toString() 
	{
		return "Date [jour=" + this.jour + ", jourSemaine=" + this.convertionJourSemaine[this.jourSemaine] + ", mois=" + this.convertionMois[this.mois] + ", annee=" + this.annee + "]";
	}

}
