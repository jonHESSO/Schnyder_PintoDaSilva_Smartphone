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

import app_contacts.ContactCreationFrame.Cancel_Click;
import app_contacts.ContactCreationFrame.Ok_Click;
import ressources.Ressources;
import ressources.Serializer;

//Permet de modifier un contact déjà existant
public class ContactModifyJPanel extends ContactEditPanel {

	private Contact currentContact;


	public ContactModifyJPanel(Contact contact) {
		super();
	
		this.currentContact = contact;

		fieldFirstName.setText(contact.getFirstName());
		fieldLastName.setText(contact.getLastName());
		fieldNumber.setText(contact.getNumber());

		// Textfield --> attributs optionnels pour un contact
		fieldEmail.setText(contact.getEmail());
		fieldImagePath.setText(contact.getImagePath());
	}




	// Listener du button de confirmation de quitter la ContactCreation
	class Cancel_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int reponse = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter l'application", "Confirmation",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (reponse == JOptionPane.YES_OPTION) {
				ContactModifyJPanel.this.setVisible(false);
			}

		}

	}

	@Override
	public void okAction() {
		this.currentContact.modify() ;
		Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_DIRECTORY);
	}
}
