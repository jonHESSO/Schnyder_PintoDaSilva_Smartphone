package app_contacts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
		add(createIndividualPanels()) ;
		
	}
	
	
	private JTable createIndividualPanels()
	{
		DefaultTableModel model = new DefaultTableModel() ;
		String[] contactTitle = {"First Name", "Last Name", "Image"};
		JTable contactTable = new JTable(model);
		
		model.addColumn("First Name") ;
		model.addColumn("Last Name") ;
		model.addColumn("Image") ;
		
		model.addRow(contactTitle);
		for (int i = 0; i< contactList.size();i++){
			String [] contactData = {list.getContact(i).getFirstName(),list.getContact(i).getLastName(),list.getContact(i).getImagePath()} ;
			
			model.addRow(contactData) ;
		} 
		return contactTable ;
	}
}
