package classes.interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import classes.Date;
import classes.Evenement;

/**
 * 
 * @author GerlariMin
 * Classe permettant la construction du JPanel PanelAgenda.
 *
 */
public class PanelAgenda extends JPanel implements ActionListener 
{
	
	private static final long serialVersionUID = 1L;
	private String[] entete;
	private Object[][] data;
	
	private JTable tableau;
	
	private ArrayList<Evenement> evenements = new ArrayList<Evenement>();
	
	private int moisAffiche;
	
	/**
	 * Instanciation du PanelAgenda
	 */
	public PanelAgenda() 
	{
		this.actualiserTableau(new Date().getMois());
	}
	
	/**
	 * Actualisation du JPanel une fois que la JTablee est prête
	 */
	public void actualiserPanel()
	{
		this.tableau = new JTable(this.data, this.entete);
        
        //create table with data
        this.tableau.getTableHeader().setBackground(Color.CYAN);
        this.tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tableau.setRowHeight(50);
        
        //add the table to the frame
        this.add(new JScrollPane(this.tableau));
	}
	
	/**
	 * Actualisation du panel en fonction du mois à afficher
	 * @param unMois
	 */
	public void actualiserTableau(int unMois)
	{
		this.removeAll();
		this.moisAffiche = unMois;
		Date date = new Date();
		int indiceMax = date.retournerDernierJourDuMois(unMois);
		
		this.entete = new String[indiceMax];
		this.data = new Object[10][indiceMax];
		
		//headers for the table
		for(int indice = 0; indice < indiceMax; indice++)
		{
			this.entete[indice] = "" + (indice+1);
			
			for(int indiceSecondaire = 0; indiceSecondaire < 10; indiceSecondaire++) 
			{
				this.data[indiceSecondaire][indice] = " - ";
			}
		}
                
        this.afficherEvenements();
        this.actualiserPanel();
	}
	
	/**
	 * Gestion du contenu du JTable pour afficher les titres des événements créés
	 */
	public void afficherEvenements()
	{
		for(Evenement e: this.evenements)
		{
			if(e.getDate().getMois() == this.moisAffiche)
			{
				this.data[e.getHeureDebut()][e.getDate().getJour()-1] = e.getTitre();
			}
		}
	}
	
	/**
	 * Ajout d'un événement
	 * @param unEvenement
	 */
	public void ajouterEvenement(Evenement unEvenement)
	{
		this.evenements.add(unEvenement);
		this.afficherEvenements();
	}

	@Override
	/**
	 * Gestion des événements sur le JPanel
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("ActionEvent e: " + e.getSource());
	}	

}
