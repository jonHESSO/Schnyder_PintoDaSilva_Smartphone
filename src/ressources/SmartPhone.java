/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 13, 2017
 */

package ressources;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.swing.JOptionPane;

import app_contacts.ContactList;
import app_tictactoe.TicTacToeStats;
import mainFrame.MainFrame;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartPhone. It contains the main method
 * to launch the smartphone. It has a method to verify
 * that everything used by the smartphone is loaded correctly
 */
public class SmartPhone
{
	
	static MainFrame mainFrame ;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException
	{		
		verifyDependencies() ;
		AppManager.start();
		System.out.println(Ressources.DATAPATH);
		Ressources.MAINFRAME = new MainFrame() ;
		Ressources.MAINFRAME.setVisible(true);		

	}

	/**
	 * Verify dependencies. Checks if everything needed exists, and
	 * tries to create them if they don't. Has fancy little warning
	 * dialogs.
	 */
	public static void verifyDependencies()
	{
		//set paths
		String folderPath = "" ;
		try
		{
			folderPath = new File(".").getCanonicalPath().replace("\\", "/")+"/";
		} catch (IOException e)
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Where the hell did you put your programm ?!?");
		} 
		Ressources.DATAPATH = folderPath ;
		Ressources.GALLERY_DIRECTORY = folderPath+"data/gallery/";
		Ressources.TICTACTOE_DIRECTORY = folderPath+"data/tictactoe_stats/";
		Ressources.CONTACT_DIRECTORY = folderPath+"data/contact/";
		
		Ressources.CONTACT_SERIALISATION = folderPath+"data/contact/contactlist.ser";
		Ressources.TICTACTOE_SERIALISATION = folderPath+"data/tictactoe_stats/scores.ser";
		
		
		//directories and serialisation files
		
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
	public static void reloadCenterPanel()
	{
		Ressources.MAINFRAME.refreshCenterPanel() ;
	}

}
