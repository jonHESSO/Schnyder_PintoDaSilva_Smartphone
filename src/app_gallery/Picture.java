/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 15, 2017
 */

package app_gallery;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.* ;

import javax.imageio.ImageIO;
import javax.swing.* ;

import ressources.Ressources;

// TODO: Auto-generated Javadoc
/*
 * This class creates picture objects used by the gallery app
 * It contains a method returning a cropped icon of the actual image
 */

/**
 * The Class Picture.
 */
public class Picture implements Serializable
{
	
	/** The file. */
	private File file ;
	
	/** The original height and width. */
	private final int originalWidth, originalHeight ;

	/**
	 * Instantiates a new picture.
	 * public constructor
	 * uses a file as a parameter
	 * and saves it with it's width and height
	 *
	 * @param file the file
	 */
	public Picture(File file)
	{
		//creates a buffered image from the file
		BufferedImage bImage = null ;
		if (file == null) throw new IllegalArgumentException("constructor argument is null");
		try
		{
			bImage = ImageIO.read(file) ;
		} catch (IOException ioe)
		{
			throw new IllegalArgumentException("could not open file: " + file, ioe) ;
		}
		if (bImage == null) throw new IllegalArgumentException("could not read file: " + file);
		//gets the image's width and height
		this.originalWidth = bImage.getWidth() ;
		this.originalHeight = bImage.getHeight() ;
		this.file = file ;
	}
	
	/**
	 * Gets the full picture.
	 *
	 * @return the picture as an ImageIcon, resized to the frame's dimensions
	 */
	public ImageIcon getPicture()
	{
		ImageIcon bImage = null ;
		int h, w ;
		int[] dimensions = getImageDimensions(this.originalHeight, this.originalWidth, Ressources.GALLERY_PICTURE_HEIGHT, Ressources.DEFAULT_APP_JPANEL_WIDTH, Ressources.DEFAULT_PICTURE_RATIO) ;
		w = dimensions[0] ;
		h = dimensions[1] ;
		try
		{
			Image scaledImage = ImageIO.read(file).getScaledInstance(w, h, Image.SCALE_SMOOTH) ;
			bImage = new ImageIcon(scaledImage) ;
			
		} catch (IOException ioe)
		{
//			throw new IllegalArgumentException("could not open file: " + file, ioe) ;
		}
		return bImage ;
	}

	/**
	 * Gets the icon in a 150x150 standardized size.
	 *
	 * @return the icon
	 */

	public ImageIcon getIcon(){

		ImageIcon icon = null;
		BufferedImage bImage = null ;
		
		try
		{
			bImage = ImageIO.read(file) ;
		} catch (IOException ioe)
		{
			throw new IllegalArgumentException("could not open file: " + file, ioe) ;
		}

		//parameters used for cropping
		int x, y, w, h;
		
		int[] dimensions = getIconCropDimensions(this.originalHeight, this.originalWidth) ;
		w = dimensions[0] ;
		h = dimensions[1] ;
		x = dimensions[2] ;
		y = dimensions[3] ;

		//actual cropping and resizing
		try{
			BufferedImage imgCropped = bImage.getSubimage(x, y, w, h);
			icon = new ImageIcon(imgCropped.getScaledInstance(Ressources.GALLERY_ICON_WIDTH, Ressources.GALLERY_ICON_HEIGHT, Image.SCALE_SMOOTH));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return icon ;
	}
	
	/**
	 * Gets the icon crop dimensions.
	 *
	 * @param height the height
	 * @param width the width
	 * @return the icon crop w/h dimensions and x/y positions
	 */
	public int[] getIconCropDimensions(int height, int width)
	{
		int w, h, x, y ;
		if(height > width)
		{
			w = width ;
			h = width ;
			x = 0;
			y = (int)(height*0.5 - width*0.5) ;
		}

		//if landscape or square
		else
		{
			w = height ;
			h = height ;
			x = (int)(width*0.5 - height*0.5) ;
			y = 0;
		}
		int[] dimensions = {w,h,x,y} ;
		return dimensions ;
	}
	
	/**
	 * Gets the image resized dimensions.
	 *
	 * @param height the height
	 * @param width the width
	 * @param maxHeight the max height
	 * @param maxWidth the max width
	 * @return the image dimensions
	 */
	public int[] getImageDimensions(int height, int width, int maxHeight, int maxWidth, float defaultRatio)
	{
		int h = height ;
		int w = width ;
		float ratio = (float)height/width ;
		
		if (height>maxHeight || width>maxWidth) 
		{
			//height is higher than the ratio
			if(ratio>defaultRatio)
			{
				h = maxHeight ;
				w = (int)(h/ratio) ;
			}
			else
			{
				w = maxWidth ;
				h = (int)(w*ratio) ;
			}
		}
		int[] dimensions = {w,h} ;
		return dimensions ;
	}
	
	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public File getFile()
	{
		return this.file ;
	}
	
	/**
	 * To string.
	 *
	 * @return the info of the object
	 */
	public String toString()
	{
		return String.format("%s - width : %s - height : %s",this.file.getName(), this.originalWidth, this.originalHeight) ;
	}
	
	

}
