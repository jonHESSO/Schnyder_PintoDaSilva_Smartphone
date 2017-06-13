/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : June 07, 2017
 */
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


/**
 * The Class ContactEditPanel.
 * This abstract class is used for the Modification
 * and creation of contacts
 * Only the OKAction method is abstract and has a 
 * different behaviour depending if the contact
 * is being created or modified
 */
public abstract class ContactEditPanel extends JPanel {

	/** The field first name. */
	// Textfield --> attributs obligatoires pour un contact
	protected JTextField fieldFirstName = new ContactTextField(15);
	
	/** The field last name. */
	protected JTextField fieldLastName = new ContactTextField(15);
	
	/** The field number. */
	protected JTextField fieldNumber = new ContactTextField(15);

	/** The field email. */
	// Textfield --> attributs optionnels pour un contact
	protected JTextField fieldEmail = new ContactTextField(15);

	/** The ok button. */
	// Ajout des buttons "OK" et "Cancel"
	protected JButton okButton = new JButton("OK");
	
	/** The cancel button. */
	protected JButton cancelButton = new JButton("Cancel");
	
	/** The image button. */
	protected JButton imageButton = new JButton();

	/** The close now. */
	protected boolean closeNow = false;

	/** The is active. */
	private boolean isActive = false ;

	/**
	 * Instantiates a new contact edit panel.
	 */
	public ContactEditPanel() 
	{

		loadPanel() ;
		
	}


	/**
	 * Load panel. Loads everything needed for the panel
	 * like titles and textfields
	 */
	private void loadPanel()
	{
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

		//Titres
		gc.gridx = 0;
		gc.gridy = 0;
		panel.add(new ContactIndividualTitle("Prénom"),gc);

		gc.gridx = 0;
		gc.gridy = 1;
		panel.add(new ContactIndividualTitle("Nom"),gc);

		gc.gridx = 0;
		gc.gridy = 2;
		panel.add(new ContactIndividualTitle("Numéro"),gc);

		gc.gridx = 0;
		gc.gridy = 3;
		panel.add(new ContactIndividualTitle("E-Mail"),gc);

		gc.gridx = 0;
		gc.gridy = 4;
		panel.add(new ContactIndividualTitle("Image"),gc);

		//fields
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add((fieldFirstName),gc);

		gc.gridx = 1;
		gc.gridy = 1;
		panel.add((fieldLastName),gc);

		gc.gridx = 1;
		gc.gridy = 2;
		panel.add((fieldNumber),gc);

		gc.gridx = 1;
		gc.gridy = 3;
		panel.add((fieldEmail),gc);

		//bouton pour l'image
		imageButton.addActionListener(new setPictureListener());
		gc.gridx = 1;
		gc.gridy = 4;
		panel.add((imageButton),gc);

		//boutons ok et cancel
		okButton.addActionListener(new Ok_Click());
		cancelButton.addActionListener(new cancel_Click());

		//modification du font des buttons
		okButton.setFont(Ressources.DEFAULT_FONT);
		cancelButton.setFont(Ressources.DEFAULT_FONT);

		// Ajout des buttons au panel
		gc.gridx = 0;
		gc.gridy = 5;
		panel.add((okButton),gc);

		gc.gridx = 1;
		gc.gridy = 5;
		panel.add((cancelButton),gc);

		add(panel);
	}

	/**
	 * The Class Ok_Click listener 
	 * It callse the okAction method
	 */
	class Ok_Click implements ActionListener {
		
		/**
		 * Instantiates a new ok click.
		 */
		public Ok_Click() {
		}

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			okAction() ;
		}
	}

	/**
	 * Ok action. Needs to be implemented in
	 * sub classes
	 */
	public abstract void okAction() ;

	/**
	 * The Class cancel_Click.
	 * Closes this panel
	 */
	class cancel_Click implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			cancelAction();
		}		
	}

	/**
	 * Cancel action.
	 */
	public void cancelAction(){
		Ressources.ACTIVEAPPLICATION.removePanel(Ressources.ACTIVEAPPLICATION.getActivePanel());

	}

	/**
	 *This listener creates an icon list panel, for 
	 *selecting the contact's icon. When an icon is selected
	 *the icon list panel closes, and the selected icon is passed
	 *to this panel and set in the image button
	 */
	class setPictureListener implements ActionListener
	{

		/**
		 * Action performed.
		 *
		 * @param arg0 the arg 0
		 */
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			JPanel pictureSelection = new ContactSelectPicturePanel() ;
			pictureSelection.addPropertyChangeListener(new SelectedPictureListener());
			Ressources.CONTACTAPP.addPanel(pictureSelection);
		}

	}

	/**
	 * This listener listens for the icon list panel
	 * and retrieves the selected icon when it is clicked
	 * The it closes the panel
	 */
	class SelectedPictureListener implements PropertyChangeListener
	{

		/**
		 * Property change.
		 *
		 * @param evt the evt
		 */
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


