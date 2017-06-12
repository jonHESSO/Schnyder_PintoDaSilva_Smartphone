/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_contacts;

import app_gallery.GalleryIconListPanel;
import app_gallery.Picture;

public class ContactSelectPicturePanel extends GalleryIconListPanel
{

	@Override
	protected void selectionAction()
	{
		System.out.println("Picture clicked");
		//indique une modification des propriétés de l'image
		ContactSelectPicturePanel.this.firePropertyChange("selectedPicture", null, selectedIcon);
		
	}

}
