/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 14, 2017
 */

package ressources;

import javax.swing.JPanel;

import app_contacts.ContactApplication;
import app_gallery.GalleryApplication;
import app_home.HomeApplication;
import app_tictactoe.TicTacToeApplication;

public abstract class AppManager
{

	static DefaultApplication activeApp ;
	static DefaultApplication homeApp ;
	static DefaultApplication galleryApp ;
	static DefaultApplication contactApp ;
	static DefaultApplication tictactoeApp ;

	public static void start()
	{
		homeApp = new HomeApplication() ;
		activeApp = homeApp ;
	}

	public static void setActiveApp(String appName){
		if(appName.equals("gallery"))
		{
			if (galleryApp == null)
			{
				galleryApp = new GalleryApplication() ;
				//				Ressources.GALLERYAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			activeApp = galleryApp ;	


		}
		if(appName.equals("contact"))
		{
			if (contactApp == null)
			{
				contactApp = new ContactApplication() ;
				//				Ressources.CONTACTAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			activeApp = contactApp ;

		}
		if(appName.equals("tictactoe"))
		{
			if (tictactoeApp == null)
			{
				tictactoeApp = new TicTacToeApplication() ;
				//				Ressources.TICTACTOEAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			activeApp = tictactoeApp ;
		}
		if(appName.equals("home"))
		{
			if (homeApp == null)
			{
				homeApp = new HomeApplication() ;
				//				Ressources.TICTACTOEAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			activeApp = homeApp ;

		}
		SmartPhone.reloadCenterPanel();
	}

	public static JPanel getActivePanel()
	{
		return activeApp.getActivePanel() ;
	}

	public static void removeActivePanel()
	{
		activeApp.removePanel(getActivePanel());
	}

	public static void removeSpecificPanel(JPanel panel)
	{
		activeApp.removePanel(panel);
	}

	public static void removeApp(String appName) 
	{
		if(appName.equals("gallery")) galleryApp = null ;
		if(appName.equals("contact")) contactApp = null ;
		if(appName.equals("tictactoe")) tictactoeApp = null ;
//		Ressources.MAINFRAME.reloadCenterPanel();
	}
	
	public static boolean isAppActive(String appName)
	{
		boolean answer = false;
		if(appName.equals("gallery") && galleryApp != null) answer = true ;
		if(appName.equals("contact") && contactApp != null) answer = true ;
		if(appName.equals("tictactoe") && tictactoeApp != null) answer = true ;
		return answer ;
	}
	
	public static void addPanel(JPanel panel)
	{
		activeApp.addPanel(panel);
	}


}
