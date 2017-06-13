/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 7, 2017
 */

package ressources;

import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultTextLabel.
 * Nothing fancy agains, just changes the font
 */
public class DefaultTextLabel extends JLabel
{

	/**
	 * Instantiates a new default text label.
	 *
	 * @param text the text
	 */
	public DefaultTextLabel(String text)
	{
		super(text) ;
		setFont(Ressources.DEFAULT_FONT);
	}
	
//	private Color getRandomColor()
//	{
//		Color defaultColor = Color.white ;
//		int randomInt = (int)(Math.random()*6) ;
//		switch(randomInt)
//		{
//		case 0 : return Color.white ;
//		case 1 : return Color.yellow ;
//		case 2 : return Color.cyan ;
//		case 3 : return Color.GREEN ;
//		case 4 : return Color.orange ;
//		case 5 : return Color.magenta ;
//		}
//		return defaultColor ;
//	}
}
