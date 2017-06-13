/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_contacts;

import app_gallery.GalleryIconListPanel;
import app_gallery.Picture;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactSelectPicturePanel.
 * It extends the GalleryIconListPanel
 * and allows the contact modify/create panels
 * to add a picture to the contact
 */
public class ContactSelectPicturePanel extends GalleryIconListPanel
{

	/**
	 * The selection Action signals the parent panel that an icon
	 * has been selected, and returns the selected picture.
	 */
	@Override
	protected void selectionAction()
	{
		System.out.println("Picture clicked");
		//indique une modification des propriétés de l'image
		ContactSelectPicturePanel.this.firePropertyChange("selectedPicture", null, selectedIcon);
		
	}

}
