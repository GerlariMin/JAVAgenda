package main;

import classes.interfaces.Interface;
import classes.interfaces.PanelAgenda;
import classes.interfaces.PanelCalendrier;
import classes.interfaces.PanelEvenement;

/**
 * 
 * @author GerlariMin
 * Classe d'ex�cution du projet.
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
		
		// Instanciation de la fen�tre JFrame
		Interface i = new Interface("JAVAgenda");
		// G�n�ration des diff�rents panels qui composeront la JFrame
		PanelAgenda panelAgenda = new PanelAgenda();
		PanelEvenement panelEvenement = new PanelEvenement(panelAgenda);
		PanelCalendrier panelCalendrier = new PanelCalendrier(panelEvenement, panelAgenda);
		// Ajout des panels � la fen�tre
		i.ajouterPanelEvenement(panelEvenement);
		i.ajouterPanelCalendrier(panelCalendrier);
		i.ajouterPanelAgenda(panelAgenda);
		// Affichage de la fen�tre
		i.afficherInterface();		
	}

}
