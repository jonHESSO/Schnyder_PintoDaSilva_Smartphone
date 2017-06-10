/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 10, 2017
 */

package app_home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import app_contacts.ContactApplication;
import app_gallery.GalleryApplication;
import app_tictactoe.TicTacToeApplication;
import ressources.DefaultApplication;
import ressources.Ressources;

public class HomePanel extends JPanel
{
	private JButton galleryButton ;
	private JButton contactButton ;
	private JButton tictactoeButton ;
	
	public HomePanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		galleryButton = new JButton("gallery") ;
		contactButton = new JButton("Contact") ;
		tictactoeButton = new JButton("morpion") ;
		
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
			DefaultApplication oldValue = Ressources.ACTIVEAPPLICATION ;
			if(ae.getSource()==galleryButton)
			{
				if (Ressources.GALLERYAPP == null)
					Ressources.GALLERYAPP = new GalleryApplication() ;
				Ressources.ACTIVEAPPLICATION = Ressources.GALLERYAPP ;	
				Ressources.GALLERYAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			if(ae.getSource()==contactButton)
			{
				if (Ressources.CONTACTAPP == null)
					Ressources.CONTACTAPP = new ContactApplication() ;
				Ressources.ACTIVEAPPLICATION = Ressources.CONTACTAPP ;	
				Ressources.CONTACTAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			if(ae.getSource()==tictactoeButton)
			{
				if (Ressources.TICTACTOEAPP == null)
					Ressources.TICTACTOEAPP = new TicTacToeApplication() ;
				Ressources.ACTIVEAPPLICATION = Ressources.TICTACTOEAPP ;
				Ressources.TICTACTOEAPP.addPropertyChangeListener(new ActivePanelListener());
			}
			
			firePropertyChange("activeApp", oldValue, Ressources.ACTIVEAPPLICATION);
		}
		
	}
	
	class ActivePanelListener implements PropertyChangeListener
	{

		@Override
		public void propertyChange(PropertyChangeEvent evt)
		{
			if (evt.getPropertyName().equals("panelChanged"))
			{
				Ressources.MAINFRAME.reloadCenterPanel();
			}
		}
		
	}

}
