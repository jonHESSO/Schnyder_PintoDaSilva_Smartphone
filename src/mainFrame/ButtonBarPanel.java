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

public class ButtonBarPanel extends JPanel
{
	private JButton homeButton ;
	private JButton returnButton ;
	private JButton multitaskButton ;
	private boolean multitaskIsOpen ;


	public ButtonBarPanel()
	{

		setPreferredSize(Ressources.BUTTONBAR_PANEL_DIMENSION);

		homeButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/home.png"));
		returnButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/return.png")) ;
		multitaskButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/multitask.png")) ;

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

		homeButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;
				Ressources.MAINFRAME.reloadCenterPanel();
			}
		});

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

	class MultiTaskPanel extends JPanel
	{
		JButton galleryButton ;
		JButton contactButton ;
		JButton tictactoeButton ;
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
		}

		class MultiTaskListener implements ActionListener
		{

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
				}
				multitaskIsOpen = false ;
				Ressources.MAINFRAME.reloadCenterPanel();
			}

		}
	}


}
