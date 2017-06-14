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
import ressources.AppManager;
import ressources.DesignButton;
import ressources.Ressources;
import ressources.SmartPhone;

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
					SmartPhone.reloadCenterPanel();
					multitaskIsOpen = false ;
				}
				else
				{
					if(AppManager.getActivePanel() instanceof HomePanel)
					{
						System.out.println("Halp");
					}
					else{
						AppManager.removeActivePanel();
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
				AppManager.setActiveApp("home");
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
			if (AppManager.isAppActive("gallery") == true)
			{
				galleryButton = new JButton("Gallery") ;
				galleryButton.addActionListener(buttonListener);
				add(galleryButton) ;
			}
			if (AppManager.isAppActive("contact") == true)
			{
				contactButton = new JButton("Contact") ;
				contactButton.addActionListener(buttonListener);
				add(contactButton) ;
			}
			if (AppManager.isAppActive("morpion") == true)
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
					AppManager.setActiveApp("gallery"); ;
					break ;
				case "Contact" :
					AppManager.setActiveApp("contact"); ;
					break ;
				case "Morpion" :
					AppManager.setActiveApp("tictactoe") ;
					break ;	
				case "Tout fermer" :
					AppManager.removeApp("gallery");
					AppManager.removeApp("contact");
					AppManager.removeApp("tictactoe");
					AppManager.setActiveApp("home");
				}
				multitaskIsOpen = false ;
//				Ressources.MAINFRAME.reloadCenterPanel();
			}

		}
	}


}
