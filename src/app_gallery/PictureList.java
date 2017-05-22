/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 15, 2017
 */

package app_gallery;

import java.io.Serializable;
import java.util.* ;

import javax.swing.*;

public class PictureList implements Serializable
{
	protected List<Picture> pictureList = new ArrayList<Picture>() ;
	
	public void addPicture(Picture picture)
	{
		pictureList.add(picture) ;
	}
	
	public ArrayList<ImageIcon> getIconList()
	{
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>() ;
		for (int i = 0; i < pictureList.size(); i++)
		{
			iconList.add(pictureList.get(i).getIcon()) ;
		}
		return iconList ;
	}
	
	public Picture getPicture(int i)
	{
		return this.pictureList.get(i) ;
	}

}
