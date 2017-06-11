/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 10, 2017
 */

package app_home;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import app_contacts.ContactApplication;
import app_gallery.GalleryApplication;
import app_tictactoe.TicTacToeApplication;
import ressources.DefaultApplication;
import ressources.DesignButton;
import ressources.Ressources;

public class HomePanel extends JPanel
{
	private JButton galleryButton ;
	private JButton contactButton ;
	private JButton tictactoeButton ;
	
	public HomePanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		galleryButton = new DesignButton(new ImageIcon("data/Icons/App_Icons/Gallery.png")) ;
		contactButton = new DesignButton(new ImageIcon("data/Icons/App_Icons/Contacts.png")) ;
		tictactoeButton = new DesignButton(new ImageIcon("data/Icons/App_Icons/Morpion.png")) ;
		
		ActionListener listener = new ButtonListener() ;
		
		galleryButton.addActionListener(listener);
		contactButton.addActionListener(listener);
		tictactoeButton.addActionListener(listener);
		
		add(galleryButton) ;
		add(contactButton) ;
		add(tictactoeButton) ;
		
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent ae)
		{
//			DefaultApplication oldValue = Ressources.ACTIVEAPPLICATION ;
			if(ae.getSource()==galleryButton)
			{
				if (Ressources.GALLERYAPP == null)
				{
					Ressources.GALLERYAPP = new GalleryApplication() ;
//					Ressources.GALLERYAPP.addPropertyChangeListener(new ActivePanelListener());
				}
				Ressources.ACTIVEAPPLICATION = Ressources.GALLERYAPP ;	
				Ressources.MAINFRAME.reloadCenterPanel();

			}
			if(ae.getSource()==contactButton)
			{
				if (Ressources.CONTACTAPP == null)
				{
					Ressources.CONTACTAPP = new ContactApplication() ;
//					Ressources.CONTACTAPP.addPropertyChangeListener(new ActivePanelListener());
				}
				Ressources.ACTIVEAPPLICATION = Ressources.CONTACTAPP ;
				Ressources.MAINFRAME.reloadCenterPanel();
				
			}
			if(ae.getSource()==tictactoeButton)
			{
				if (Ressources.TICTACTOEAPP == null)
				{
					Ressources.TICTACTOEAPP = new TicTacToeApplication() ;
//					Ressources.TICTACTOEAPP.addPropertyChangeListener(new ActivePanelListener());
				}
				Ressources.ACTIVEAPPLICATION = Ressources.TICTACTOEAPP ;
				Ressources.MAINFRAME.reloadCenterPanel();
				
			}
			
//			firePropertyChange("activeAppChanged", oldValue, Ressources.ACTIVEAPPLICATION);
		}
		
	}
	
//	class ActivePanelListener implements PropertyChangeListener
//	{
//
//		@Override
//		public void propertyChange(PropertyChangeEvent evt)
//		{
//			if (evt.getPropertyName().equals("panelChanged"))
//			{
//				Ressources.MAINFRAME.reloadCenterPanel();
//			}
//		}
//		
//	}

}
