package app_contacts;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ressources.Ressources;

public class ContactListJpanel extends JPanel {

	public ContactListJpanel(){
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		
		setLayout(new BorderLayout());
		
		
	}
	
	public JPanel IndividualContactPanel(){
		
	}
	
}
