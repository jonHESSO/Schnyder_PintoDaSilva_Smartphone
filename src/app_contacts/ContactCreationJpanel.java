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
		Ressources.CONTACTLIST.add(new Contact(fieldFirstName.getText()));
		Ressources.CONTACTLIST.add(new Contact(fieldLastName.getText()));
		Ressources.CONTACTLIST.add(new Contact(fieldNumber.getText()));
		Ressources.CONTACTLIST.add(new Contact(fieldEmail.getText()));
		Ressources.CONTACTLIST.add(new Contact(fieldImagePath.getText()));

		Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_DIRECTORY);
	}
}