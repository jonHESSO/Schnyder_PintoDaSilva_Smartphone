/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 5, 2017
 */

package app_gallery;

import javax.swing.JFrame;

public class GalleryTestFrame extends JFrame
{
	public GalleryTestFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new GalleryPanel()) ;
		pack() ;
	}

}
