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
	protected void selectionAction(Picture selectedPicture)
	{
		this.selectedPicture = selectedPicture.getIcon() ;
		System.out.println("Picture clicked");
		ContactSelectPicturePanel.this.firePropertyChange("selectedPicture", null, selectedPicture.getIcon());
		
	}

}
