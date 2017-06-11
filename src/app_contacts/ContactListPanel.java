package app_contacts;

import java.awt.BorderLayout;
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

public class ContactListPanel extends JPanel {
	

	private ContactList list ;	
	private boolean newActivePanel = false ;

	public ContactListPanel(){
		
		if(Ressources.CONTACTLIST==null)
		{
			Ressources.CONTACTLIST = new ContactList() ;
		}
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new FlowLayout());

		reload() ;
		firePropertyChange("isActive", false, true);
		
		

	}
	
	private JScrollPane contactListPane()
	{
		Object[][] contactData = new Object[Ressources.CONTACTLIST.getContactList().size()][3] ;
		String[] columnNames = {"Last Name", "First Name", "Image"} ;
		DefaultTableModel model = new DefaultTableModel(){
		    @Override
		    public Class<?> getColumnClass(int column) {
		        switch (column) {
		            case 2: return ImageIcon.class;
		            default: return String.class ;
		        }
		    }
		};

		model.addColumn("First Name") ;
		model.addColumn("Last Name") ;
		model.addColumn("Image") ;
		for (int i = 0; i< Ressources.CONTACTLIST.getContactList().size();i++){
			Object[] currentContactData = {Ressources.CONTACTLIST.getContact(i).getFirstName(),Ressources.CONTACTLIST.getContact(i).getLastName(),Ressources.CONTACTLIST.getContact(i).getPicture()} ;
			model.addRow(currentContactData) ;
		} 
		final JTable contactTable = new JTable(model);
		contactTable.setShowGrid(false);
		JScrollPane scrollPane = new JScrollPane(contactTable);
		
		contactTable.setEnabled(false);

		contactTable.addMouseListener(new MouseAdapter() {
			
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = contactTable.rowAtPoint(e.getPoint());
		        if (row >= 0) { 
		        Contact currentContact = Ressources.CONTACTLIST.getContact(row) ;
		        JPanel individualPanel = new ContactIndividualPanel(currentContact) ;
		        individualPanel.addPropertyChangeListener(new PropertyChangeListener()
				{
					
					@Override
					public void propertyChange(PropertyChangeEvent evt)
					{
						if (evt.getPropertyName().equals("contactModified"))
						{
							reload() ;
						}
					}
				});
		        Ressources.CONTACTAPP.addPanel(individualPanel) ;
		        }
		    }
		});
		
		
		return scrollPane ;
	}
	
	private JPanel ButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton creationButton = new JButton ("Nouveau");
		
		creationButton.addActionListener(new Create_Click());
		panel.add((creationButton), BorderLayout.EAST);
		
		return panel;
	}
	
	class Create_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JPanel creationPanel = new ContactCreationPanel() ;
			creationPanel.addPropertyChangeListener(new PropertyChangeListener()
			{
				
				@Override
				public void propertyChange(PropertyChangeEvent evt)
				{
					if (evt.getPropertyName().equals("contactCreated"))
					{
						ContactListPanel.this.reload() ;
						Ressources.CONTACTAPP.removePanel(creationPanel) ;
					}
				}
			});
			Ressources.CONTACTAPP.addPanel(creationPanel) ;
			}
		}
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