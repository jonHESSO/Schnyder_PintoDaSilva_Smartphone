package app_contacts;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Permet de modifier un contact déjà existant
public class ContactModifyJPanel extends ContactCreationJpanel {
	
	
	public ContactModifyJPanel(Contact contact) {
		super ();
		
		fieldFirstName.setText(contact.getFirstName()); 
		fieldLastName.setText(contact.getLastName()); 
		fieldNumber.setText(contact.getNumber()); 

		// Textfield --> attributs optionnels pour un contact
		fieldEmail.setText(contact.getEmail()); 
		fieldImagePath.setText(contact.getImagePath()); 
		
	}
}
