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
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.jmx.snmp.tasks.Task;

import ressources.Ressources;

public abstract class GalleryIconListPanel extends JPanel
{
	private File fileDirectory = new File(ressources.Ressources.GALLERY_DIRECTORY) ;
	protected List<Picture> pictures ;
	List<JLabel> icons ;
	public ImageIcon selectedIcon ;
	protected int selectedIndex ;
	

	public GalleryIconListPanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new BorderLayout()) ;
		

		//		setLayout(new FlowLayout()) ;
		fetchIcons() ;

	}

	private List<Picture> getPictureList(){
		File [] files = fileDirectory.listFiles() ;
		List<Picture> pictures = new ArrayList<Picture>()  ;
		for (int i = 0; i < files.length; i++)
		{
			Picture tPicture = new Picture(files[i]) ;
			pictures.add(tPicture);
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
		Thread thread = new Thread(new Task()
		{

			@Override
			public void run()
			{
				JLabel loading = new JLabel("Loading") ;
				loading.setHorizontalAlignment(SwingConstants.CENTER);;
				add(loading,BorderLayout.CENTER) ;
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
							selectedIcon = (ImageIcon) ((JLabel) e.getSource()).getIcon() ;
							selectedIndex = getIndex(e.getSource()) ;
							selectionAction() ;					
						}
					}) ;

				}
				System.out.println("finished loading");
				if(getComponentCount()>0)
				{
					removeAll();
				}
				add(iconPanel,BorderLayout.CENTER) ;
				revalidate() ;
				repaint() ;

			}

			@Override
			public void cancel()
			{
			}
		}) ;


		thread.start();



	}
	

	protected abstract void selectionAction() ;



}
