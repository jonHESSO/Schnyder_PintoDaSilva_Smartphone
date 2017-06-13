/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_contacts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ressources.DefaultApplication;
import ressources.Ressources;
import ressources.Serializer;
import ressources.SmartPhone;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactApplication.
 */
public class ContactApplication extends DefaultApplication
{
	
	/** The active panel. */
	JPanel activePanel ;

	/**
	 * Instantiates a new contact application.
	 */
	public ContactApplication()
	{
		Ressources.CONTACTLIST = (ContactList) Serializer.deserializableObject(Ressources.CONTACT_SERIALISATION) ;	
		if (Ressources.CONTACTLIST == null)
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Liste de contact corrompue. Une nouvelle liste va être créée") ;
			Serializer.serializableObject(new ContactList(),Ressources.CONTACT_SERIALISATION) ;
			Ressources.CONTACTLIST = (ContactList) Serializer.deserializableObject(Ressources.CONTACT_SERIALISATION) ;			
		}
		addPanel(new ContactListPanel()) ;

	}


}
