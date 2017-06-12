/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_contacts;

import javax.swing.JPanel;

import ressources.DefaultApplication;
import ressources.Ressources;
import ressources.Serializer;

public class ContactApplication extends DefaultApplication
{
	JPanel activePanel ;
	
	public ContactApplication()
	{
		Ressources.CONTACTLIST = (ContactList) Serializer.deserializableObject(Ressources.CONTACT_SERIALISATION) ;	
		addPanel(new ContactListPanel()) ;
//			if(Ressources.CONTACTLIST==null)
//			{
//				Ressources.CONTACTLIST = new ContactList() ;
//			}
				
	}
	

}
