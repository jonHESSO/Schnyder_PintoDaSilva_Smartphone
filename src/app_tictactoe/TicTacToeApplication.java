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

/**
 * The Class TicTacToeApplication.
 */
public class TicTacToeApplication extends DefaultApplication
{
	
	/**
	 * Instantiates a new tic tac toe application.
	 * Creates a new TicTacToePanel when it is instantiated
	 */
	public TicTacToeApplication()
	{
		//loads the score stats, generates it if is unreadable
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
