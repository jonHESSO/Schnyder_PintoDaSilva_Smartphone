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

public class Ressources
{
	
	//component heights
	
	public static final int GALLERY_ICON_HEIGHT = 150 ;
	public static final int DEFAULT_BUTTON_HEIGHT = 20 ;	
	public static final int DEFAULT_FRAME_HEIGHT = 800 ;	
	public static final int BUTTONBAR_HEIGHT = 60 ;
	public static final int STATUSBAR_HEIGHT = 20 ;
	public static final int DEFAULT_APP_JPANEL_HEIGHT = DEFAULT_FRAME_HEIGHT - (BUTTONBAR_HEIGHT+STATUSBAR_HEIGHT) ;
	public static final int GALLERY_PICTURE_HEIGHT = DEFAULT_APP_JPANEL_HEIGHT-DEFAULT_BUTTON_HEIGHT ;	
	
	
	//component widhts
	public static final int GALLERY_ICON_WIDTH = 150 ;
	public static final int DEFAULT_FRAME_WIDTH = 500 ;
	public static final int DEFAULT_APP_JPANEL_WIDTH = 500 ;
	
	
	//serialized files directories/paths
	public static final String GALLERY_DIRECTORY = "data/gallery/";
	public static final String TICTACTOE_DIRECTORY = "data/tictactoe_stats/";
	public static final String CONTACT_DIRECTORY = "data/contact/";
	
	public static final String CONTACT_SERIALISATION = "data/contact/contactlist.ser";
	public static final String TICTACTOE_SERIALISATION = "data/tictactoe_stats/scores.ser";
	
	
	public static final float DEFAULT_PICTURE_RATIO = (float)GALLERY_PICTURE_HEIGHT/DEFAULT_APP_JPANEL_WIDTH ;
	
	//component dimensions
	public static final Dimension CONTACT_TEXTFIELD_DIMENSION = new Dimension(100,40) ;
	public static final Dimension DEFAULT_FRAME_DIMENSION = new Dimension(DEFAULT_FRAME_WIDTH,DEFAULT_FRAME_HEIGHT) ;
	public static final Dimension DEFAULT_APP_JPANEL_DIMENSION= new Dimension (DEFAULT_APP_JPANEL_WIDTH, DEFAULT_APP_JPANEL_HEIGHT);
	public static final Dimension CONTACT_APP_CREATIONPANEL = new Dimension(500,DEFAULT_APP_JPANEL_HEIGHT-DEFAULT_BUTTON_HEIGHT) ;
	public static final Dimension GALLERY_APP_ICONPANEL = new Dimension(465,DEFAULT_APP_JPANEL_HEIGHT) ;
	public static final Dimension TICTACTOE_APP_JPANEL_DIMENSION= new Dimension (300, 300) ;
	public static final Dimension TICTACTOE_APP_FIELD_DIMENSION= new Dimension (100, 100) ;
	public static final Dimension BUTTONBAR_PANEL_DIMENSION = new Dimension (500,BUTTONBAR_HEIGHT);
	public static final Dimension STATUSBAR_DIMENSION = new Dimension(DEFAULT_FRAME_WIDTH,STATUSBAR_HEIGHT) ;
	public static final Dimension DEFAULT_BUTTON_DIMENSION = new Dimension(100,DEFAULT_BUTTON_HEIGHT) ;
	public static final Dimension GALLERY_ICON_DIMENSION = new Dimension(GALLERY_ICON_WIDTH,GALLERY_ICON_HEIGHT) ;
	
	public static final Font STATURBAR_FONT = new Font("Comic Sans MS", Font.BOLD, 11) ;
	public static final Font DEFAULT_FONT = new Font("Comic Sans MS", Font.BOLD, 15) ;
	public static final Font CONTACT_FONT_TITLE = new Font("Comic Sans MS", Font.BOLD, 20) ;

	
	public static TicTacToeStats TICTACTOES_STATS ;
	public static ContactList CONTACTLIST  ;
	
	public static MainFrame MAINFRAME ;
	
	public static DefaultApplication ACTIVEAPPLICATION ;
	public static DefaultApplication CONTACTAPP ;
	public static DefaultApplication GALLERYAPP ;
	public static DefaultApplication TICTACTOEAPP ;
	public static DefaultApplication HOMEAPP ;
	
}
