package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import app_contacts.ContactIndividualJPanel.Modif_Click;
import ressources.Ressources;

public class ContactListJpanel extends JPanel {
	
	private ContactList list = new ContactList();
	private List<Contact> contactList = list.getContactList();
		

	public ContactListJpanel(){
		//Ajout des dimensions 
		this.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new FlowLayout());
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		list.addContact("a", "b", "8");
		add(createIndividualPanels()) ;
		add(CreationButtonPanel(), BorderLayout.SOUTH);
	}
	
	private JScrollPane createIndividualPanels()
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
		
		for (int i = 0; i< contactList.size();i++){
			String [] contactData = {list.getContact(i).getFirstName(),list.getContact(i).getLastName(),list.getContact(i).getImagePath()} ;
			
			model.addRow(contactData) ;
		} 
		return scrollPane ;
	}
	
	private JPanel CreationButtonPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JButton CreationButton = new JButton ("Nouveau");
		
		CreationButton.addActionListener(new Create_Click());
		panel.add((CreationButton), BorderLayout.EAST);
		
		return panel;
	}
	
	class Create_Click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
				JFrame jf =  new JFrame() ;
		        jf.add(new ContactCreationJpanel());
		        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        jf.pack();
		        jf.setVisible(true);
			}
		}
}
