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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			try{
			Picture tPicture = new Picture(files[i]) ;
			pictures.add(tPicture);
			}
			catch (Exception e)
			{
				//not a picture, so we don't care
			}
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
				if(pictures.isEmpty()==true)
				{
					removeAll();
					add(loading,BorderLayout.CENTER) ;
					int ret = JOptionPane.showConfirmDialog(Ressources.MAINFRAME, "Aucune image, voulez-vous en ajouter ?") ;
					if (ret == JOptionPane.YES_OPTION) 
					{
						copyPictures() ;
						pictures = getPictureList() ;
					}
					
				}
				
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
	
	private void copyPictures()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true) ;
		int returnValue = chooser.showOpenDialog(Ressources.MAINFRAME);
		File[] files = null ;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	 files = chooser.getSelectedFiles();
        	 System.out.println("selected files : "+files.length);
        	 for (int j = 0; j < files.length; j++)
     		{
     	    	try
     			{
     	    		String pathDestination = Ressources.GALLERY_DIRECTORY+"/"+files[j].getName() ;
     				Files.copy(files[j].toPath(), Paths.get(pathDestination));
     			} catch (IOException e)
     			{
     				e.printStackTrace();
     			}
     		}
        }
	   
	    
		
	}
	
	
	

	protected abstract void selectionAction() ;



}
