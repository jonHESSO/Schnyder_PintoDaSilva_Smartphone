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

public class MainFrame extends JFrame
{
	public MainFrame()
	{
//		add(new GalleryPanel()) ;
//		add(new ContactCreationJpanel()) ;
//		add(new TicTacToePanel()) ;
		add(new StatusBarPanel(),BorderLayout.NORTH) ;
		add(new ButtonBarPanel(),BorderLayout.SOUTH) ;
		pack() ;
	}

}
