/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Samuel Pinto Da Silva
 * Created : May 22, 2017
 */
package app_contacts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ressources.Ressources;
import ressources.Serializer;


/**
 * The Class ContactListPanel.
 * This class loads the contact list
 * into a scrollable table
 */
public class ContactListPanel extends JPanel {

	/**
	 * Instantiates a new contact list panel.
	 */
	public ContactListPanel(){


		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new FlowLayout());
		//reload permet de charger toute la liste
		reload() ;

	}
	
	/**
	 * Contact list pane.
	 *
	 * @return pane the JScrollPane containing all the contacts
	 */
	private JScrollPane contactListPane()
	{
		//utilisation d'un modele de table modifié pouvant accueillir des images
		DefaultTableModel model = new DefaultTableModel(){


			@Override
			//definit le type de contenu pour la column #2 (imageicon)
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 2: return ImageIcon.class;
				default: return String.class ;
				}
			}
		};
		
		//ajout des en-tetes
		model.addColumn("First Name") ;
		model.addColumn("Last Name") ;
		model.addColumn("Image") ;
		//ajout des contacts au modele de table, un par un
		for (int i = 0; i< Ressources.CONTACTLIST.getContactList().size();i++){
			//array contenant le prenom, le nom et l'icone du contact
			Object[] currentContactData = {Ressources.CONTACTLIST.getContact(i).getFirstName(),Ressources.CONTACTLIST.getContact(i).getLastName(),Ressources.CONTACTLIST.getContact(i).getPicture()} ;
			//ajout de la ligne au modele de table
			model.addRow(currentContactData) ;
		} 
		//table contenant les contacts
		final JTable contactTable = new JTable(model);
		//modifications graphique de la table
		contactTable.setShowGrid(false);
		contactTable.setRowHeight(150);
		contactTable.setFont(Ressources.CONTACT_FONT_TITLE);
		//ajout de la tale au scrollpane
		JScrollPane scrollPane = new JScrollPane(contactTable);
		//modifications des propriétés de la scrollpane
		scrollPane.setPreferredSize(new Dimension (480,620));

		contactTable.setEnabled(false);
		//ajout d'un listener qui ouvre un panel d'info du contact selectionné
		contactTable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = contactTable.rowAtPoint(e.getPoint());
				if (row >= 0) { 
					//ouverture du paneau d'info du contact
					Contact currentContact = Ressources.CONTACTLIST.getContact(row) ;
					JPanel individualPanel = new ContactIndividualPanel(currentContact) ;
					//ajout d'un listener sur le panel d'info contact pour savoir si le contact a été modifié ou supprimé
					individualPanel.addPropertyChangeListener(new PropertyChangeListener()
					{

						@Override
						public void propertyChange(PropertyChangeEvent evt)
						{
							//modification, ce panel est rechargé mais le panel d'info reste actif
							if (evt.getPropertyName().equals("contactModified"))
							{	
								reload() ;
							}
							//suppression, on retire le panel d'info du contact et on recharge la liste de contact
							if (evt.getPropertyName().equals("contactDeleted"))
							{
								ContactListPanel.this.reload() ;
								Ressources.CONTACTAPP.removePanel(individualPanel) ;
							}
						}
					});
					//ajout du panel d'info du contact
					Ressources.CONTACTAPP.addPanel(individualPanel) ;
				}
			}
		});

		//on récupère le scrollpane complet avec la liste des contact
		return scrollPane ;
	}

	/**
	 * Button panel.
	 *
	 * @return the j panel
	 */
	//methode generant le panel avec les boutons, pas important
	private JPanel ButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton creationButton = new JButton ("Nouveau");

		creationButton.setFont(Ressources.DEFAULT_FONT);
		creationButton.addActionListener(new Create_Click());
		panel.add((creationButton), BorderLayout.EAST);

		return panel;
	}

	/**
	 * listener for the create button
	 * Opens a new creation panel and
	 * removes it if a contact is created.
	 * The it reloads this panel
	 */
	private class Create_Click implements ActionListener {
		
		/**
		 * Action performed.
		 *
		 * @param e the event
		 */
		public void actionPerformed(ActionEvent e) {
			//ouverture du paneau de création de contact
			JPanel creationPanel = new ContactCreationPanel() ;
			//ajout du listener sur le paneau de creationd de contact, pour savoir si un contact a été créé
			creationPanel.addPropertyChangeListener(new PropertyChangeListener()
			{

				@Override
				//si un contact a été créé, on recharge la liste des contacts, et on retire le panel de creation de contact
				public void propertyChange(PropertyChangeEvent evt)
				{
					if (evt.getPropertyName().equals("contactCreated"))
					{
						ContactListPanel.this.reload() ;
						Ressources.CONTACTAPP.removePanel(creationPanel) ;
					}
				}
			});
			//ajout du panel de creation de contact
			Ressources.CONTACTAPP.addPanel(creationPanel) ;
		}
	}
	
	/**
	 * Loads all the infos for the panel
	 */
	private void reload()
	{
		if(getComponentCount()>0)
		{
			removeAll();
		}
		add(contactListPane(),BorderLayout.NORTH) ;
		add(ButtonPanel(), BorderLayout.SOUTH);
		revalidate() ;
		repaint() ;
	}

}
