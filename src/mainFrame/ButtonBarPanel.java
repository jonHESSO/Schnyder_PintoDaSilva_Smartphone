/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 5, 2017
 */

package mainFrame;

import javax.swing.*;

import ressources.Ressources;

public class ButtonBarPanel extends JPanel
{
	private JButton homeButton = new JButton("home") ;
	private JButton returnButton = new JButton("return") ;
	
	public ButtonBarPanel()
	{
		setPreferredSize(Ressources.BUTTONBAR_PANEL_DIMENSION);
		add(homeButton) ;
		add(returnButton) ;
	}
	
}
