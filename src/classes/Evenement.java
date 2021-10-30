package classes;

/**
 * 
 * @author GerlariMin
 * Classe correspondant aux événements agenda que va créer l'utilisateur.
 *
 */
public class Evenement 
{
	// Titre d'un événement
	private String titre;
	// Lieu d'un événement
	private String lieu;
	// Début de l'événement
	private int heureDebut;
	private int minuteDebut;
	// Fin de l'événement
	private int heureFin;
	private int minuteFin;
	// Description de l'événement
	private String description;
	// Date de l'événement
	private Date date;
	
	/**
	 * Instanciation d'un événement
	 * @param uneDate
	 * @param unTitre
	 * @param unLieu
	 * @param uneHeureDebut
	 * @param uneMinuteDebut
	 * @param uneHeureFin
	 * @param uneMinuteFin
	 * @param uneDescription
	 */
	public Evenement(Date uneDate, String unTitre, String unLieu, int uneHeureDebut, int uneMinuteDebut, int uneHeureFin, int uneMinuteFin, String uneDescription)
	{
		this.date = uneDate;
		this.titre = unTitre;
		this.lieu = unLieu;
		this.heureDebut = uneHeureDebut;
		this.minuteDebut = uneMinuteDebut;
		this.heureFin = uneHeureFin;
		this.minuteFin = uneMinuteFin;
		this.description = uneDescription;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the lieu
	 */
	public String getLieu() {
		return lieu;
	}

	/**
	 * @param lieu the lieu to set
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the heureDebut
	 */
	public int getHeureDebut() {
		return heureDebut;
	}

	/**
	 * @param heureDebut the heureDebut to set
	 */
	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	/**
	 * @return the minuteDebut
	 */
	public int getMinuteDebut() {
		return minuteDebut;
	}

	/**
	 * @param minuteDebut the minuteDebut to set
	 */
	public void setMinuteDebut(int minuteDebut) {
		this.minuteDebut = minuteDebut;
	}

	/**
	 * @return the heureFin
	 */
	public int getHeureFin() {
		return heureFin;
	}

	/**
	 * @param heureFin the heureFin to set
	 */
	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	/**
	 * @return the minuteFin
	 */
	public int getMinuteFin() {
		return minuteFin;
	}

	/**
	 * @param minuteFin the minuteFin to set
	 */
	public void setMinuteFin(int minuteFin) {
		this.minuteFin = minuteFin;
	}

	@Override
	public String toString() {
		return "Evenement [titre=" + titre + ", lieu=" + lieu + ", heureDebut=" + heureDebut + ", minuteDebut="
				+ minuteDebut + ", heureFin=" + heureFin + ", minuteFin=" + minuteFin + ", description=" + description
				+ ", date=" + date + "]";
	}

}
