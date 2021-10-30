package classes.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import classes.Date;
import classes.Evenement;

/**
 * 
 * @author GerlariMin
 * Classe permettant la construction du JPanel PanelEvenement.
 *
 */
public class PanelEvenement extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;

	private Date date;
	
	public final static String [] ANNEES = {"2019", "2020", "2021"};
	
	public final static String [] MOIS = {"Janvier", "F�vrier", "Mars", "Avril", "Mai", "Juin",
			"Juillet", "Ao�t", "Septembre", "Octobre", "Novembre", "D�cembre"};
	public final static String [] HEURES = {"00", "01", "02", "03", "04", "05", "06",
		"07", "08", "09", "10", "11", "12", "13",
		"14", "15", "16", "17", "18", "19", "20",
		"21", "22", "23", "24"};
	public final static String [] MINUTES = {"00", "05", "10", "15", "20", "25", "30",
		"35", "40", "45", "50", "55"};

	private JLabel labelDate;
	
	private JButton boutonAjout = new JButton("+");
	
	private JTextField champTitre = new JTextField(4);
	private JTextField champLieu = new JTextField(4);
	
	private JComboBox <String> champDebutHeure = new JComboBox <String> (HEURES);
	private JComboBox <String> champFinHeure = new JComboBox <String> (HEURES);
	private JComboBox <String> champDebutMinute = new JComboBox <String> (MINUTES);
	private JComboBox <String> champFinMinute = new JComboBox <String> (MINUTES);
	
	private JTextArea champDescription;
	
	private PanelAgenda panelAgenda;
		
	/**
	 * Instanciation du PanelEvenement
	 * @param pa
	 */
	public PanelEvenement (PanelAgenda pa)
	{
		this.date = new Date();
		this.panelAgenda = pa;
		
		this.labelDate = new JLabel (this.date.retournerDate(), JLabel.LEFT);
		this.add(this.labelDate);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(4,6,4,6);
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		
		this.labelDate.setFont(new Font ("Verdana", Font.BOLD, 14));
		
		this.boutonAjout.addActionListener(this);
		this.boutonAjout.setFont(new Font ("Verdana", Font.BOLD, 11));
		this.boutonAjout.setBackground(new Color (155,60,98));
		this.boutonAjout.setForeground(new Color (253,241,184));
		this.boutonAjout.setFocusPainted(false);
		
		JLabel labelTitre = new JLabel("Titre", JLabel.LEFT);
		this.champTitre.setOpaque(false);
		
		JLabel labelLieu = new JLabel("Lieu", JLabel.LEFT);
		this.champLieu.setOpaque(false);
		
		JLabel labelDebut = new JLabel("Début", JLabel.LEFT);
		JLabel deuxPointsDebut = new JLabel(":");
		
		JLabel labelFin = new JLabel("Fin", JLabel.LEFT);
		JLabel deuxPointsFin = new JLabel(":");
		
		JLabel labelDescription = new JLabel("Description", JLabel.LEFT);
		this.champDescription = new JTextArea(5, 8);
		
		contraintes.gridy = 0;
		contraintes.gridwidth = 3;
		contraintes.gridx = 0;
		this.add(labelDescription, contraintes);
		
		contraintes.gridy = 0;
		contraintes.gridwidth = 3;
		contraintes.gridx = 3;
		this.add(this.boutonAjout, contraintes);
		
		contraintes.gridy++;
		contraintes.gridwidth = 1;
		contraintes.gridx = 0;
		this.add(labelTitre, contraintes);
		contraintes.gridx++;
		contraintes.gridwidth = 3;
		this.add(this.champTitre, contraintes);
		
		contraintes.gridy++;
		contraintes.gridwidth = 1;
		contraintes.gridx = 0;
		this.add(labelLieu, contraintes);
		contraintes.gridx++;
		contraintes.gridwidth = 3;
		this.add(this.champLieu, contraintes);
		
		contraintes.gridy++; 
		contraintes.gridx = 0;
		contraintes.gridwidth = 1;
		this.add(labelDebut, contraintes);
		contraintes.gridx++;
		this.add(this.champDebutHeure, contraintes);
		contraintes.gridx++;
		this.add(deuxPointsDebut, contraintes);
		contraintes.gridx++;
		this.add(this.champDebutMinute, contraintes);
		
		contraintes.gridy++; 
		contraintes.gridx = 0;
		contraintes.gridwidth = 1;
		this.add(labelFin, contraintes);
		contraintes.gridx++;
		this.add(this.champFinHeure, contraintes);
		contraintes.gridx++;
		this.add(deuxPointsFin, contraintes);
		contraintes.gridx++;
		this.add(this.champFinMinute, contraintes);
		
		contraintes.gridy++;
		contraintes.gridx = 0;
		contraintes.anchor = GridBagConstraints.NORTHWEST;
		this.add(labelDescription, contraintes);
		contraintes.gridy++; 
		contraintes.gridx = 0;
		contraintes.gridwidth = 4;
		contraintes.fill = GridBagConstraints.BOTH;
		this.add(new JScrollPane(this.champDescription), contraintes);
		
		contraintes.insets = new Insets(10,  30, 10, 0);
		contraintes.gridx = 4; 
		contraintes.gridy = 0;
		contraintes.gridheight = 7;
	}
	
	/**
	 * Actualisation du JLabel de la date
	 * @param unTitre
	 * @param uneDate
	 */
	public void actualiserLabelDate(String unTitre, Date uneDate) 
	{
		this.labelDate.setText(unTitre);
		this.date = uneDate;
	}
	
	@Override
	/**
	 * Gestion des événements du JPanel
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub

		// On créé un objet Evenement à partir des informations renseignées par lu'itlisateur
		Evenement evenement = new Evenement(this.date,  this.champTitre.getText(), this.champLieu.getText(), Integer.parseInt(this.champDebutHeure.getSelectedItem().toString()), Integer.parseInt(this.champDebutMinute.getSelectedItem().toString()), Integer.parseInt(this.champFinHeure.getSelectedItem().toString()), Integer.parseInt(this.champFinMinute.getSelectedItem().toString()), this.champDescription.getText());
		// On ajoute l'événement au JPanel PanelAgenda pour l'afficher
		this.panelAgenda.ajouterEvenement(evenement);
	}

}
