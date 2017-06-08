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

	// Panel accueillant le panel avec les JTexfields, celui avec les labels et celui avec les JButtons
	public ContactEditPanel() {

		// Ajout des dimensions
		this.setPreferredSize(Ressources.CONTACT_APP_CREATIONPANEL);
		setLayout(new BorderLayout());

		// Ajout des panels de labels, de textfields et de buttons au panel
		add(fieldsLabelsPanel(), BorderLayout.WEST);
		add(contactFieldsPanel(), BorderLayout.EAST);
		add(buttonPanel(), BorderLayout.SOUTH);
	}

	// Panel contenant les labels des textFields
	public JPanel fieldsLabelsPanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		//Creation du panel
		JPanel panel = new JPanel(new FlowLayout());
		//Dimensionnement du panel
		panel.setPreferredSize(new Dimension(50, 500));
		//Ajout des labels au panel
		panel.add(new JLabel("Pr�nom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Nom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Num�ro")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("E-Mail")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(new JLabel("Image")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);

		return panel;
	}

	// Panel contenant les textfield et le bouton pour l'image
	public JPanel contactFieldsPanel() {
		//Cr�ation du panel
		JPanel panel = new JPanel(new FlowLayout());
		//Dimensionnement du panel
		panel.setPreferredSize(new Dimension(200, 500));
		
		// Ajout des JTextfield
		panel.add(fieldFirstName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldLastName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldNumber).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldEmail).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		panel.add(fieldImagePath).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		
		//Bouton d'ajout d'image
		panel.add(imageButton).setPreferredSize(new Dimension (150,150));

		return panel;
	}

	// Panel contenant les buttons Ok et Cancel
	public JPanel buttonPanel() {
		// Cr�ation du panel
		JPanel panel = new JPanel(new FlowLayout());
		// Ajout des listener aux buttons
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new cancel_Click());
		// Ajout des buttons au panel
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
	
	//Methode d'action du listener du okButton
	public abstract void okAction() ;

	// Listener du button cancel
	class cancel_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cancelAction();
		}		
	}
	
	//Methode d'action du listener du okButton
	public abstract void cancelAction();
		
	}


