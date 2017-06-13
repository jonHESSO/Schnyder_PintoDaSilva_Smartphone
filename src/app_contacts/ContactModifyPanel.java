/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : May 22, 2017
 */
package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ressources.Ressources;
import ressources.Serializer;


//Permet de modifier un contact déjà existant

/**
 * The Class ContactModifyPanel.
 * This class extends the ContactEditPanel.
 * The okaction modifies the seleced contact, and
 * tells the individual panel which then tells the list
 * panel that the contact has been modified.
 */
public class ContactModifyPanel extends ContactEditPanel {

	/** The current contact. */
	// Contact modifié en ce moment
	private Contact currentContact;

	/**
	 * Instantiates a new contact modify panel.
	 *
	 * @param contact the contact
	 */
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

	/**
	 * Ok action. Modifies the contact, and
	 * tells the indicidual panel that the contact
	 * has been modified.
	 */
	@Override
	public void okAction() {
		//Sauvegarde des modif.
		String lastName = fieldLastName.getText() ;
		String firstName = fieldFirstName.getText() ;
		String number = fieldNumber.getText() ;
		String email = fieldEmail.getText() ;
		ImageIcon picture = (ImageIcon)imageButton.getIcon() ;
		if (firstName.equals(""))
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Indiquez au moins un prenom");
		}
		else
		{
			// Appelle la méthode modifyContact via la CONTACTLIST
			Ressources.CONTACTLIST.modifyContact(currentContact, lastName, firstName, number, email, picture);
			// La méthode sérialization prend en paramètre la CONTACTLIST et le fichier de sérialization
			Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_SERIALISATION);
			//indique une modification des propriétés du contact
			firePropertyChange("contactModified", false, true);
		}
	}
}

