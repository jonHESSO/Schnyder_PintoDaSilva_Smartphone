package app_contacts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ressources.Ressources;
import ressources.Serializer;

public abstract class ContactEditPanel extends JPanel {

	// Textfield --> attributs obligatoires pour un contact
	protected JTextField fieldFirstName = new JTextField(15);
	protected JTextField fieldLastName = new JTextField(15);
	protected JTextField fieldNumber = new JTextField(15);

	// Textfield --> attributs optionnels pour un contact
	protected JTextField fieldEmail = new JTextField(15);
	protected JTextField fieldImagePath = new JTextField(15);

	// Ajout des buttons "OK" et "Cancel"
	protected JButton okButton = new JButton("OK");
	protected JButton cancelButton = new JButton("Cancel");
	protected JButton imageButton = new JButton();

	// Panel accueillant le panel avec les JTexfields et celui avec les JButtons
	public ContactEditPanel() {

		// Ajout des dimensions
		this.setPreferredSize(Ressources.CONTACT_APP_CREATIONPANEL);
		setLayout(new BorderLayout());

		// Ajout des panels de labels, de textfields et de buttons au panel
		// principal
		add(fieldsLabelsPanel(), BorderLayout.WEST);
		add(contactFieldsPanel(), BorderLayout.EAST);
		add(buttonPanel(), BorderLayout.SOUTH);
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
		
		//Bouton d'ajout d'image
		panel.add(imageButton).setPreferredSize(Ressources.GALLERY_ICON_DIMENSION);

		return panel;
	}

	public JPanel buttonPanel() {
		JPanel panel = new JPanel(new FlowLayout());

		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new cancel_Click());

		panel.add(okButton);
		panel.add(cancelButton);

		return panel;
	}

	// Listener du button de creation de contact
	class Ok_Click implements ActionListener {
		public Ok_Click() {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			okAction() ;
		}
	}
	
	public abstract void okAction() ;

	// Listener du button de confirmation de quitter la ContactCreation
	class cancel_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}

}
