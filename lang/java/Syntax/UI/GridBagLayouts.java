package UI;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class GridBagLayouts extends JFrame{
	private static final long serialVersionUID = 1L;

	public GridBagLayouts() {
		super("GridBagLayout");
		setSize(380, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setLocationRelativeTo(null);

		MessagePanel mPanel = new MessagePanel();
		add(mPanel);
		
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

	public static void main(String[] args) {
		new GridBagLayouts();
	}
}
