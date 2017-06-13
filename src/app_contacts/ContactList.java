/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan
 * Created : May 12, 2017
 */

package app_contacts;

import java.io.Serializable;
import java.util.*;

import javax.swing.ImageIcon;


/**
 * This class creates a list of contacts
 * It is seralizable so that it can be saved
 * and loaded when the smartphone app is openened
 * or closed. It contains sorting methods, addContact
 * methods, modifyContactMethod and deleteContact method.
 */


public class ContactList implements Serializable
{

	/** The contact list. */
	//List containing every saved contact
	private List<Contact> contactList = new ArrayList<Contact>() ;

	/**
	 * Adds the contact.
	 *
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param number the number
	 * @param email the email
	 * @param picture the picture
	 */
	//Method for adding a new contact to the list
	public void addContact(String lastName, String firstName, String number, String email, ImageIcon picture)
	{
		//creates a new contact in the list
		contactList.add(new Contact(lastName, firstName, number, email, picture)) ;
		sortByFirstName() ;
	}

	/**
	 * Modify contact.
	 *
	 * @param currentContact the current contact
	 * @param lastName the last name
	 * @param firstName the first name
	 * @param number the number
	 * @param email the email
	 * @param picture the picture
	 */
	public void modifyContact(Contact currentContact, String lastName, String firstName, String number, String email, ImageIcon picture)
	{		
		currentContact.setLastName(lastName);
		currentContact.setFirstName(firstName);
		currentContact.setNumber(number);
		currentContact.setEmail(email);
		currentContact.setPicture(picture);
		sortByFirstName() ;
	}

	/**
	 * Delete contact.
	 *
	 * @param deletedContact the deleted contact
	 */
	public void deleteContact(Contact deletedContact)
	{
		contactList.remove(deletedContact) ;
		sortByFirstName() ;
	}

	/**
	 * Gets the contact.
	 *
	 * @param index the index
	 * @return the contact
	 */
	public Contact getContact(int index)
	{
		return this.contactList.get(index);
	}

	/**
	 * Gets the contact list.
	 *
	 * @return the contact list
	 */
	public List<Contact> getContactList()
	{
		return this.contactList;
	}

	/**
	 * Sort by last name.
	 */
	//sorts the list by alphabetical order (LastName)
	public void sortByLastName(){
		Collections.sort(contactList, compareLastName());
	}

	/**
	 * Sort by first name.
	 */
	//sorts the list by alphabetical order (FirstName)
	public void sortByFirstName(){
		Collections.sort(contactList, compareFirstName());
	}

	/**
	 * Compare last name.
	 *
	 * @return the comparator
	 */
	//LastName comparator method for sorting purpose
	public static Comparator<Contact> compareLastName()
	{   
		Comparator comp = new Comparator<Contact>()
		{
			@Override
			public int compare(Contact c1, Contact c2)
			{
				return c1.getLastName().compareTo(c2.getLastName());
			}        
		};
		return comp;
	}

	/**
	 * Compare first name.
	 *
	 * @return the comparator
	 */
	//FirstName comparator method for sorting purpose
	public static Comparator<Contact> compareFirstName()
	{   
		Comparator comp = new Comparator<Contact>()
		{
			@Override
			public int compare(Contact c1, Contact c2)
			{
				return c1.getFirstName().compareTo(c2.getFirstName());
			}        
		};
		return comp;
	} 

	/**
	 * To string.
	 *
	 * @return the string
	 */
	//toString method for the entire list
	public String toString(){
		String s = "" ;
		for (int i = 0; i < contactList.size(); i++)
		{
			s+=contactList.get(i).getLastName()+" "+contactList.get(i).getFirstName()+" : "+contactList.get(i).getNumber()+"\n" ;
		}
		return s ;
	}
}
