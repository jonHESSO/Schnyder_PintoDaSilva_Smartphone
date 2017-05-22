/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 18, 2017
 */

package mainFrame;

import javax.swing.*;

import app_contacts.*;
import app_gallery.*;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		add(new GalleryPanel()) ;
		add(new ContactCreationJpanel()) ;
		pack() ;
	}

}
