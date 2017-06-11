/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 9, 2017
 */

package ressources;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

import app_home.HomeApplication;

public abstract class DefaultApplication extends JComponent

{
	protected List<JPanel> openPanels ;
	JPanel activePanel ;
	
	public DefaultApplication()
	{
		openPanels = new ArrayList<JPanel>() ;
	}
	
	public JPanel getActivePanel()
	{
			return openPanels.get(openPanels.size()-1) ;
		
	}
	
	public void addPanel(JPanel panel)
	{
		panel.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				if(evt.getPropertyName().equals("closeNow"))
				removePanel((JPanel) evt.getSource()) ;
			}
			
		});
		openPanels.add(panel) ;
		activePanelChanged() ;
	}
	
	public void removePanel(JPanel panel)
	{
		if ((Ressources.ACTIVEAPPLICATION instanceof HomeApplication)==false)
		{

			openPanels.remove(panel) ;
			if (openPanels.isEmpty())
			{
				String className = DefaultApplication.this.getClass().getSimpleName() ;
				switch (className)
				{
				case "GalleryApplication":
					Ressources.GALLERYAPP = null ;
					break;
				case "ContactApplication":
					Ressources.CONTACTAPP = null ;
					break;
				case "TicTacToeApplication":
					Ressources.TICTACTOEAPP = null ;
					break;
				default:
					break;
				}
				Ressources.ACTIVEAPPLICATION = Ressources.HOMEAPP ;
			}
			activePanelChanged() ;
		}
		
		
		
	}
	
	public void activePanelChanged()
	{
		Ressources.MAINFRAME.reloadCenterPanel();
	}
	
	
	
	
	

}
