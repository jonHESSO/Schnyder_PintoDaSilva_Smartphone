/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 17, 2017
 */

package ressources;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

import app_contacts.ContactApplication;
import app_contacts.ContactList;
import app_gallery.GalleryApplication;
import app_home.HomeApplication;
import app_tictactoe.TicTacToeApplication;
import app_tictactoe.TicTacToeStats;
import mainFrame.MainFrame;


/**
 * The Class Ressources.
 * It contains all the public constants
 * and static references to the open apps
 */
public class Ressources
{
	
	//component heights
	
	/** The Constant GALLERY_ICON_HEIGHT. */
	public static final int GALLERY_ICON_HEIGHT = 150 ;
	
	/** The Constant DEFAULT_BUTTON_HEIGHT. */
	public static final int DEFAULT_BUTTON_HEIGHT = 50 ;	
	
	/** The Constant DEFAULT_FRAME_HEIGHT. */
	public static final int DEFAULT_FRAME_HEIGHT = 800 ;	
	
	/** The Constant BUTTONBAR_HEIGHT. */
	public static final int BUTTONBAR_HEIGHT = 60 ;
	
	/** The Constant STATUSBAR_HEIGHT. */
	public static final int STATUSBAR_HEIGHT = 20 ;
	
	/** The Constant DEFAULT_APP_JPANEL_HEIGHT. */
	public static final int DEFAULT_APP_JPANEL_HEIGHT = DEFAULT_FRAME_HEIGHT - (BUTTONBAR_HEIGHT+STATUSBAR_HEIGHT) ;
	
	/** The Constant GALLERY_PICTURE_HEIGHT. */
	public static final int GALLERY_PICTURE_HEIGHT = DEFAULT_APP_JPANEL_HEIGHT-100 ;	
	
	
	/** The Constant GALLERY_ICON_WIDTH. */
	//component widhts
	public static final int GALLERY_ICON_WIDTH = 150 ;
	
	/** The Constant DEFAULT_FRAME_WIDTH. */
	public static final int DEFAULT_FRAME_WIDTH = 500 ;
	
	/** The Constant DEFAULT_APP_JPANEL_WIDTH. */
	public static final int DEFAULT_APP_JPANEL_WIDTH = 500 ;
	
	
	/** The datapath. */
	//serialized files directories/paths
	public static String DATAPATH ;
	
	/** The gallery directory. */
	public static String GALLERY_DIRECTORY ;
	
	/** The tictactoe directory. */
	public static String TICTACTOE_DIRECTORY ;
	
	/** The contact directory. */
	public static String CONTACT_DIRECTORY ;
	
	/** The contact serialisation. */
	public static String CONTACT_SERIALISATION ;
	
	/** The tictactoe serialisation. */
	public static String TICTACTOE_SERIALISATION ;
	
	
	/** The Constant DEFAULT_PICTURE_RATIO. */
	public static final float DEFAULT_PICTURE_RATIO = (float)(GALLERY_PICTURE_HEIGHT)/DEFAULT_APP_JPANEL_WIDTH ;
	
	/** The Constant CONTACT_TEXTFIELD_DIMENSION. */
	//component dimensions
	public static final Dimension CONTACT_TEXTFIELD_DIMENSION = new Dimension(100,40) ;
	
	/** The Constant DEFAULT_FRAME_DIMENSION. */
	public static final Dimension DEFAULT_FRAME_DIMENSION = new Dimension(DEFAULT_FRAME_WIDTH,DEFAULT_FRAME_HEIGHT) ;
	
	/** The Constant DEFAULT_APP_JPANEL_DIMENSION. */
	public static final Dimension DEFAULT_APP_JPANEL_DIMENSION= new Dimension (DEFAULT_APP_JPANEL_WIDTH, DEFAULT_APP_JPANEL_HEIGHT);
	
	/** The Constant CONTACT_APP_CREATIONPANEL. */
	public static final Dimension CONTACT_APP_CREATIONPANEL = new Dimension(500,DEFAULT_APP_JPANEL_HEIGHT-DEFAULT_BUTTON_HEIGHT) ;
	
	/** The Constant GALLERY_APP_ICONPANEL. */
	public static final Dimension GALLERY_APP_ICONPANEL = new Dimension(465,DEFAULT_APP_JPANEL_HEIGHT) ;
	
	/** The Constant TICTACTOE_APP_JPANEL_DIMENSION. */
	public static final Dimension TICTACTOE_APP_JPANEL_DIMENSION= new Dimension (300, 300) ;
	
	/** The Constant TICTACTOE_APP_FIELD_DIMENSION. */
	public static final Dimension TICTACTOE_APP_FIELD_DIMENSION= new Dimension (100, 100) ;
	
	/** The Constant BUTTONBAR_PANEL_DIMENSION. */
	public static final Dimension BUTTONBAR_PANEL_DIMENSION = new Dimension (500,BUTTONBAR_HEIGHT);
	
	/** The Constant STATUSBAR_DIMENSION. */
	public static final Dimension STATUSBAR_DIMENSION = new Dimension(DEFAULT_FRAME_WIDTH,STATUSBAR_HEIGHT) ;
	
	/** The Constant DEFAULT_BUTTON_DIMENSION. */
	public static final Dimension DEFAULT_BUTTON_DIMENSION = new Dimension(100,DEFAULT_BUTTON_HEIGHT) ;
	
	/** The Constant GALLERY_ICON_DIMENSION. */
	public static final Dimension GALLERY_ICON_DIMENSION = new Dimension(GALLERY_ICON_WIDTH,GALLERY_ICON_HEIGHT) ;
	
	/** The Constant GALLERY_PICTUREPANEL_DIMENSION. */
	public static final Dimension GALLERY_PICTUREPANEL_DIMENSION = new Dimension(500, GALLERY_PICTURE_HEIGHT) ;
	
	/** The Constant STATURBAR_FONT. */
	public static final Font STATURBAR_FONT = new Font("Comic Sans MS", Font.BOLD, 11) ;
	
	/** The Constant DEFAULT_FONT. */
	public static final Font DEFAULT_FONT = new Font("Comic Sans MS", Font.BOLD, 15) ;
	
	/** The Constant CONTACT_FONT_TITLE. */
	public static final Font CONTACT_FONT_TITLE = new Font("Comic Sans MS", Font.BOLD, 20) ;

	
	/** The tictactoes stats. */
	public static TicTacToeStats TICTACTOES_STATS ;
	
	/** The contactlist. */
	public static ContactList CONTACTLIST  ;
	
	/** The mainframe. */
	public static MainFrame MAINFRAME ;
	
	/** The activeapplication. */
//	public static DefaultApplication ACTIVEAPPLICATION ;
//	
//	/** The contactapp. */
//	public static DefaultApplication CONTACTAPP ;
//	
//	/** The galleryapp. */
//	public static DefaultApplication GALLERYAPP ;
//	
//	/** The tictactoeapp. */
//	public static DefaultApplication TICTACTOEAPP ;
//	
//	/** The homeapp. */
//	public static DefaultApplication HOMEAPP ;

//	public static AppManager APPMANAGER;
	
}
