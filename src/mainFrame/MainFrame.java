/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 18, 2017
 */

package mainFrame;

import java.awt.BorderLayout;

import javax.swing.*;

import app_contacts.*;
import app_gallery.*;
import app_tictactoe.*;
import ressources.Ressources;

public class MainFrame extends JFrame
{
	JPanel centerPanel ;
	public MainFrame()
	{
		setSize(Ressources.DEFAULT_FRAME_DIMENSION);
//		add(new GalleryPanel()) ;
//		add(new ContactCreationJpanel()) ;
//		add(new TicTacToePanel()) ;
		
		add(new StatusBarPanel(),BorderLayout.NORTH) ;
		add(new ButtonBarPanel(),BorderLayout.SOUTH) ;
	}

}
