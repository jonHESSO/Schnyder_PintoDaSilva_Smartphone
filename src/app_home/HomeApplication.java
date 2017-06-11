/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_home;

import javax.swing.JPanel;

import ressources.DefaultApplication;

public class HomeApplication extends DefaultApplication
{
	HomePanel homePanel ;
	
	public HomeApplication()
	{
		homePanel = new HomePanel() ;
		addPanel(homePanel) ;
	}
	
	@Override
	public void addPanel(JPanel panel)
	{
		openPanels.add(panel) ;
	}
	
	@Override
	public void removePanel(JPanel panel)
	{
	}
	
	@Override
	public JPanel getActivePanel()
	{
		return homePanel ;
	}

}
