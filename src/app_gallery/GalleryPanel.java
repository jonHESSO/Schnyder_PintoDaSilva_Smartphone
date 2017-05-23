/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 19, 2017
 */

package app_gallery;

import java.awt.FlowLayout;
import java.io.File;
import java.util.*;

import javax.swing.*;

import ressources.Ressources;

public class GalleryPanel extends JPanel
{
	private File fileDirectory = new File(ressources.Ressources.GALLERY_DIRECTORY) ;
	public GalleryPanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
//		setLayout(new FlowLayout()) ;
		List pictures = getPictureList() ;
		System.out.println(pictures.size());
		for (int i = 0; i < pictures.size(); i++)
		{
			Picture tPicture = (Picture) pictures.get(i) ;
			ImageIcon tIcon = tPicture.getIcon() ;
			add(new JLabel(tIcon)) ;
		}
	}
	
	private List<Picture> getPictureList(){
		File [] files = fileDirectory.listFiles() ;
		List<Picture> pictures = new ArrayList<Picture>()  ;
		for (int i = 0; i < files.length; i++)
		{
			Picture tPicture = new Picture(files[i]) ;
			System.out.println(tPicture.toString()) ;
			pictures.add(new Picture(files[i]));
		}
		return pictures ;
	}
	
}
	
	