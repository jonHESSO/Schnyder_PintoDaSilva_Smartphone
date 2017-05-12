/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan
 * Created : May 12, 2017
 */

package app_contacts;

public class ContactTest
{

	public static void main(String[] args)
	{
		ContactList contactList = new ContactList() ;
		contactList.addContact("Pinto", "Sam", "1");
		contactList.addContact("Schnyder", "Jon", "2");
		contactList.addContact("A", "A", "10");
		contactList.addContact("Z", "Z", "20");
		contactList.sortByLastName();
		System.out.println(contactList.toString());
	}

}
