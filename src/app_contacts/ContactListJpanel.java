package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

import ressources.Ressources;

public class ContactListJpanel extends JPanel {

	public ContactListJpanel(){
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		
		setLayout(new BorderLayout());
	
	}
	
	public JPanel IndividualContactPanel(Contact currentContact){
		
		//Panel contenant les infos du contact(sPanel) et l'image 
		JPanel panel = new JPanel(new FlowLayout());
		//Panel contenant les infos du contact, qui est contenu dans le Panel
		JPanel sPanel = new JPanel(new FlowLayout());
		
		panel.add(sPanel);
		sPanel.add(new JLabel(currentContact.getFirstName()));
		sPanel.add(new JLabel(currentContact.getLastName()));
		sPanel.add(new JLabel(currentContact.getNumber()));
		sPanel.add(new JLabel(currentContact.getEmail()));
		
		return panel;
	}
}
