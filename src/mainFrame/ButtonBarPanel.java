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

import ressources.DesignButton;
import ressources.Ressources;

public class ButtonBarPanel extends JPanel
{
	private JButton homeButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/home.png"));
	private JButton returnButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/return.png")) ;
	private JButton multitaskButton = new DesignButton(new ImageIcon("data/Icons/toolBar_Icons/multitask.png")) ;
	
	
	public ButtonBarPanel()
	{
		
		setPreferredSize(Ressources.BUTTONBAR_PANEL_DIMENSION);
		add(returnButton);
		add(homeButton) ;
		add(multitaskButton) ;
		
	}
	
}
