package UI;

//import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class SimpleFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public SimpleFrame()
	{
		super("UI Title");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLookAndFeel();
		setComponents();
		setResizable(false);
		setVisible(true);
	}
	
	private static void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void setComponents()
	{
		//Panel(Container)
		JPanel bPanel = new JPanel();
		
		//Button
		JButton btn1 = new JButton("btn1");
		bPanel.add(btn1);
		
		//Button with Icon
		//ImageIcon btn2 = new ImageIcon("btn.png");
		//bPanel.add(btn2);
		
		//Label
		JLabel lbl = new JLabel("A Label", SwingConstants.LEFT);
		bPanel.add(lbl); 
		//(String)
		//(String, Alignment)
		//(String, Icon, Alignment)
		
		//Text Field
		JTextField txtfld = new JTextField("Enter some text...", 10);
		txtfld.setEditable(false);
		System.out.println(txtfld.isEditable());
		bPanel.add(txtfld);
		//()
		//(Width)
		//(Text, Width)
		
		//Password field
		JPasswordField pwdfld = new JPasswordField(20);
		pwdfld.setEchoChar('#');
		bPanel.add(pwdfld);
		
		//Text Area
		JTextArea txtArea = new JTextArea("My text area", 10, 20);
		System.out.println(txtArea.getSelectedText());
		System.out.println(txtArea.getText());
		txtArea.setText("My Funky Text Area");
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		//(Text)
		//(Text, rows, columns)
		
		//Scroll pane
		JScrollPane scroll = new JScrollPane(txtArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bPanel.add(scroll);
		
		//Check Box
		ButtonGroup btngrp = new ButtonGroup();
		JRadioButton[] nums = new JRadioButton[4];
		for(JRadioButton btn : nums)
		{
			btn = new JRadioButton("...");
			btngrp.add(btn);
			bPanel.add(btn);
		}
		
		//Combo Box
		String[] lang = {"1", "2", "3", "4", "5", "6", 
						 "7", "8", "9", "10"};
		JComboBox combo = new JComboBox(lang);
		bPanel.add(combo);
		
		//List
		String[] items = {"1", "2", "3", "4", "5"};
		JList list = new JList<Object>(items);
		bPanel.add(list);
		
		//Slider
		JSlider pickNum = new JSlider(JSlider.VERTICAL, 0, 30, 5);
		pickNum.setMajorTickSpacing(10);
		pickNum.setMinorTickSpacing(1); 
		pickNum.setPaintTicks(true);
		pickNum.setPaintLabels(true);
		bPanel.add(pickNum);
	
		add(bPanel);
		pack();
	}
	
	// Main
	public static void main(String[] Args)
	{
		new SimpleFrame();
	}
}
