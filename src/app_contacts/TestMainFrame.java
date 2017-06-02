package app_contacts;

import javax.swing.*;

public class TestMainFrame extends JFrame {
	
	public TestMainFrame()
	{
		add(new ContactListJpanel()) ;
		pack() ;
	}

}
