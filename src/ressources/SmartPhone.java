/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 11, 2017
 */

package ressources;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFrame;

import app_contacts.ContactList;
import app_tictactoe.TicTacToeStats;
import mainFrame.MainFrame;

public class SmartPhone 
{	

	public static void main(String[] args)
	{
		Ressources.MAINFRAME = new MainFrame() ;
		verifyDependencies() ;
		//		Ressources.MAINFRAME.addPropertyChangeListener(new PropertyChangeListener()
		//		{
		//			
		//			@Override
		//			public void propertyChange(PropertyChangeEvent evt)
		//			{
		//				if (evt.getPropertyName().equals("activeAppChanged"))
		//				{
		//					Ressources.MAINFRAME.reloadCenterPanel();
		//				}
		//			}
		//		});
		Ressources.MAINFRAME.setVisible(true);		

	}

	public static void verifyDependencies()
	{
		//gallery
		File galleryDirectory = new File(Ressources.GALLERY_DIRECTORY) ;
		if (galleryDirectory.exists()== false)
		{
			galleryDirectory.mkdir() ;
		}

		//contacts
		File contactDirectory = new File(Ressources.CONTACT_DIRECTORY) ;
		if (contactDirectory.exists()== false)
		{
			contactDirectory.mkdir() ;
		}
		File contactSerialisation = new File(Ressources.CONTACT_SERIALISATION) ;
		if (contactSerialisation.exists()==false)
		{
			Serializer.serializableObject(new ContactList(), Ressources.CONTACT_SERIALISATION);
		}
		//tictactoe
		File tictactoeDirectory = new File(Ressources.TICTACTOE_DIRECTORY) ;
		if (tictactoeDirectory.exists()== false)
		{
			tictactoeDirectory.mkdir() ;
		}
		File tictactoeSerialisation = new File(Ressources.TICTACTOE_SERIALISATION) ;
		if (tictactoeSerialisation.exists()==false)
		{
			Serializer.serializableObject(new TicTacToeStats(), Ressources.TICTACTOE_SERIALISATION);
		}

	}

	//	static class ActiveAppListener implements PropertyChangeListener
	//	{
	//
	//		@Override
	//		public void propertyChange(PropertyChangeEvent evt)
	//		{
	//			if (evt.getPropertyName().equals("activeAppChanged")||evt.getPropertyName().equals("activePanelChanged")) 
	//			{
	//				Ressources.MAINFRAME.reloadCenterPanel();
	//			}
	//		}
	//		
	//	}

}
