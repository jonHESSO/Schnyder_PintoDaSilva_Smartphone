/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 15, 2017
 */

package app_gallery;

import java.io.Serializable;
import java.util.* ;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PictureList.
 * Contains a list of pictures used by the gallery
 */
public class PictureList implements Serializable
{
	
	/** The picture list. */
	protected List<Picture> pictureList = new ArrayList<Picture>() ;
	
	/**
	 * Adds the picture.
	 *
	 * @param picture the picture
	 */
	public void addPicture(Picture picture)
	{
		pictureList.add(picture) ;
	}
	
	/**
	 * Gets the icon list.
	 *
	 * @return the icon list
	 */
	public ArrayList<ImageIcon> getIconList()
	{
		ArrayList<ImageIcon> iconList = new ArrayList<ImageIcon>() ;
		for (int i = 0; i < pictureList.size(); i++)
		{
			iconList.add(pictureList.get(i).getIcon()) ;
		}
		return iconList ;
	}
	
	/**
	 * Gets the picture.
	 *
	 * @param index the index
	 * @return the picture
	 */
	public Picture getPicture(int index)
	{
		return this.pictureList.get(index) ;
	}

}
