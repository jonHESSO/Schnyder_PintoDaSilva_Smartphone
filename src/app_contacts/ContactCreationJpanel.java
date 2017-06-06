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

public class ContactCreationJpanel extends JPanel {

	// Textfield --> attributs obligatoires pour un contact
	protected JTextField fieldFirstName = new JTextField(15);
	protected JTextField fieldLastName = new JTextField(15);
	protected JTextField fieldNumber = new JTextField(15);

	// Textfield --> attributs optionnels pour un contact
	protected JTextField fieldEmail = new JTextField(15);
	protected JTextField fieldImagePath = new JTextField(15);

	// Création de la liste de contacts
	protected ContactList cl = new ContactList();

	// Panel accueillant le panel avec les JTexfields et celui avec les JButtons
	public ContactCreationJpanel() {

		// Ajout des dimensions
		this.setPreferredSize(Ressources.CONTACT_APP_CREATIONPANEL);
		setLayout(new BorderLayout());

		// Ajout des panels de labels, de textfields et de buttons au panel
		// principal
		add(fieldsLabelsPanel(), BorderLayout.WEST);
		add(contactFieldsPanel(), BorderLayout.EAST);
	}

	// Panel accueillant les labels des textFields
	public JPanel fieldsLabelsPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(50, 500));
		panel.add(new JLabel("Prénom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Nom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Numéro")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("E-Mail")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Image")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);

		return panel;
	}

	// Panel contenant les textfield
	public JPanel contactFieldsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(200, 500));

		// attributs obligatoires pour un contact
		panel.add(fieldFirstName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldLastName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldNumber).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);

		// attributs optionnels pour un contact
		panel.add(fieldEmail).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldImagePath).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);

		return panel;
	}

	public void createNewContact() {
		String nom = fieldLastName.getText();
		String prenom = fieldFirstName.getText();
		String numero = fieldNumber.getText();

		// Ajout du contact à la ContactList (cl)
		cl.addContact(nom, prenom, numero);
	}

}