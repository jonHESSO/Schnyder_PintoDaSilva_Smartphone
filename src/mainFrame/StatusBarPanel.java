/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : Jun 6, 2017
 */

package mainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import ressources.DefaultTextLabel;
import ressources.Kernel32;
import ressources.Ressources;
import ressources.SmallTextLabel;

/**
 * The Class StatusBarPanel.
 */
public class StatusBarPanel extends JPanel implements ActionListener
{
	
	/** The time. */
	JLabel time ;
	
	/** The battery percent. */
	JLabel batteryPercent ;
	
	/** The battery state. */
	JLabel batteryState ;
	
	/** The date format. */
	DateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm") ;
	
	/** The battery status. Uses the JAN library (included in the project)*/
	Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
	
	/** The timer. */
	Timer timer=new Timer(5000, this);
	


	/**
	 * Instantiates a new status bar panel.
	 */
	StatusBarPanel()
	{
		
		setLayout(new BorderLayout());
		setPreferredSize(Ressources.STATUSBAR_DIMENSION);
		timer.start();// Start the timer here.
		
		Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
		
		batteryPercent = new SmallTextLabel(getBatteryPercent()+"  "+getBatteryState());

		time = new SmallTextLabel(getDate()) ;
		
		add(time,BorderLayout.WEST) ;
		add(batteryPercent,BorderLayout.EAST) ;
		
	}
	
	/**
	 * Action performed.
	 * Is called every 5 seconds by the timer and
	 * sets the time and the battery status
	 *
	 * @param ev the event
	 */
	public void actionPerformed(ActionEvent ev){
		if(ev.getSource()==timer){
			Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
			time.setText(getDate());// this will call at every 1 second
			batteryPercent.setText(getBatteryPercent()+"  "+getBatteryState());
		}
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	private String getDate()
	{
		return dFormat.format(new Date(System.currentTimeMillis())) ;
	}
	
	/**
	 * Gets the battery percent.
	 *
	 * @return the battery percent
	 */
	private String getBatteryPercent()
	{
		  
		return batteryStatus.getBatteryLifePercent() ;
	}
	
	/**
	 * Gets the battery state.
	 *
	 * @return the battery state
	 */
	private String getBatteryState()
	{
		return batteryStatus.getBatteryStateString();
	}
}
