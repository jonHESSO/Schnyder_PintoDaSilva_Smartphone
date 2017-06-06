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
public class ContactModifyJPanel extends ContactCreationJpanel {

	private Contact currentContact;
	
	protected String contactPath = Ressources.CONTACT_DIRECTORY ;

	// Création et ajout du panel pour les buttons
	JPanel panel = new JPanel(new FlowLayout());

	// Ajout des buttons "OK" et "Cancel"
	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");


	public ContactModifyJPanel(Contact contact) {
		super();
		// ajout de listener
		setLayout(new BorderLayout());
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new Cancel_Click());

		// Ajout des buttons
		panel.add(okButton);
		panel.add(cancelButton);
		add(panel, BorderLayout.SOUTH);

		this.currentContact = contact;

		fieldFirstName.setText(contact.getFirstName());
		fieldLastName.setText(contact.getLastName());
		fieldNumber.setText(contact.getNumber());

		// Textfield --> attributs optionnels pour un contact
		fieldEmail.setText(contact.getEmail());
		fieldImagePath.setText(contact.getImagePath());
	}

	public void modifyContact() {
		this.currentContact.setFirstName(fieldFirstName.getText());
		this.currentContact.setLastName(fieldLastName.getText());
		this.currentContact.setNumber(fieldNumber.getText());

		this.currentContact.setEmail(fieldEmail.getText());
		this.currentContact.setImagePath(fieldImagePath.getText());

	}

	// Listener du button de creation de contact
	class Ok_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Ajout des listener sur chaque texfield pour l'ajout à la
			// ContactList
			modifyContact();
			try {
				Serializer.serializableObject(cl, contactPath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ContactModifyJPanel.this.setVisible(false);
		}
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
}
