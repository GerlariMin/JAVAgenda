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
 * Classe générant la fenêtre intégrant les différents JPanel nécessaires.
 *
 */
public class Interface 
{
	// Attribut qui servira à générer la fenêtre à afficher
	private JFrame fenetre = new JFrame();
	// Attribut qui va récupérer automatiquement les dimensions de l'écran
	private Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * Initialisation de la fenêtre à afficher
	 * @param titre
	 */
	public Interface(String titre) 
	{
		// Définition du titre
		this.fenetre.setTitle(titre);
		// Définition des dimensions (hauteur, largeur) de la fenêtre
		this.fenetre.setSize((int) (this.dimensions.getHeight()/2), (int) (this.fenetre.getWidth()));
		// Définition de la position de la fenêtre (centrée)
		this.fenetre.setLocation((int) (this.dimensions.getHeight()/2), (int) (this.fenetre.getWidth()/2));
		// On permet à la fenêtre de pouvoir changer de taille
		this.fenetre.setResizable(true);
		// On récupère le chemin du projet
		String cheminProjet = System.getProperty("user.dir");
		// On charge l'icône du projet
		ImageIcon image = new ImageIcon(cheminProjet + "/src/ressources/images/agenda.png");
		// On affiche l'icône sur la fenêtre
		this.fenetre.setIconImage(image.getImage());
	}
	
	/**
	 * Affichage de la fenêtre après avoir chargé tous les éléments voulus dedans
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
		// On ajoute le JPanel panel à la position voulue
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
		// On ajoute le JPanel panel à la position voulue
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
		// On ajoute le JPanel panel à la position voulue
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
