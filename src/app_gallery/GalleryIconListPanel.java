/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_gallery;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ressources.Ressources;

public abstract class GalleryIconListPanel extends JPanel
{
	private File fileDirectory = new File(ressources.Ressources.GALLERY_DIRECTORY) ;
	protected List<Picture> pictures ;
	List<JLabel> icons ;
	public ImageIcon selectedPicture ;
	
	public GalleryIconListPanel()
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
	
	protected void fetchIcons()
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
					selectionAction(pictures.get(getIndex(e.getSource()))) ;
					selectedPicture = pictures.get(getIndex(e.getSource())).getIcon() ;
				}
			}) ;
		}
		add(iconPanel,BorderLayout.NORTH) ;
		revalidate() ;
		repaint() ;
		
	}
	
	protected abstract void selectionAction(Picture selectedPicture) ;

	
	
}
