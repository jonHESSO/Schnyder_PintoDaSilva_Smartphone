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
	

	private ContactList list = Ressources.CONTACTLIST;		

	public ContactListJpanel(){
		File f = new File(contactPath) ;
		if (f.exists()==false)
		{
			try{
				 Serializer.serializableObject(new ContactList(),contactPath);
				}
				 catch (Exception e)
				{
					e.printStackTrace();
				}
		}
		try{
			 list = (ContactList)Serializer.deserializableObject(contactPath);
			 contactList = list.getContactList();
			}
			 catch (Exception e)
			{
				e.printStackTrace();
			}
		
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new FlowLayout());

		
		add(contactListPane()) ;
		add(ButtonPanel(), BorderLayout.SOUTH);

	}
	
	private JScrollPane contactListPane()
	{
		DefaultTableModel model = new DefaultTableModel() ;
		final JTable contactTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(contactTable);
		
		contactTable.setEnabled(false);
		model.addColumn("First Name") ;
		model.addColumn("Last Name") ;
		model.addColumn("Image") ;
		contactTable.addMouseListener(new java.awt.event.MouseAdapter() {
			
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent e) {
		        int row = contactTable.rowAtPoint(e.getPoint());
		        if (row >= 0) { 
		        JFrame jf =  new JFrame() ;
		        
		        //needs correction, sorry sam
		        jf.add(new ContactIndividualJPanel(list.getContact(row)));
		        jf.pack();
		        jf.setVisible(true);
		        }
		    }
		});
		
		for (int i = 0; i< list.getContactList().size();i++){
			Object [] contactData = {list.getContact(i).getFirstName(),list.getContact(i).getLastName(),list.getContact(i).getPicture()} ;
			
			model.addRow(contactData) ;
		} 
		return scrollPane ;
	}
	
	private JPanel ButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton CreationButton = new JButton ("Nouveau");
		
		CreationButton.addActionListener(new Create_Click());
		panel.add((CreationButton), BorderLayout.EAST);
		
		return panel;
	}
	
	class Create_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			}
		}
}
