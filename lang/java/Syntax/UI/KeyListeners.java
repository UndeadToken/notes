package UI;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class KeyListeners extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	private JTextArea text, keychars;

	public KeyListeners() {
		super("KeyListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			System.err.println("Could not use system Look and Feel. \n\n"
					+ e.getMessage());
		}
	}
	
	private void setComponents()
	{
		// Layout manager
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		// Set components
		text = new JTextArea(20, 40);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		add(text);
		
		keychars = new JTextArea(20, 40);
		keychars.setEditable(false);
		keychars.setLineWrap(true);
		keychars.setWrapStyleWord(true);
		add(keychars);
		
		// Allow vertical scrolling
		JScrollPane tScroll = new JScrollPane(text,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(tScroll);
		
		JScrollPane kScroll = new JScrollPane(keychars,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(kScroll);
		
		// Listen for keystrokes
		text.addKeyListener(this);
		
		pack();
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		int key = evt.getKeyChar();
		keychars.append(" " + key);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	// Main
	public static void main(String[] args) {
		new KeyListeners();
	}
}
