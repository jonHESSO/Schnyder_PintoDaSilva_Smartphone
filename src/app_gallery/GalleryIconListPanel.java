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

import jdk.nashorn.internal.scripts.JO;
import ressources.Ressources;

// TODO: Auto-generated Javadoc
/**
 * The Class GalleryIconListPanel.
 */
public abstract class GalleryIconListPanel extends JPanel
{
	
	/** The file directory. */
	private File fileDirectory = new File(Ressources.GALLERY_DIRECTORY) ;
	
	/** The pictures. */
	protected List<Picture> pictures ;
	
	/** The icons. */
	List<JLabel> icons ;
	
	/** The selected icon. */
	public ImageIcon selectedIcon ;
	
	/** The selected icon's index. */
	protected int selectedIndex ;
	

	/**
	 * Instantiates a new gallery icon list panel.
	 */
	public GalleryIconListPanel()
	{
		setPreferredSize(Ressources.DEFAULT_APP_JPANEL_DIMENSION);
		setLayout(new BorderLayout()) ;
		//calls the method for fetching icons
		fetchIcons() ;

	}

	/**
	 * Gets the picture list from the directory
	 *
	 * @return the picture list
	 */
	private List<Picture> getPictureList(){
		File [] files = fileDirectory.listFiles() ;
		List<Picture> pictures = new ArrayList<Picture>()  ;
		for (int i = 0; i < files.length; i++)
		{
			try
			{
				//check if file is of type "image"
				String fileType = Files.probeContentType(files[i].toPath()) ;
				if (fileType!=null && fileType.contains("image")==true){
					try{
						//creates a new temporary Picture object from the current tested file
						Picture tPicture = new Picture(files[i]) ;
						//adds it to the picture list
						pictures.add(tPicture);
						}
						catch (Exception e)
						{
							//if the image can't be read
							JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Image corrompue : "+files[i].toPath());
						}
				}
			} catch (IOException e1)
			{
				//since we can't even read it, we don't bother dealing with it
			}
			
		}
		
		return pictures ;
	}

	/**
	 * Gets the index of the selected picture.
	 *
	 * @param icon the icon
	 * @return the index
	 */
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

	/**
	 * Fetch icons.
	 */
	protected void fetchIcons()
	{
		//new thread, since loading icons can take some time
		Thread thread = new Thread(new Task()
		{

			@Override
			public void run()
			{
				
				//adds a "loading" panel untill all the icons are loaded
				JLabel loading = new JLabel("Loading") ;
				loading.setHorizontalAlignment(SwingConstants.CENTER);;
				add(loading,BorderLayout.CENTER) ;
				//creats a new panel containing the icons
				JPanel iconPanel = new JPanel() ;
				iconPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
				iconPanel.setPreferredSize(Ressources.GALLERY_APP_ICONPANEL);

				//get the picture list
				pictures = getPictureList() ;
				//asks the user if he wants to add pictures to the gallery if it's empty
				if(pictures.isEmpty()==true)
				{
					removeAll();
					add(loading,BorderLayout.CENTER) ;
					int ret = JOptionPane.showConfirmDialog(Ressources.MAINFRAME, "Aucune image, voulez-vous en ajouter ?") ;
					if (ret == JOptionPane.YES_OPTION) 
					{
						//asks the user to chose pictures to copy to the gallery
						copyPictures() ;
						//re-gets the picture list
						pictures = getPictureList() ;
					}
					
				}
				
				//generates icons from the picture list
				icons = new ArrayList<JLabel>() ;
				for (int i = 0; i < pictures.size(); i++)
				{

					Picture tPicture = (Picture) pictures.get(i) ;
					ImageIcon tIcon = tPicture.getIcon() ;
					icons.add(new JLabel(tIcon)) ;	
					//adds a mouse listener to the panel, setting the clicked icon and the icon's index
					iconPanel.add(icons.get(i)).addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							selectedIcon = (ImageIcon) ((JLabel) e.getSource()).getIcon() ;
							selectedIndex = getIndex(e.getSource()) ;
							//launches the selectionAction()
							selectionAction() ;					
						}
					}) ;

				}
				//refreshes the panel
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
				//well, don't do anything. A blank pannel is fine too.
			}
		}) ;

		//surprisingly, starts the thread
		thread.start();
		



	}
	
	/**
	 * Copy pictures.
	 * used when adding pictures to the empty gallery
	 */
	private void copyPictures()
	{
		//opens a new filechooser
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true) ;
		int returnValue = chooser.showOpenDialog(Ressources.MAINFRAME);
		File[] files = null ;
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	 files = chooser.getSelectedFiles();
        	 System.out.println("selected files : "+files.length);
        	 //copy each selected file to the gallery's directory
        	 for (int j = 0; j < files.length; j++)
     		{
     	    	try
     			{
     	    		String pathDestination = Ressources.GALLERY_DIRECTORY+"/"+files[j].getName() ;
     				Files.copy(files[j].toPath(), Paths.get(pathDestination));
     			} catch (IOException e)
     			{
     				//oohhh noooooes, could not copy teh flie
     				JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Impossible de copiter le fichier "+files[j].getParent());
     			}
     		}
        }
	   
	    
		
	}
	
	
	

	/**
	 * Selection action.
	 */
	protected abstract void selectionAction() ;



}
