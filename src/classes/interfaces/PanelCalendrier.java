package classes.interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Date;

/**
 * 
 * @author GerlariMin
 * Classe permettant la construction du JPanel PanelCalendrier.
 *
 */
public class PanelCalendrier extends JPanel implements ActionListener 
{

	private static final long serialVersionUID = 1L;

	private Date date = new Date();
	
	private JPanel panelCentre = new JPanel(); // Calendrier du mois
	private JPanel panelSud = new JPanel(); // Boutons
	private CardLayout gestionnaireCard = new CardLayout();
	private int indiceGestionnaireCar;

	private JButton boutonPrecedent = new JButton("<");
	private JLabel labelMois;
	private JButton boutonSuivant = new JButton(">");
			
	private int[] joursSemaineDuMois;
	
	private JButton[] boutonsdates;
	
	private JButton boutonSource = new JButton();
	private Color couleurDefaut = this.boutonSource.getBackground();

	private PanelEvenement panelEvenement;
	private PanelAgenda panelAgenda;
	
	/**
	 * Instanciation du PanelCalendrier
	 * @param pe
	 * @param pa
	 */
	public PanelCalendrier(PanelEvenement pe, PanelAgenda pa) 
	{
		this.panelEvenement = pe;
		this.panelAgenda = pa;
		this.setLayout(new BorderLayout(9,9));
		
		this.panelCentre.setLayout(this.gestionnaireCard);
		JPanel[] panelMois = new JPanel[12];
		
		for(int indiceMois = 0; indiceMois < 12; indiceMois++)
		{
			panelMois[indiceMois] = new JPanel();
			panelMois[indiceMois].setLayout(new GridLayout(0, 7));
			
			this.joursSemaineDuMois = this.date.retournerJourSemaineMois(indiceMois);
			this.boutonsdates = new JButton[this.joursSemaineDuMois.length];
			
			for(int i = 0; i < this.joursSemaineDuMois.length; i++) 
			{
				this.boutonsdates[i] = new JButton(""+(i+1));
				
				if(this.joursSemaineDuMois[i] == 1 || this.joursSemaineDuMois[i] == 7) 
				{
					this.boutonsdates[i].setBackground(Color.YELLOW);
				} 
				if(i+1 == this.date.getJour() && indiceMois == this.date.getMois()) 
				{
					this.boutonsdates[i].setBackground(Color.GREEN);
				}
				
				this.boutonsdates[i].addActionListener(this);
				panelMois[indiceMois].add(this.boutonsdates[i]);
				this.panelCentre.add(panelMois[indiceMois], date.retournerMois(indiceMois));
			}
		}
		
		this.gestionnaireCard.show(this.panelCentre, date.retournerMois(date.getMois()));
		this.indiceGestionnaireCar = date.getMois();
		
		this.panelSud.setLayout(new FlowLayout());
		
		this.boutonPrecedent.addActionListener(this);
		this.panelSud.add(this.boutonPrecedent);
		
		this.labelMois = new JLabel(this.date.retournerMoisCourant() + " " + this.date.getAnnee());
		this.panelSud.add(this.labelMois);
		
		this.boutonSuivant.addActionListener(this);
		this.panelSud.add(this.boutonSuivant);
		
		this.add(this.panelCentre, BorderLayout.NORTH);
		this.add(this.panelSud, BorderLayout.SOUTH);
	}
	

	@Override
	/**
	 * Gestion des �v�nements du PanelCalendrier
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		// On d�finit la couleur du bouton courant
		this.boutonSource.setBackground(this.couleurDefaut);
		// Le bouton courant devient l'�l�ment sur lequel a cliqu� l'utilisateur
		this.boutonSource = (JButton) e.getSource();
		// On r�cup�re la couleur du bouton courant
		this.couleurDefaut = this.boutonSource.getBackground();

		// Si l'�l�ment sur lequel l'utilisateur clique est le bouton pr�c�dent
		if(e.getSource() == this.boutonPrecedent) 
		{
			// On affiche le mois pr�c�dent
			this.gestionnaireCard.previous(this.panelCentre);
			// Si le mois pr�c�dent n'existe pas
			if(this.indiceGestionnaireCar == 0) 
			{
				// On repart du dernier mois de l'ann�e
				this.indiceGestionnaireCar = 11;
			}
			// Sinon
			else 
			{
				// On indique qu'on va au moins pr�c�dent
				this.indiceGestionnaireCar--;
			}
			
			// On change la valeur du label du mois
			this.labelMois.setText(this.date.retournerMois(this.indiceGestionnaireCar) + " " + this.date.getAnnee());
			// On actualise le PanelAgenda
			this.panelAgenda.actualiserTableau(this.indiceGestionnaireCar);
		} 
		// Sinon si l'�l�ment sur lequel l'utilisateur clique est le bouton suivant
		else if(e.getSource() == this.boutonSuivant) 
		{
			// On affiche le mois suivant
			this.gestionnaireCard.next(this.panelCentre);
			
			// Si le mois pr�c�dent n'existe pas
			if(this.indiceGestionnaireCar == 11) 
			{
				// On repart du premier mois de l'ann�e
				this.indiceGestionnaireCar = 0;
			}
			// Sinon
			else 
			{
				// On indique qu'on va au moins suivant
				this.indiceGestionnaireCar++;
			}
			// On change la valeur du label du mois
			this.labelMois.setText(this.date.retournerMois(this.indiceGestionnaireCar) + " " + this.date.getAnnee());
			// On actualise le PanelAgenda
			this.panelAgenda.actualiserTableau(this.indiceGestionnaireCar);
		} 
		// Sinon
		else 
		{
			// On actualise le label d'afficge de la date s�lectionn�e
			this.panelEvenement.actualiserLabelDate(this.date.retournerDatePrecise(Integer.parseInt(this.boutonSource.getText()), this.indiceGestionnaireCar), new Date(Integer.parseInt(this.boutonSource.getText()),indiceGestionnaireCar, this.date.getAnnee()));
			// On actualise la couleur du bouton correspondant � la date s�lectionn�e
			this.boutonSource.setBackground(Color.GRAY);
		}
		
	}

}
