package main;

import classes.interfaces.Interface;
import classes.interfaces.PanelAgenda;
import classes.interfaces.PanelCalendrier;
import classes.interfaces.PanelEvenement;

/**
 * 
 * @author GerlariMin
 * Classe d'exécution du projet.
 *
 */
public class Main 
{
	
	/**
	 * @param args
	 * @source https://waytolearnx.com/2020/05/jframe-java-swing.html
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// Instanciation de la fenêtre JFrame
		Interface i = new Interface("JAVAgenda");
		// Génération des différents panels qui composeront la JFrame
		PanelAgenda panelAgenda = new PanelAgenda();
		PanelEvenement panelEvenement = new PanelEvenement(panelAgenda);
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement, panelAgenda);
		// Ajout des panels à la fenêtre
		i.ajouterPanelEvenement(panelEvenement);
		i.ajouterPanelCalendrier(panelCalendrier);
		i.ajouterPanelAgenda(panelAgenda);
		// Affichage de la fenêtre
		i.afficherInterface();		
	}

}
