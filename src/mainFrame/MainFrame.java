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
import ressources.DefaultApplication;
import ressources.Ressources;

public class MainFrame extends JFrame
{
	JPanel centerPanel ;	

	public MainFrame()
	{
		Ressources.HOMEAPP = new HomeApplication() ;
		Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;

		centerPanel = new JPanel() ;
		centerPanel.setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		reloadCenterPanel() ;


		setSize(Ressources.DEFAULT_FRAME_DIMENSION);
		//		add(new GalleryPanel()) ;
		//		add(new ContactCreationJpanel()) ;
		//		add(new TicTacToePanel()) ;

		add(new StatusBarPanel(),BorderLayout.NORTH) ;
		add(new ButtonBarPanel(),BorderLayout.SOUTH) ;
		add(centerPanel,BorderLayout.CENTER) ;
	}

	public void reloadCenterPanel()
	{
		centerPanel.removeAll();
		
//		JPanel activePanel = Ressources.ACTIVEAPPLICATION.getActivePanel() ;
//		System.out.println(Ressources.ACTIVEAPPLICATION);
		
//		activePanel.addPropertyChangeListener(new PropertyChangeListener(){
//
//			@Override
//			public void propertyChange(PropertyChangeEvent evt)
//			{
//				if(evt.getPropertyName().equals("activeApp")||evt.getPropertyName().equals("activePanelChanged"))
//				{
////					System.out.println("Halp");
//					reloadCenterPanel() ;
////					JFrame jf = new JFrame() ;
////					jf.add((JPanel)Ressources.ACTIVEAPPLICATION.getActivePanel()) ;
////					jf.setVisible(true);
//				}
//			}
//		});

		centerPanel.add(Ressources.ACTIVEAPPLICATION.getActivePanel()) ;
		centerPanel.revalidate();
		centerPanel.repaint();
		revalidate();
		repaint();
	}
	
	public void addCustomPanel(JPanel panel)
	{
		centerPanel.removeAll();
		centerPanel.add(panel) ;
		centerPanel.revalidate();
		centerPanel.repaint();
		revalidate();
		repaint();
	}
	
//	public void activeApplicationChanged(DefaultApplication app){
//		DefaultApplication previousApp = Ressources.ACTIVEAPPLICATION ;
//		Ressources.ACTIVEAPPLICATION = app ;
//		firePropertyChange("activeAppChanged", previousApp, app);
//	}

}
