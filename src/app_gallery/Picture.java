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

/*
 * This class creates picture objects used by the gallery app
 * It contains a method returning a cropped icon of the actual image
 */

public class Picture implements Serializable
{
	private File file ;
	private final int originalWidth, originalHeight ;
	
	/*
	 * public constructor
	 * uses a file as a parameter
	 * and saves it with it's width and height
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
	
	public ImageIcon getPicture()
	{
		ImageIcon bImage = null ;
		double ratio = (float)this.originalHeight/this.originalWidth ;
		int h =this.originalHeight, w =this.originalWidth ;
		try
		{
			if (this.originalHeight>Ressources.GALLERY_PICTURE_HEIGHT || this.originalWidth>Ressources.DEFAULT_APP_JPANEL_WIDTH) 
			{
				//height is higher than the ratio
				if(ratio>Ressources.DEFAULT_PICTURE_RATIO)
				{
					h = Ressources.GALLERY_PICTURE_HEIGHT ;
					w = (int)(h/ratio) ;
				}
				else
				{
					w = Ressources.DEFAULT_APP_JPANEL_WIDTH ;
					h = (int)(w*ratio) ;
				}
			}
			Image scaledImage = ImageIO.read(file).getScaledInstance(w, h, Image.SCALE_SMOOTH) ;
			bImage = new ImageIcon(scaledImage) ;
			
		} catch (IOException ioe)
		{
//			throw new IllegalArgumentException("could not open file: " + file, ioe) ;
		}
		return bImage ;
	}

	/*
	 * returns an icon from the image file
	 * the size is standardized
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

		/*  Croppping  */
		//if portrait
		if(this.originalHeight > this.originalWidth)
		{
			w = this.originalWidth ;
			h = this.originalWidth ;
			x = 0;
			y = (int)(this.originalHeight*0.5 - this.originalWidth*0.5) ;
		}

		//if landscape or square
		else
		{
			w = this.originalHeight ;
			h = this.originalHeight ;
			x = (int)(this.originalWidth*0.5 - this.originalHeight*0.5) ;
			y = 0;
		}

		//actual cropping and resizing
		try{
			BufferedImage imgCropped = bImage.getSubimage(x, y, w, h);
			icon = new ImageIcon(imgCropped.getScaledInstance(Ressources.GALLERY_ICON_WIDTH, Ressources.GALLERY_ICON_HEIGHT, Image.SCALE_FAST));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return icon ;
	}
	
	public File getFile()
	{
		return this.file ;
	}
	
	public String toString()
	{
		return String.format("%s - width : %s - height : %s",this.file.getName(), this.originalWidth, this.originalHeight) ;
	}
	
	

}
