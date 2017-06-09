package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import app_contacts.ContactIndividualJPanel.Modif_Click;
import ressources.Ressources;
import ressources.Serializer;

public class ContactListJpanel extends JPanel {
	

	private ContactList list ;	

	public ContactListJpanel(){
		
		if(Ressources.CONTACTLIST==null)
		{
			Ressources.CONTACTLIST = new ContactList() ;
		}
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new FlowLayout());

		
		add(contactListPane()) ;
		add(ButtonPanel(), BorderLayout.SOUTH);

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

		contactTable.addMouseListener(new java.awt.event.MouseAdapter() {
			
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        int row = contactTable.rowAtPoint(e.getPoint());
		        if (row >= 0) { 
		        JFrame jf =  new JFrame() ;
		        
		        //needs correction, sorry sam
		        jf.add(new ContactIndividualJPanel(Ressources.CONTACTLIST.getContact(row)));
		        jf.pack();
		        jf.setVisible(true);
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
			JFrame jf = new JFrame() ;
			jf.add(new ContactCreationJpanel()) ;
			jf.setVisible(true);
			}
		}
}
