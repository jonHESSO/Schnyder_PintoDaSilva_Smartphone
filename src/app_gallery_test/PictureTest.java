/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 13, 2017
 */

package app_gallery_test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import app_gallery.Picture;

public class PictureTest
{
	Picture testPicture = new Picture(new File("data/gallery/doge.png")) ;

	/**
	 * Test method for {@link app_gallery.Picture#getIconCropDimensions(int, int)}.
	 */
	@Test
	public void testGetIconCropDimensionsHeightIsHigher()
	{
		int width = 100 ;
		int height = 200 ;
		int resW = width ;
		int resH = width ;
		int resX = 0 ;
		int resY = 50 ;
		int[] dimensions = testPicture.getIconCropDimensions(height,width) ;
		
		if(dimensions[0]!=resW) fail("Not yet implemented");
		if(dimensions[1]!=resH) fail("Not yet implemented");
		if(dimensions[2]!=resX) fail("Not yet implemented");
		if(dimensions[3]!=resY) fail("Not yet implemented");
		
	}
	
	@Test
	public void testGetIconCropDimensionsWidthIsHigher()
	{
		int width = 400 ;
		int height = 200 ;
		int resW = height ;
		int resH = height ;
		int resX = 100 ;
		int resY = 0 ;
		int[] dimensions = testPicture.getIconCropDimensions(height, width) ;
		
		if(dimensions[0]!=resW) fail("Not yet implemented");
		if(dimensions[1]!=resH) fail("Not yet implemented");
		if(dimensions[2]!=resX) fail("Not yet implemented");
		if(dimensions[3]!=resY) fail("Not yet implemented");
		
	}

	/**
	 * Test method for {@link app_gallery.Picture#getImageDimensions(int, int, int, int, float)}.
	 */
	@Test
	public void testGetImageDimensionsHeightIsTooHigh()
	{
		int width = 200 ;
		int height = 400 ;
		int maxWidth = 200 ;
		int maxHeight = 300 ;
		float defaultRatio = (float)maxHeight / maxWidth ;
		float ratio = (float)height / width ;
		int resW = (int)(maxHeight/ratio) ;
		int resH = maxHeight ;
		int[] dimensions = testPicture.getImageDimensions(height, width, maxHeight, maxWidth, defaultRatio) ;
		if(dimensions[0]!=resW) fail("Not yet implemented");
		if(dimensions[1]!=resH) fail("Not yet implemented");
	}
	
	@Test
	public void testGetImageDimensionsWidthIsTooHigh()
	{
		int width = 400 ;
		int height = 200 ;
		int maxWidth = 200 ;
		int maxHeight = 300 ;
		float defaultRatio = (float)maxHeight / maxWidth ;
		float ratio = (float)height / width ;
		int resW = maxWidth ;
		int resH = (int)(maxWidth*ratio) ;
		int[] dimensions = testPicture.getImageDimensions(height, width, maxHeight, maxWidth, defaultRatio) ;
		if(dimensions[0]!=resW) fail("Not yet implemented");
		if(dimensions[1]!=resH) fail("Not yet implemented");
	}

}
