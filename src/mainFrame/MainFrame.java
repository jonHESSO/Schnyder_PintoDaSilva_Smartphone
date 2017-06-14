/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 18, 2017
 */

package mainFrame;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import ressources.Ressources;

import javax.swing.*;

import app_contacts.*;
import app_gallery.*;
import app_home.HomeApplication;
import app_tictactoe.*;
import ressources.AppManager;
import ressources.DefaultApplication;
import ressources.Ressources;

/**
 * The Class MainFrame. It starts with loading the homeapp
 * It contains a method for reloading the center panel
 */
public class MainFrame extends JFrame
{
	
	/** The center panel. */
	JPanel centerPanel ;	

	/**
	 * Instantiates a new main frame.
	 */
	public MainFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		Ressources.HOMEAPP = new HomeApplication() ;
//		Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;

		centerPanel = new JPanel() ;
		centerPanel.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		refreshCenterPanel() ;


		setSize(Ressources.DEFAULT_FRAME_DIMENSION);
;

		add(new StatusBarPanel(),BorderLayout.NORTH) ;
		add(new ButtonBarPanel(),BorderLayout.SOUTH) ;
		add(centerPanel,BorderLayout.CENTER) ;
	}

	/**
	 * Reload center panel.
	 */
	public void refreshCenterPanel()
	{
		centerPanel.removeAll();

		centerPanel.add(AppManager.getActivePanel()) ;
		centerPanel.revalidate();
		centerPanel.repaint();
		revalidate();
		repaint();
	}
	
	/**
	 * Adds the custom panel. Mainly used for the multitask panel
	 *
	 * @param panel the panel
	 */
	public void addCustomPanel(JPanel panel)
	{
		centerPanel.removeAll();
		centerPanel.add(panel) ;
		centerPanel.revalidate();
		centerPanel.repaint();
		revalidate();
		repaint();
	}

}
