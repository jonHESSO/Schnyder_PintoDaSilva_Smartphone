/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package app_tictactoe;

import javax.swing.JOptionPane;

import app_contacts.ContactList;
import ressources.DefaultApplication;
import ressources.Ressources;
import ressources.Serializer;

public class TicTacToeApplication extends DefaultApplication
{
	public TicTacToeApplication()
	{
		Ressources.TICTACTOES_STATS = (TicTacToeStats) Serializer.deserializableObject(Ressources.TICTACTOE_SERIALISATION) ;	
		if (Ressources.TICTACTOES_STATS == null)
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Scores corrompus. Un nouveau fichier de score va être généré") ;
			Serializer.serializableObject(new TicTacToeStats(),Ressources.TICTACTOE_SERIALISATION) ;
			Ressources.TICTACTOES_STATS = (TicTacToeStats) Serializer.deserializableObject(Ressources.TICTACTOE_SERIALISATION) ;			
		}
		addPanel(new TicTacToePanel()) ;
	}

}
