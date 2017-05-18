/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 15, 2017
 */

package app_gallery;

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
	private BufferedImage image ;
	private String imageName ;
	private final int width, heigth ;
	
	/*
	 * public constructor
	 */

	public Picture(File file)
	{
		if (file == null) throw new IllegalArgumentException("constructor argument is null");
		try
		{
			this.image = ImageIO.read(file) ;
		} catch (IOException ioe)
		{
			throw new IllegalArgumentException("could not open file: " + file, ioe) ;
		}
		if (this.image == null) throw new IllegalArgumentException("could not read file: " + file);
		this.width = this.image.getWidth() ;
		this.heigth = this.image.getHeight() ;
		this.imageName = file.getName() ;
	}


	public ImageIcon getIcon(){

		ImageIcon icon = null;

		int originalWidth = this.image.getWidth();
		int originalHeight = this.image.getHeight();

		int x, y, w, h;

		// portrait
		if(originalHeight > originalWidth)
		{
			w = originalWidth ;
			h = originalWidth ;
			x = 0;
			y = (int)(originalHeight*0.5 - originalWidth*0.5) ;
		}

		// paysage ou carré
		else
		{
			w = originalHeight ;
			h = originalHeight ;
			x = (int)(originalWidth*0.5 - originalHeight*0.5) ;
			y = 0;
		}

		try{
			BufferedImage imgCropped = this.image.getSubimage(x, y, w, h);
			icon = new ImageIcon(imgCropped.getScaledInstance(Ressources.GALLERY_IMAGE_WIDTH, Ressources.GALLERY_IMAGE_HEIGHT, Image.SCALE_FAST));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return icon ;
	}

}
