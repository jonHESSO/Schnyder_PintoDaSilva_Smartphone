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

//imports J***
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.pept.protocol.ServerRequestDispatcher;

import ressources.Ressources;
import ressources.Serializer;

public class ContactCreationJpanel extends ContactEditPanel {

	// Panel accueillant le panel avec les JTexfields et celui avec les JButtons
	public ContactCreationJpanel() {
		super();
	}

	// Enregistrement du contact en cliquant sur le okButton
	@Override
	public void okAction() {
		String lastName = fieldLastName.getText() ;
		String firstName = fieldFirstName.getText() ;
		String number = fieldNumber.getText() ;
		String email = fieldEmail.getText() ;
		ImageIcon picture = (ImageIcon)imageButton.getIcon() ;
		
		Ressources.CONTACTLIST.addContact(lastName, firstName, number, email, picture);
		Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_DIRECTORY);
	}
}