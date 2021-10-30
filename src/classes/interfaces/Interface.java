/**
 * 
 */
package classes.interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author GerlariMin
 * Classe g�n�rant la fen�tre int�grant les diff�rents JPanel n�cessaires.
 *
 */
public class Interface 
{
	// Attribut qui servira � g�n�rer la fen�tre � afficher
	private JFrame fenetre = new JFrame();
	// Attribut qui va r�cup�rer automatiquement les dimensions de l'�cran
	private Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * Initialisation de la fen�tre � afficher
	 * @param titre
	 */
	public Interface(String titre) 
	{
		// D�finition du titre
		this.fenetre.setTitle(titre);
		// D�finition des dimensions (hauteur, largeur) de la fen�tre
		this.fenetre.setSize((int) (this.dimensions.getHeight()/2), (int) (this.fenetre.getWidth()));
		// D�finition de la position de la fen�tre (centr�e)
		this.fenetre.setLocation((int) (this.dimensions.getHeight()/2), (int) (this.fenetre.getWidth()/2));
		// On permet � la fen�tre de pouvoir changer de taille
		this.fenetre.setResizable(true);
		// On r�cup�re le chemin du projet
		String cheminProjet = System.getProperty("user.dir");
		// On charge l'ic�ne du projet
		ImageIcon image = new ImageIcon(cheminProjet + "/src/ressources/images/agenda.png");
		// On affiche l'ic�ne sur la fen�tre
		this.fenetre.setIconImage(image.getImage());
	}
	
	/**
	 * Affichage de la fen�tre apr�s avoir charg� tous les �l�ments voulus dedans
	 */
	public void afficherInterface() 
	{
		this.fenetre.setVisible(true);
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Ajout du JPanel PanelEvenement
	 * @param panel
	 */
	public void ajouterPanelEvenement(PanelEvenement panel) 
	{	
		// On ajoute le JPanel panel � la position voulue
		this.fenetre.add(panel, BorderLayout.WEST);
		// On adapte la taille d'affichage au contenu du JPanel
		this.fenetre.pack();
	}
	
	/**
	 * Ajout du JPanel PanelCalendrier
	 * @param panel
	 */
	public void ajouterPanelCalendrier(PanelCalendrier panel) 
	{	
		// On ajoute le JPanel panel � la position voulue
		this.fenetre.add(panel, BorderLayout.NORTH);
		// On adapte la taille d'affichage au contenu du JPanel
		this.fenetre.pack();
	}
	
	/**
	 * Ajout du JPanel PanelCalendrier
	 * @param panel
	 */
	public void ajouterPanelAgenda(PanelAgenda panel) 
	{	
		// On ajoute le JPanel panel � la position voulue
		this.fenetre.add(panel, BorderLayout.EAST);
		// On adapte la taille d'affichage au contenu du JPanel
		this.fenetre.pack();
	}

	@Override
	public String toString() 
	{
		return "Interface [fenetre=" + this.fenetre + ", dimensions=" + this.dimensions + "]";
	}
	
	

}
