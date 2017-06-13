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

	public ContactIndividualPanel(Contact currentContact)
	{

		this.currentContact = currentContact ;

		//Ajout des dimensions 
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		
		reload() ;	
		
	}

	//Panel content le modifButton et le deleteButton
	private JPanel buttonPanel() {
		
		//crÃ©ation du panel

		JPanel modifDeletePanel = new JPanel();
		//CrÃ©ation du modifButton 
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
			//CrÃ©ation d'un ContactModifyPanel
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
						// On indique que le contact a Ã©tÃ© modifiÃ©
						contactModified = (boolean) evt.getNewValue() ;
						boolean oldValue = false ;
						// On lance un nouvel event pour indiquer au panel parent (contactListPanel) que le contact a Ã©tÃ© modifiÃ© 
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

	// MÃ©thode permettant de rafraichir le panel
	private void reload()
	{
		if(getComponentCount()>0)
		{
			removeAll();
		}
		
		gridPanel = new JPanel ();
		gridPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.fill = GridBagConstraints.WEST;
		gc.insets = new Insets(15,30,15,15);
		gc.ipady = gc.anchor = GridBagConstraints.WEST;

		//Ajout des panels pour la photo, des infos et du modifyButton
;
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
		
		gc.gridwidth = 2;
		gc.gridx = 1;
		gc.gridy = 6;
		gridPanel.add(buttonPanel(),gc);
		add(gridPanel);

		revalidate() ;
		repaint() ;
	}
}
