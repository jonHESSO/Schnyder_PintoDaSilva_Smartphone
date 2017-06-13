/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_gallery;

import app_contacts.ContactListPanel;
import ressources.DefaultApplication;

/**
 * The Class GalleryApplication.
 * Used to launch a new instance of the Gallery
 * Creates a new GalleryPanel when instantiated
 */
public class GalleryApplication extends DefaultApplication
{

	public GalleryApplication()
	{
		addPanel(new GalleryPanel()) ;
	}
}
