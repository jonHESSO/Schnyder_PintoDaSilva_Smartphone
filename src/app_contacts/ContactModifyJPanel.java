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

//Permet de modifier un contact déjà existant
public class ContactModifyJPanel extends ContactEditPanel {

	private Contact currentContact;

	// Constructeur du panel
	public ContactModifyJPanel(Contact contact) {
		super();

		this.currentContact = contact;

		// Ajout des informations du contact dans les textfield
		fieldFirstName.setText(contact.getFirstName());
		fieldLastName.setText(contact.getLastName());
		fieldNumber.setText(contact.getNumber());
		fieldEmail.setText(contact.getEmail());
		fieldImagePath.setText(contact.getImagePath());
	}

	// Listener du cancelButton
	@Override
	public void okAction() {
		//Sauvegarde des modif.
		this.currentContact.modify();
		Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_DIRECTORY);
	}

	// Listener du button Cancel
	@Override
	public void cancelAction() {
		int reponse = JOptionPane.showConfirmDialog(null, "Realy want to quit bro?", "Confirmation",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (reponse == JOptionPane.YES_OPTION) {
			ContactModifyJPanel.this.setVisible(false);
		}
		
	}
}
