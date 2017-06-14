/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : June 07, 2017
 */

package app_contacts;

//Imports
import java.awt.event.*;

//imports layouts
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

//imports J***
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.pept.protocol.ServerRequestDispatcher;

import ressources.AppManager;
import ressources.Ressources;
import ressources.Serializer;

/**
 * The Class ContactCreationPanel.
 * The same as editpanel. The OK Button adds the new
 * contact to the contac list and then removes this panel
 */
public class ContactCreationPanel extends ContactEditPanel {

	/**
	 * Instantiates a new contact creation panel.
	 */
	// Panel accueillant le panel avec les JTexfields et celui avec les JButtons
	public ContactCreationPanel() {
		super();
	}

	/**
	 * Ok action.
	 */
	// Enregistrement du contact en cliquant sur le okButton
	@Override
	public void okAction() {
		String lastName = fieldLastName.getText() ; 
		String firstName = fieldFirstName.getText() ;
		String number = fieldNumber.getText() ;
		String email = fieldEmail.getText() ;
		ImageIcon picture = null ;

		//Mise en place d'une image par défaut
		// Si il n'y a pas d'image
		if (imageButton.getIcon() == null)
		{
			//utilise cette image
			picture = new ImageIcon(Ressources.DATAPATH+"data/Icons/contact_icons/doge.jpg") ;
		}
		else{
			//sinon utilise l'image sélectionnée
			picture = (ImageIcon)imageButton.getIcon() ;
		}

//		Pattern phoneNumberPattern = Pattern.compile("\\d{3,13}");
//		if (number)
		if (firstName.equals(""))
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Indiquez au moins un prenom");
		}
		else
		{
			//Ajoute le contact à la CONTACTLIST
			Ressources.CONTACTLIST.addContact(lastName, firstName, number, email, picture);
			//Appelle la méthode de sérialization avec pour paramètres la CONTACTLIST et le fichier de sérialization
			Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_SERIALISATION);

			//Ferme le panel une fois le contact créé
			AppManager.removeActivePanel(); ;

			//indique une modification des propriétés du contact
			firePropertyChange("contactCreated", false, true);
		}


	}
}