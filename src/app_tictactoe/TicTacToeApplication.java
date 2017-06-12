/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_tictactoe;

import app_contacts.ContactList;
import ressources.DefaultApplication;
import ressources.Ressources;
import ressources.Serializer;

public class TicTacToeApplication extends DefaultApplication
{
	public TicTacToeApplication()
	{
		Ressources.TICTACTOES_STATS = (TicTacToeStats) Serializer.deserializableObject(Ressources.TICTACTOE_SERIALISATION) ;	
		addPanel(new TicTacToePanel()) ;
	}

}
