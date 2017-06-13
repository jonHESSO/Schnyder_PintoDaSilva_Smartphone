/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 19, 2017
 */

package app_gallery;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ressources.Ressources;

// TODO: Auto-generated Javadoc
/**
 * The Class GalleryPanel.
 * This class contains a list of icons generated from the pictures in the gallery directory
 */
public class GalleryPanel extends GalleryIconListPanel
{
	
	
	/**
	 * Delete picture.
	 *
	 * @param currentPicture the current picture
	 */
	public void deletePicture(Picture currentPicture)
	{
		File file = currentPicture.getFile() ;
		file.delete() ;
		fetchIcons() ;
	}
	
	/**
	 * Selection action.
	 * Opens the picture in full screen (well, the smartphone's screen, so pretty small)
	 */
	@Override
	protected  void selectionAction(){
		JPanel selectedPicturePanel = new PicturePanel(pictures.get(selectedIndex));
		//adds a listener on the new panel to catch the event of deletion of the picture
		selectedPicturePanel.addPropertyChangeListener(new PropertyChangeListener()
		{
			
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				//deletes the picture and removes the fullscreen panel if the picture has been deleted
				if(evt.getPropertyName().equals("pictureDeleted"))
				{
					deletePicture(pictures.get(selectedIndex)) ;
					Ressources.GALLERYAPP.removePanel(selectedPicturePanel);
				}
					
			}
		});
		Ressources.GALLERYAPP.addPanel(selectedPicturePanel);
	}
	
	
	
}
	
	