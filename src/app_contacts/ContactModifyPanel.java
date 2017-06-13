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

//Permet de modifier un contact d�j� existant

//La classe h�rite de ContactEditPanel
public class ContactModifyPanel extends ContactEditPanel {

	// Contact modifi� en ce moment
	private Contact currentContact;
	// Indique si le contact a �t� modifi�
	private boolean contactModified = false ;

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
		ImageIcon picture = (ImageIcon)imageButton.getIcon() ;
		if (firstName.equals(""))
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Indiquez au moins un prenom");
		}
		else
		{
			// Appelle la m�thode modifyContact via la CONTACTLIST
			Ressources.CONTACTLIST.modifyContact(currentContact, lastName, firstName, number, email, picture);
			// La m�thode s�rialization prend en param�tre la CONTACTLIST et le fichier de s�rialization
			Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_SERIALISATION);
			boolean oldProperty = false ;
			//indique que le contact a �t� modifi�
			contactModified = true ;
			//indique une modification des propri�t�s du contact
			firePropertyChange("contactModified", oldProperty, contactModified);
		}
	}
}

