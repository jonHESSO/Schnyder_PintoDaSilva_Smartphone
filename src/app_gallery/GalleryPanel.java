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

public class GalleryPanel extends JPanel
{
	private File fileDirectory = new File(ressources.Ressources.GALLERY_DIRECTORY) ;
	List<Picture> pictures ;
	List<JLabel> icons ;
	
	public GalleryPanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		
		
//		setLayout(new FlowLayout()) ;
		fetchIcons() ;
		
	}
	
	private List<Picture> getPictureList(){
		File [] files = fileDirectory.listFiles() ;
		List<Picture> pictures = new ArrayList<Picture>()  ;
		for (int i = 0; i < files.length; i++)
		{
			Picture tPicture = new Picture(files[i]) ;
			pictures.add(new Picture(files[i]));
		}
		return pictures ;
	}
	
	private int getIndex(Object icon)
	{
		int index = 0 ;
		for (int i = 0; i < icons.size(); i++)
		{
			if (icon==icons.get(i))
				index = i ;
		}
		return index ;
		
	}
	
	private void fetchIcons()
	{
		if(getComponentCount()>0)
		{
			removeAll();
		}
		JPanel iconPanel = new JPanel() ;
		iconPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		iconPanel.setPreferredSize(Ressources.GALLERY_APP_ICONPANEL);
		
		
		pictures = getPictureList() ;
		icons = new ArrayList<JLabel>() ;
		for (int i = 0; i < pictures.size(); i++)
		{
			Picture tPicture = (Picture) pictures.get(i) ;
			ImageIcon tIcon = tPicture.getIcon() ;
			icons.add(new JLabel(tIcon)) ;	
			iconPanel.add(icons.get(i)).addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					JFrame f = new JFrame() ;
					PicturePanel p = new PicturePanel(pictures.get(getIndex(e.getSource())),GalleryPanel.this);
					f.add(p) ;
					f.pack();
					f.setVisible(true);
				}
			}) ;
		}
		add(iconPanel,BorderLayout.NORTH) ;
		revalidate() ;
		repaint() ;
		
	}
	
	public void deletePicture(Picture currentPicture)
	{
		File file = currentPicture.getFile() ;
		file.delete() ;
		fetchIcons() ;
	}
	
	
	
}
	
	