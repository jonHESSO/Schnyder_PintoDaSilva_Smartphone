/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 11, 2017
 */

package ressources;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import mainFrame.MainFrame;

public class SmartPhone 
{	

	public static void main(String[] args)
	{
		Ressources.MAINFRAME = new MainFrame() ;
//		Ressources.MAINFRAME.addPropertyChangeListener(new PropertyChangeListener()
//		{
//			
//			@Override
//			public void propertyChange(PropertyChangeEvent evt)
//			{
//				if (evt.getPropertyName().equals("activeAppChanged"))
//				{
//					Ressources.MAINFRAME.reloadCenterPanel();
//				}
//			}
//		});
		Ressources.MAINFRAME.setVisible(true);		

	}
	
//	static class ActiveAppListener implements PropertyChangeListener
//	{
//
//		@Override
//		public void propertyChange(PropertyChangeEvent evt)
//		{
//			if (evt.getPropertyName().equals("activeAppChanged")||evt.getPropertyName().equals("activePanelChanged")) 
//			{
//				Ressources.MAINFRAME.reloadCenterPanel();
//			}
//		}
//		
//	}

}
