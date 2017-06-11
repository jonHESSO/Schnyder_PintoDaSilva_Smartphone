package app_contacts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import ressources.Ressources;
import app_contacts.Contact ;

public class ContactIndividualPanel extends JPanel {

	private Contact currentContact ;
	private boolean contactModified = false ;

	public ContactIndividualPanel(Contact currentContact){

		this.currentContact = currentContact ;

		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new BorderLayout());
		//Ajout des panels pour la photo, des infos et du modifyButton
		add(picturePanel(),BorderLayout.NORTH) ;
		add(informationPanel(),BorderLayout.CENTER) ;
		add(modifyButtonPanel(),BorderLayout.SOUTH) ;
		
	}

	//Panel accueillant la photo
	private JPanel picturePanel() {
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(450, 450));
		panel.add(new JLabel(currentContact.getPicture()));
		return panel;
	}

	private JPanel informationPanel() {
		//Création du panel contenant les informations
		JPanel panel = new JPanel(new FlowLayout());

		//Dimensionnement du panel
		panel.setPreferredSize(new Dimension(450, 150));

		//Ajout des attributs du currentContact
		panel.add(new JLabel(currentContact.getFirstName()));
		panel.add(new JLabel(currentContact.getLastName()));
		panel.add(new JLabel(currentContact.getNumber()));
		panel.add(new JLabel(currentContact.getEmail()));

		return panel;
	}

	private JPanel modifyButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton modifButton = new JButton ("Modifier\n contact");

		modifButton.addActionListener(new Modif_Click());
		panel.add((modifButton), BorderLayout.EAST);

		return panel;
	}

	class Modif_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel modifyPanel = new ContactModifyPanel(currentContact);
			modifyPanel.addPropertyChangeListener(new PropertyChangeListener()
			{

				@Override
				public void propertyChange(PropertyChangeEvent evt)
				{
					if (evt.getPropertyName().equals("contactModified"))
					{
						ContactIndividualPanel.this.reload() ;
						Ressources.CONTACTAPP.removePanel(modifyPanel) ;
						contactModified = (boolean) evt.getNewValue() ;
						boolean oldValue = false ;
						ContactIndividualPanel.this.firePropertyChange("contactModified", oldValue, contactModified);
					}
				}
			});

			Ressources.CONTACTAPP.addPanel(modifyPanel) ;
		}
	}


	private void reload()
	{
		if(getComponentCount()>0)
		{
			removeAll();
		}
		add(picturePanel(), BorderLayout.NORTH);
		add(informationPanel(), BorderLayout.CENTER);
		add(modifyButtonPanel(), BorderLayout.SOUTH);
		revalidate() ;
		repaint() ;
	}
}
