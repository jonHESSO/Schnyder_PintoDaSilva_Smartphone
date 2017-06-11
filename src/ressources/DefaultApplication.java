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

public abstract class DefaultApplication extends JComponent

{
	protected static List<JPanel> openPanels = new ArrayList<JPanel>() ;
	JPanel activePanel ;
	boolean activePanelChanged = false ;
	
	public DefaultApplication()
	{
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
		activePanel = getActivePanel() ;
		activePanelChanged() ;
	}
	
	public void removePanel(JPanel panel)
	{
		openPanels.remove(panel) ;
		activePanel = getActivePanel() ;
		activePanelChanged() ;
	}
	
	public void activePanelChanged()
	{
		firePropertyChange("panelChanged", null, activePanel);
	}
	
	
	
	
	

}
