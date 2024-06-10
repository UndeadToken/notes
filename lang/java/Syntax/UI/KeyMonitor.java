package UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyMonitor extends KeyAdapter{
	AdapterClasses display;
	
	KeyMonitor(AdapterClasses display)
	{
		this.display = display;
	}
	
	public void keyTyped(KeyEvent evt)
	{
		display.keyLabel.setText("" + evt.getKeyChar());
		display.repaint();
	}
}
