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
import app_home.HomePanel;


/**
 * The Class DefaultApplication.
 * It contains a list of open panels, a 
 * method to add new panels, and a method
 * returning the last open panel. It works
 * as an easy-to-use panel manager
 */
public abstract class DefaultApplication extends JComponent

{	
	/** The open panels. */
	protected List<JPanel> openPanels ;
	
	/** The active panel. */
	JPanel activePanel ;
	
	/**
	 * Instantiates a new default application.
	 */
	public DefaultApplication()
	{
		openPanels = new ArrayList<JPanel>() ;
	}
	
	/**
	 * Gets the active panel.
	 *
	 * @return the active panel
	 */
	public JPanel getActivePanel()
	{
			return openPanels.get(openPanels.size()-1) ;
		
	}
	
	/**
	 * Adds the panel.
	 *
	 * @param panel the panel
	 */
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
	
	/**
	 * Removes the panel.
	 * Behaves itself like a good app if the
	 * the first panel is closed, and closes itself
	 * Also, it returns to the home app
	 *
	 * @param panel the panel
	 */
	public void removePanel(JPanel panel)
	{
		if ((AppManager.getActivePanel() instanceof HomePanel)==false)
		{

			openPanels.remove(panel) ;
			if (openPanels.isEmpty())
			{
				String className = DefaultApplication.this.getClass().getSimpleName() ;
				switch (className)
				{
				case "GalleryApplication":
					AppManager.removeApp("gallery");
					break;
				case "ContactApplication":
					AppManager.removeApp("contact");
					break;
				case "TicTacToeApplication":
					AppManager.removeApp("tictactoe") ;
					break;
				default:
					break;
				}
				AppManager.setActiveApp("home") ;
			}
			activePanelChanged() ;
		}
		
		
		
	}
	
	/**
	 * Active panel changed.
	 */
	public void activePanelChanged()
	{
		Ressources.MAINFRAME.reloadCenterPanel();
	}
	
	
	
	
	

}
