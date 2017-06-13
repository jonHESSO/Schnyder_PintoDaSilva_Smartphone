package app_contacts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import ressources.ContactIndividualLabel;
import ressources.ContactIndividualTitle;
import ressources.Ressources;
import ressources.Serializer;
import app_contacts.Contact ;
import app_gallery.PicturePanel;

public class ContactIndividualPanel extends JPanel {

	private Contact currentContact ;
	private boolean contactModified = false ;
	private JPanel gridPanel ;

	public ContactIndividualPanel(Contact currentContact){

		this.currentContact = currentContact ;

		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		gridPanel = new JPanel ();
		gridPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		gc.fill = GridBagConstraints.WEST;
		gc.insets = new Insets(15,30,15,15);
		gc.ipady = gc.anchor = GridBagConstraints.WEST;
		reload() ;
		//Ajout des panels pour la photo, des infos et du modifyButton
//		add(picturePanel(),BorderLayout.NORTH) ;
//		add(informationPanel(),BorderLayout.CENTER) ;
//		add(modifyButtonPanel(),BorderLayout.SOUTH) ;
		gc.gridx = 0;
		gc.gridy = 0;
		gridPanel.add(new JLabel(currentContact.getPicture()),gc);
		
		//Ajout des attributs du currentContact
		gc.gridx = 0;
		gc.gridy = 1;
		gridPanel.add(new ContactIndividualTitle("Prenom:"),gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gridPanel.add(new ContactIndividualLabel(currentContact.getFirstName()),gc);
		gc.gridx = 0;
		gc.gridy = 2;
		gridPanel.add(new ContactIndividualTitle("Nom:"),gc);
		gc.gridx = 1;
		gc.gridy = 2;
		gridPanel.add(new ContactIndividualLabel(currentContact.getLastName()),gc);
		gc.gridx = 0;
		gc.gridy = 3;
		gridPanel.add(new ContactIndividualTitle("Numero:"),gc);
		gc.gridx = 1;
		gc.gridy = 3;
		gridPanel.add(new ContactIndividualLabel(currentContact.getNumber()),gc);
		gc.gridx = 0;
		gc.gridy = 4;
		gridPanel.add(new ContactIndividualTitle("E-Mail:"),gc);
		gc.gridx = 1;
		gc.gridy = 4;
		gridPanel.add(new ContactIndividualLabel(currentContact.getEmail()),gc);
		
//		JButton modifButton = new JButton ("Modifier");
//		//ajout du listener au modifbutton
//    	modifButton.addActionListener(new Modif_Click());
//
//		JButton deleteButton = new JButton("Supprimer") ;
//		
//		deleteButton.addActionListener(new Delete_Click());
//		deleteButton.setFont(Ressources.DEFAULT_FONT);
//
//		//ajout du Font au modifbutton
//		modifButton.setFont(Ressources.DEFAULT_FONT);
//
//		//ajout du modifbutton au panel
//		gc.gridx = 0;
//		gc.gridy = 6;
//		panel.add((modifButton),gc);
//		gc.gridx = 1;
//		gc.gridy = 6;
//		panel.add((deleteButton),gc) ;
	
		gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 6;
		gridPanel.add(buttonPanel(),gc);
		add(gridPanel);
	}

	
	
	//Panel accueillant la photo
//	private JPanel picturePanel() {
//		
//		//Création du panel
//		JPanel panel = new JPanel();
//		
//		//Dimensionnement du panel
//		panel.setPreferredSize(new Dimension(450, 300));
//		
//		//ajout du contact actuel sur le panel
//		panel.add(new JLabel(currentContact.getPicture()),BorderLayout.CENTER);
//		return panel;
//	}

//	//Panel contenant les informations du contact
//	private JPanel informationPanel() {
//		//Création du panel contenant les informations
//		JPanel panel = new JPanel(new FlowLayout());
//
//		//Dimensionnement du panel
//		panel.setPreferredSize(new Dimension(450, 160));
//		
//		//Ajout des attributs du currentContact
//		panel.add(new ContactIndividualTitle("Prénom:"));
//		panel.add(new ContactIndividualLabel(currentContact.getFirstName()));
//		panel.add(new ContactIndividualTitle("Nom:"));
//		panel.add(new ContactIndividualLabel(currentContact.getLastName()));
//		panel.add(new ContactIndividualTitle("Numéro:"));
//		panel.add(new ContactIndividualLabel(currentContact.getNumber()));
//		panel.add(new ContactIndividualTitle("E-Mail:"));
//		panel.add(new ContactIndividualLabel(currentContact.getEmail()));
//
//		return panel;
//	}


	//Panel content le modifButton et le deleteButton
	private JPanel buttonPanel() {
		
		//création du panel

		JPanel modifDeletePanel = new JPanel();
		//Création du modifButton 
		JButton modifButton = new JButton ("Modifier");
		//ajout du listener au modifbutton
    	modifButton.addActionListener(new Modif_Click());

		JButton deleteButton = new JButton("Supprimer") ;
		
		deleteButton.addActionListener(new Delete_Click());
		deleteButton.setFont(Ressources.DEFAULT_FONT);



		//ajout du Font au modifbutton
		modifButton.setFont(Ressources.DEFAULT_FONT);

		//ajout du modifbutton au panel


		modifDeletePanel.add(modifButton);
		modifDeletePanel.add(deleteButton);
		

		return modifDeletePanel;
	}
	// listener Modif_Click
	class Modif_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Création d'un ContactModifyPanel
			JPanel modifyPanel = new ContactModifyPanel(currentContact);
			modifyPanel.addPropertyChangeListener(new PropertyChangeListener()
			{

				@Override
				public void propertyChange(PropertyChangeEvent evt)
				{
					//Catching event evt
					if (evt.getPropertyName().equals("contactModified"))
					{
						// Reload IndividualPanel
						ContactIndividualPanel.this.reload() ;
						// On supprime le modifyPanel
						Ressources.CONTACTAPP.removePanel(modifyPanel) ;
						// On indique que le contact a été modifié
						contactModified = (boolean) evt.getNewValue() ;
						boolean oldValue = false ;
						// On lance un nouvel event pour indiquer au panel parent (contactListPanel) que le contact a été modifié 
						ContactIndividualPanel.this.firePropertyChange("contactModified", oldValue, contactModified);
					}
				}
			});

			Ressources.CONTACTAPP.addPanel(modifyPanel) ;
		}
	}
	
	class Delete_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(Ressources.MAINFRAME,"Etes vous sur ?");
			if (ret == JOptionPane.YES_OPTION)
			{
				Ressources.CONTACTLIST.deleteContact(currentContact);
				Serializer.serializableObject(Ressources.CONTACTLIST, Ressources.CONTACT_SERIALISATION);
				ContactIndividualPanel.this.firePropertyChange("contactDeleted", false, true);
			}
			
		}
	}

	// Méthode permettant de rafraichir le panel
	private void reload()
	{
		if(getComponentCount()>0)
		{
			removeAll();
		}
//		add(picturePanel(), BorderLayout.NORTH);
//		add(informationPanel(), BorderLayout.CENTER);
//		add(modifyButtonPanel(), BorderLayout.SOUTH);
		revalidate() ;
		repaint() ;
	}
}
