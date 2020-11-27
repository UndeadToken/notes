package UI;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FocusListeners extends JFrame implements FocusListener{
	private static final long serialVersionUID = 1L;
	
	private static JTextField value1, value2, sum;
	JLabel plus, equals;

	public FocusListeners() {
		super("FocusListener");
		setSize(350, 90);
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
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);
		
		// Set components
		value1 = new JTextField("0", 5);
		value2 = new JTextField("0", 5);
		
		sum = new JTextField("0", 5);
		sum.setEditable(false);
		
		plus = new JLabel("+");
		equals = new JLabel("=");
		
		// Add listeners
		value1.addFocusListener(this);
		value2.addFocusListener(this);
		
		// Add components
		add(value1);
		add(plus);
		add(value2);
		add(equals);
		add(sum);
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		try {
			float v1 = Float.parseFloat(value1.getText());
			float v2 = Float.parseFloat(value2.getText());
			float total = v1 + v2;
			sum.setText("" + total);
		} catch(NumberFormatException nfe) {
			value1.setText("0");
			value2.setText("0");
			sum.setText("0");
		} 
	}

	@Override
	public void focusLost(FocusEvent evt) {
		focusGained(evt);
	}
	
	public static void main(String[] args) {
		new FocusListeners();
	}
}
