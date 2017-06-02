package app_contacts;

//Imports
import java.awt.event.*;

//imports layouts
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//imports J***
import javax.swing.*;

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
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new BorderLayout());

		// Ajout des panels de labels, de textfields et de buttons au panel
		// principal
		add(fieldsLabelsPanel(), BorderLayout.WEST);
		add(contactFieldsPanel(), BorderLayout.EAST);
		add(buttonsPanel(), BorderLayout.SOUTH);
	}

	// Panel accueillant les labels des textFields
	public JPanel fieldsLabelsPanel() {
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

	// Panel accueillant les buttons "Ok" et "Cancel"
	public JPanel buttonsPanel() {

		// Création et ajout du panel pour les buttons
		JPanel panel = new JPanel(new FlowLayout());

		// Ajout des buttons "OK" et "Cancel"
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");

		// ajout de listener
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new Cancel_Click());

		// Ajout des buttons
		panel.add(okButton);
		panel.add(cancelButton);

		return panel;
	}

	// Listener du button de creation de contact
	class Ok_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// Ajout des listener sur chaque texfield pour l'ajout à la
			// ContactList
			String nom = fieldLastName.getText();
			String prenom = fieldFirstName.getText();
			String numero = fieldNumber.getText();

			// Ajout du contact à la ContactList (cl)
			cl.addContact(nom, prenom, numero);
			System.out.println(cl.toString());
		}
	}

	// Listener du button de confirmation de quitter la ContactCreation
	class Cancel_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int reponse = JOptionPane.showConfirmDialog(null,
	                "Voulez-vous quitter l'application",
	                "Confirmation",
	                JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE);
			if(reponse == JOptionPane.YES_OPTION ){
			}
			
		}

	}

}