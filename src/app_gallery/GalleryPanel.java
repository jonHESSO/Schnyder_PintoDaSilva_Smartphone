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
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ressources.Ressources;

public class GalleryPanel extends GalleryIconListPanel
{
	
	
	public void deletePicture(Picture currentPicture)
	{
		File file = currentPicture.getFile() ;
		file.delete() ;
		fetchIcons() ;
	}
	
	@Override
	protected  void selectionAction(Picture selectedPicture){
		JFrame f = new JFrame() ;
		PicturePanel p = new PicturePanel(selectedPicture,GalleryPanel.this);
		f.add(p) ;
		f.pack();
		f.setVisible(true);
	}
	
	
	
}
	
	