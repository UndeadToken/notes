package UI;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ItemListeners extends JFrame implements ItemListener{
	private static final long serialVersionUID = 1L;
	
	private static final String[] formats = 
		{"(Choose format)", "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0"};
	
	private static final String[] descriptions = {
		"Atom weblog and syndication format",
		"RSS syndication format 0.92 (Netscape)",
		"RSS/RDF syndication format 1.0 (RSS/RDF)",
		"RSS syndication format 2.0 (UserLand)"
	};
	
	private JComboBox formatBox = new JComboBox();
	private JLabel descriptionLabel = new JLabel("");
	
	public ItemListeners() {
		super("ItemListener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 150);
		setLayout(new BorderLayout());
		setComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
		}catch(Exception e){
			System.err.println("Could not use system Look and Feel. \n\n"
					+ e.getMessage());
		}
	}
	
	private void setComponents()
	{
		// Populate drop down box
		for(int i = 0; i<formats.length; ++i)
		{
			formatBox.addItem(formats[i]);
		}
		formatBox.addItemListener(this);
		
		add(BorderLayout.NORTH, formatBox);
		add(BorderLayout.CENTER, descriptionLabel);
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		int choice = formatBox.getSelectedIndex();
		if(choice > 0)
		{
			descriptionLabel.setText(descriptions[choice -1]);
		}
	}
	
	public Insets getInsets()
	{
		return new Insets(50, 10, 10, 10);
	}

	public static void main(String[] args) {
		ItemListeners.setLookAndFeel();
		ItemListeners IL = new ItemListeners();
	}
}
