/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_contacts;

import javax.swing.JPanel;

import ressources.DefaultApplication;

public class ContactApplication extends DefaultApplication
{
	JPanel activePanel ;
	
	public ContactApplication()
	{
			addPanel(new ContactListPanel()) ;
		
	}
	

}
