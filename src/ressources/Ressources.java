/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 17, 2017
 */

package ressources;

import java.awt.Dimension;

public class Ressources
{
	public static final int GALLERY_ICON_WIDTH = 150 ;
	public static final int GALLERY_ICON_HEIGHT = 150 ;
	public static final int DEFAULT_BUTTON_HEIGHT = 20 ;
	public static final String GALLERY_DIRECTORY = "data/gallery/";
	public static final String TICTACTOE_DIRECTORY = "data/tictactoe_stats/scores.ser";
	public static final Dimension CONTACT_TEXTFIELD_DIMENSION = new Dimension(50,20) ;
	public static final int DEFAULT_FRAME_HEIGHT = 800 ;
	public static final int DEFAULT_FRAME_WIDTH = 500 ;
	public static final int BUTTONBAR_HEIGHT = 50 ;
	public static final int STATUSBAR_HEIGHT = 20 ;
	public static final int DEFAULT_APP_JPANEL_HEIGHT = DEFAULT_FRAME_HEIGHT - (BUTTONBAR_HEIGHT+STATUSBAR_HEIGHT) ;
	public static final int DEFAULT_APP_JPANEL_WIDTH = 500 ;
	public static final int GALLERY_PICTURE_HEIGHT = DEFAULT_APP_JPANEL_HEIGHT-DEFAULT_BUTTON_HEIGHT ;	
	public static final float DEFAULT_PICTURE_RATIO = (float)GALLERY_PICTURE_HEIGHT/DEFAULT_APP_JPANEL_WIDTH ;
	public static final Dimension DEFAULT_FRAME_DIMENSION = new Dimension(DEFAULT_FRAME_WIDTH,DEFAULT_FRAME_HEIGHT) ;
	public static final Dimension DEFAULT_APP_JPANEL_DIMENSION= new Dimension (DEFAULT_APP_JPANEL_WIDTH, DEFAULT_APP_JPANEL_HEIGHT);
	public static final Dimension GALLERY_APP_ICONPANEL = new Dimension(465,DEFAULT_APP_JPANEL_HEIGHT) ;
	public static final Dimension TICTACTOE_APP_JPANEL_DIMENSION= new Dimension (300, 300) ;
	public static final Dimension TICTACTOE_APP_FIELD_DIMENSION= new Dimension (100, 100) ;
	public static final Dimension BUTTONBAR_PANEL_DIMENSION = new Dimension (500,20);
	public static final Dimension DEFAULT_BUTTON_DIMENSION = new Dimension(100,DEFAULT_BUTTON_HEIGHT) ; ;
}
