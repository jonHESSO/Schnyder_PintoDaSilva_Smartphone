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

public class ContactCreationJpanel extends JPanel {

	// Panel accueillant le panel avec les JTexfields et celui avec les JButtons
	public ContactCreationJpanel() {

		this.setPreferredSize(new Dimension(500, 800));
		setLayout(new BorderLayout());
		add(fieldsLabelsPanel(), BorderLayout.WEST);
		add(contactFieldsPanel(), BorderLayout.EAST);
		add(buttonsPanel(), BorderLayout.SOUTH);
	}

	//Panel accueillant les labels des textFields
	public JPanel fieldsLabelsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(50, 500));
		panel.add(new JLabel ("Prénom")).setPreferredSize(new Dimension(50, 20));
		panel.add(new JLabel ("Nom")).setPreferredSize(new Dimension(50, 20));
		panel.add(new JLabel ("Numéro")).setPreferredSize(new Dimension(50, 20));
		panel.add(new JLabel ("E-Mail")).setPreferredSize(new Dimension(50, 20));
		panel.add(new JLabel ("Image")).setPreferredSize(new Dimension(50, 20));
		
		

		return panel;
	}

	// Panel accueillant les buttons "Ok" et "Cancel"
	public JPanel buttonsPanel() {

		JPanel panel = new JPanel(new FlowLayout());
		JButton okButton = new JButton("OK");
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new Cancel_Click());
		// Ajout des buttons
		panel.add(okButton);
		panel.add(cancelButton);

		return panel;
	}

	class Cancel_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Voulez-vous annuler la création du contact ?",
					"Confirmation d'annulation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			// if (ret == JOptionPane.YES_OPTION)
			// Ferme uniquement la fenêtre:
			// a faire plus tard, revient sur la fenetre precedente (liste de
			// contacts)
		}
	}

	// Panel contenant les textfield

	public JPanel contactFieldsPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(200, 500));
		// Ajout des textfields
		// Textfield --> attributs obligatoires pour un contact
		JTextField fieldFirstName = new JTextField(25);
		fieldFirstName.setPreferredSize(new Dimension(50, 20));
		JTextField fieldLastName = new JTextField(25);
		fieldFirstName.setPreferredSize(new Dimension(50, 20));
		JTextField fieldNumber = new JTextField(25);
		fieldFirstName.setPreferredSize(new Dimension(50, 20));

		// Textfield --> attributs optionnels pour un contact
		JTextField fieldEmail = new JTextField(25);
		fieldFirstName.setPreferredSize(new Dimension(50, 20));
		JTextField fieldImagePath = new JTextField(25);
		fieldFirstName.setPreferredSize(new Dimension(50, 20));
		// attributs obligatoires pour un contact
		panel.add(fieldFirstName);
		panel.add(fieldLastName);
		panel.add(fieldNumber);
		// attributs optionnels pour un contact
		panel.add(fieldEmail);
		panel.add(fieldImagePath);
		return panel;
	}
}
