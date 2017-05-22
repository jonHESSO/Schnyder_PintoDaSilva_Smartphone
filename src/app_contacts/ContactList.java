/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan
 * Created : May 12, 2017
 */

package app_contacts;

import java.io.Serializable;
import java.util.*;

/*
 * This class creates a list of contacts
 * It is seralizable so that it can be saved
 * and loaded when the smartphone app is openened
 * or closed. It contains sorting methods, addContact
 * methods, modifyContactMethod and deleteContact method.
 */

public class ContactList implements Serializable
{
	//List containing every saved contact
	private List<Contact> contactList = new ArrayList<Contact>() ;
	
	//Method for adding a new contact to the list
	public void addContact(String nom, String prenom, String numero)
	{
		//creates a new contact in the list
		contactList.add(new Contact(nom, prenom, numero)) ;
	}
	
	//sorts the list by alphabetical order (LastName)
	public void sortByLastName(){
		Collections.sort(contactList, compareLastName());
	}
	
	//sorts the list by alphabetical order (FirstName)
	public void sortByFirstName(){
		Collections.sort(contactList, compareFirstName());
	}
	
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
