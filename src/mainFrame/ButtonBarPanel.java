/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 5, 2017
 */

package mainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.istack.internal.NotNull;

import app_home.HomeApplication;
import app_home.HomePanel;
import ressources.DesignButton;
import ressources.Ressources;

/**
 * The Class ButtonBarPanel.
 */
public class ButtonBarPanel extends JPanel
{
	
	/** The home button. */
	private JButton homeButton ;
	
	/** The return button. */
	private JButton returnButton ;
	
	/** The multitask button. */
	private JButton multitaskButton ;
	
	/** The multitask is open. */
	private boolean multitaskIsOpen ;


	/**
	 * Instantiates a new button bar panel.
	 */
	public ButtonBarPanel()
	{

		setPreferredSize(Ressources.BUTTONBAR_PANEL_DIMENSION);

		homeButton = new DesignButton(new ImageIcon(Ressources.DATAPATH+"data/Icons/toolBar_Icons/home.png"));
		returnButton = new DesignButton(new ImageIcon(Ressources.DATAPATH+"data/Icons/toolBar_Icons/return.png")) ;
		multitaskButton = new DesignButton(new ImageIcon(Ressources.DATAPATH+"data/Icons/toolBar_Icons/multitask.png")) ;

		//adds a listener on the return button
		//it closes the active panel, unless there is no panel to close (home)
		returnButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(multitaskIsOpen == true)
				{
					Ressources.MAINFRAME.reloadCenterPanel();
					multitaskIsOpen = false ;
				}
				else
				{
					if(Ressources.ACTIVEAPPLICATION.getActivePanel() instanceof HomePanel)
					{
						System.out.println("Halp");
					}
					else{
						Ressources.ACTIVEAPPLICATION.removePanel(Ressources.ACTIVEAPPLICATION.getActivePanel());
					}
				}
			}
		});

		//adds a listener to the home button
		//retuns to the homepanel without closing the active applications/panels
		homeButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;
				Ressources.MAINFRAME.reloadCenterPanel();
			}
		});

		//adds a listener to the multitask button
		//shows the open apps and allows to launch them
		//also displays a "close all" button, to close them all  and in the darkness bind them
		multitaskButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				multitaskIsOpen = true ;
				Ressources.MAINFRAME.addCustomPanel(new MultiTaskPanel()) ;
			}
		});
		add(returnButton);
		add(homeButton) ;
		add(multitaskButton) ;

	}

	/**
	 * The Class MultiTaskPanel. Has buttons to reopen already
	 * openened apps, and a button to close everything
	 */
	class MultiTaskPanel extends JPanel
	{
		
		/** The gallery button. */
		JButton galleryButton ;
		
		/** The contact button. */
		JButton contactButton ;
		
		/** The tictactoe button. */
		JButton tictactoeButton ;
		
		/** The close all button. */
		JButton closeAllButton ;
		
		/**
		 * Instantiates a new multi task panel.
		 */
		public MultiTaskPanel(){
			super() ;
			ActionListener buttonListener = new MultiTaskListener() ;
			if (Ressources.GALLERYAPP != null)
			{
				galleryButton = new JButton("Gallery") ;
				galleryButton.addActionListener(buttonListener);
				add(galleryButton) ;
			}
			if (Ressources.CONTACTAPP != null)
			{
				contactButton = new JButton("Contact") ;
				contactButton.addActionListener(buttonListener);
				add(contactButton) ;
			}
			if (Ressources.TICTACTOEAPP != null)
			{
				tictactoeButton = new JButton("Morpion") ;
				tictactoeButton.addActionListener(buttonListener);
				add(tictactoeButton) ;
			}
			closeAllButton = new JButton("Tout fermer") ;
			closeAllButton.addActionListener(buttonListener);
			add(closeAllButton) ;
			
		}

		/**
		 * the listener for the buttons, to know what app to open
		 */
		class MultiTaskListener implements ActionListener
		{

			/**
			 * Action performed.
			 *
			 * @param e the event
			 */
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String source = ((JButton)e.getSource()).getLabel() ;
				switch (source)
				{
				case "Gallery" :
					Ressources.ACTIVEAPPLICATION = Ressources.GALLERYAPP ;
					break ;
				case "Contact" :
					Ressources.ACTIVEAPPLICATION = Ressources.CONTACTAPP ;
					break ;
				case "Morpion" :
					Ressources.ACTIVEAPPLICATION = Ressources.TICTACTOEAPP ;
					break ;	
				case "Tout fermer" :
					Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;
					Ressources.GALLERYAPP = null ;
					Ressources.CONTACTAPP = null ;
					Ressources.TICTACTOEAPP = null ;
				}
				multitaskIsOpen = false ;
				Ressources.MAINFRAME.reloadCenterPanel();
			}

		}
	}


}
