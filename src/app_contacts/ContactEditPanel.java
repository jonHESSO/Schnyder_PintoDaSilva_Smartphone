package app_contacts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;
import ressources.ContactIndividualTitle;
import ressources.ContactTextField;
import ressources.Ressources;
import ressources.Serializer;

public abstract class ContactEditPanel extends JPanel {

	// Textfield --> attributs obligatoires pour un contact
	protected JTextField fieldFirstName = new ContactTextField(15);
	protected JTextField fieldLastName = new ContactTextField(15);
	protected JTextField fieldNumber = new ContactTextField(15);

	// Textfield --> attributs optionnels pour un contact
	protected JTextField fieldEmail = new ContactTextField(15);

	// Ajout des buttons "OK" et "Cancel"
	protected JButton okButton = new JButton("OK");
	protected JButton cancelButton = new JButton("Cancel");
	protected JButton imageButton = new JButton();
	
	protected boolean closeNow = false;
	
	private boolean isActive = false ;

	// Panel accueillant le panel avec les JTexfields, celui avec les labels et celui avec les JButtons
	public ContactEditPanel() {
		JPanel panel = new JPanel ();
		panel.setLayout(new GridBagLayout());
		// Ajout des dimensions
		this.setPreferredSize(Ressources.CONTACT_APP_CREATIONPANEL);
		/* On ajoute un gridbagLauout au panel */
		setLayout(new GridBagLayout());
		
		/* Le gridBagConstraints va définir la position et la taille des éléments */
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.BOTH;
		gc.insets = new Insets(15,15,15,15);
		//gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		
		/*gc.weightx = 5;
		gc.weighty = 10;*/

		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(new ContactIndividualTitle("Prénom"),gc);
		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(new ContactIndividualTitle("Nom"),gc);
		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 2;
		panel.add(new ContactIndividualTitle("Numéro"),gc);
		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 3;
		panel.add(new ContactIndividualTitle("E-Mail"),gc);
		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 4;
		panel.add(new ContactIndividualTitle("Image"),gc);
		
		//gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add((fieldFirstName),gc);
		//gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 1;
		panel.add((fieldLastName),gc);
		//gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 2;
		panel.add((fieldNumber),gc);
		//gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 3;
		panel.add((fieldEmail),gc);
		
		
		//gc.gridwidth = 2;
		//gc.gridheight = 2;
		imageButton.addActionListener(new setPictureListener());
		gc.gridx = 1;
		gc.gridy = 4;
		panel.add((imageButton),gc);
		
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new cancel_Click());
		//modification du font des buttons
		okButton.setFont(Ressources.DEFAULT_FONT);
		cancelButton.setFont(Ressources.DEFAULT_FONT);
		// Ajout des buttons au panel
		//gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 5;
		panel.add((okButton),gc);
		
		//gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 5;
		panel.add((cancelButton),gc);
		
		add(panel);
		// Ajout des panels de labels, de textfields et de buttons au panel
		//add(fieldsLabelsPanel(), BorderLayout.WEST);
		//add(contactFieldsPanel(), BorderLayout.EAST);
		//add(buttonPanel(), BorderLayout.SOUTH);
		//isActive = true ;
		//firePropertyChange("isActive", false, true);
	}

//	// Panel contenant les labels des textFields
//	public JPanel fieldsLabelsPanel() {
//		setBorder(new EmptyBorder(10, 10, 10, 10));
//		//Creation du panel
//		JPanel panel = new JPanel(new FlowLayout());
//		//Dimensionnement du panel
//		panel.setPreferredSize(new Dimension(100, 400));
//		//Ajout des labels au panel
//		panel.add(new ContactIndividualTitle("Prénom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(new ContactIndividualTitle("Nom")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(new ContactIndividualTitle("Numéro")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(new ContactIndividualTitle("E-Mail")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(new ContactIndividualTitle("Image")).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);

//		return panel;
//	}

	// Panel contenant les textfield et le bouton pour l'image
//	public JPanel contactFieldsPanel() {
//		//Création du panel
//		JPanel panel = new JPanel(new FlowLayout());
//		//Dimensionnement du panel
//		panel.setPreferredSize(new Dimension(200, 400));
//		
//		// Ajout des JTextfield
//		panel.add(fieldFirstName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(fieldLastName).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(fieldNumber).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
//		panel.add(fieldEmail).setPreferredSize(Ressources.CONTACT_TEXTFIELD_DIMENSION);
		//Bouton d'ajout d'image
//		imageButton.addActionListener(new setPictureListener());
//		panel.add(imageButton).setPreferredSize(new Dimension (150,150));

//		return panel;
//	}

	
//	// Panel contenant les buttons Ok et Cancel
//	public JPanel buttonPanel() {
//		// Création du panel
//		JPanel panel = new JPanel(new FlowLayout());
//		panel.setPreferredSize(new Dimension(150, 100));
//		// Ajout des listener aux buttons
//		okButton.addActionListener(new Ok_Click());
//		cancelButton.addActionListener(new cancel_Click());
//		//modification du font des buttons
//		okButton.setFont(Ressources.DEFAULT_FONT);
//		cancelButton.setFont(Ressources.DEFAULT_FONT);
//		// Ajout des buttons au panel
//		panel.add(okButton);
//		panel.add(cancelButton);
//
//		return panel;
//	}

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
	
	//Methode d'action du listener du cancelButton
	public void cancelAction(){
		Ressources.ACTIVEAPPLICATION.removePanel(Ressources.ACTIVEAPPLICATION.getActivePanel());
			
	}
	
	// Listener du imageButton
	class setPictureListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			JPanel pictureSelection = new ContactSelectPicturePanel() ;
			pictureSelection.addPropertyChangeListener(new SelectedPictureListener());
			Ressources.CONTACTAPP.addPanel(pictureSelection);
		}
		
	}
	
	class SelectedPictureListener implements PropertyChangeListener
	{

		@Override
		public void propertyChange(PropertyChangeEvent evt)
		{
			//Catching event evt
			if (evt.getPropertyName().equals("selectedPicture"))
					{
						System.out.println(evt.getNewValue().toString());
						// On ajoute l'image sélectionnée sur le button
						imageButton.setIcon((Icon)((ImageIcon)evt.getNewValue()));
						// On retire le panel de sélection d'image
						Ressources.CONTACTAPP.removePanel(Ressources.CONTACTAPP.getActivePanel());
					}
			
		}
		
	}
}


