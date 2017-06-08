package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ressources.Ressources;
import ressources.Serializer;

<<<<<<< HEAD:src/app_contacts/ContactModifyPanel.java
//Permet de modifier un contact d�j� existant
public class ContactModifyPanel extends ContactEditPanel {
=======
//Permet de modifier un contact déjà existant
public class ContactModifyJPanel extends ContactEditPanel {
>>>>>>> 4f93b0c01cc1c2aa7c81efebd2bfb017b3c615e3:src/app_contacts/ContactModifyJPanel.java

	private Contact currentContact;

	// Constructeur du panel
	public ContactModifyPanel(Contact contact) {
		super();

		this.currentContact = contact;

		// Ajout des informations du contact dans les textfield
		fieldFirstName.setText(contact.getFirstName());
		fieldLastName.setText(contact.getLastName());
		fieldNumber.setText(contact.getNumber());
		fieldEmail.setText(contact.getEmail());
		imageButton.setIcon(contact.getPicture());
	}

	// Listener du cancelButton
	@Override
	public void okAction() {
		//Sauvegarde des modif.
		String lastName = fieldLastName.getText() ;
		String firstName = fieldFirstName.getText() ;
		String number = fieldNumber.getText() ;
		String email = fieldEmail.getText() ;
		Ressources.CONTACTLIST.modifyContact(currentContact, lastName, firstName, number, email, null);
		Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_DIRECTORY);
	}

