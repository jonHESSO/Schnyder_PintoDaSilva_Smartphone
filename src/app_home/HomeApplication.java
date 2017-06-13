/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_home;

import javax.swing.JPanel;

import ressources.DefaultApplication;

/**
 * The Class HomeApplication.
 * Behaves a little differently than the DefaultApplication, thus the many @Override
 */
public class HomeApplication extends DefaultApplication
{
	
	/** The home panel. */
	HomePanel homePanel ;
	
	/**
	 * Instantiates a new home application.
	 */
	public HomeApplication()
	{
		//adds a new homepanel, wich will exist until the programm is closed
		homePanel = new HomePanel() ;
	}
	
	/**
	 * Adds the panel.
	 * does nothing, since the only active panel is the homepanel
	 *
	 * @param panel the panel
	 */
	@Override
	public void addPanel(JPanel panel)
	{
	}
	
	/**
	 * Removes the panel.
	 * Does nothing, since we don't ever want to remove the homepanel
	 *
	 * @param panel the panel
	 */
	@Override
	public void removePanel(JPanel panel)
	{
	}
	
	/**
	 * Gets the active panel.
	 * the activePanel is always the homepanel
	 *
	 * @return the active panel
	 */
	@Override
	public JPanel getActivePanel()
	{
		return homePanel ;
	}

}
