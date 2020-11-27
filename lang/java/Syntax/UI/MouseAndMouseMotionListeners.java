package UI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MouseAndMouseMotionListeners extends JFrame implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	
	private static JButton button;

	public MouseAndMouseMotionListeners() {
		super("MouseAndMouseMotion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 200);
		setLayout(new BorderLayout());
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
		button = new JButton("Mouse and Mouse Motion event handling");
		button.addMouseListener(this);
		button.addMouseMotionListener(this);
		add(button, BorderLayout.CENTER);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		button.setText("Mouse dragged");
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		String mx = " X:" + evt.getX();
		String my = " Y:" + evt.getY();
		button.setText("Mouse moved" + mx + my);
	}

	@Override
	public void mouseClicked(MouseEvent evt) {
		button.setText("Mouse clicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		button.setText("Mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		button.setText("Mouse exited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		button.setText("Mouse pressed"); 
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		button.setText("Mouse released");
	}
	
	public static void main(String[] args) {
		new MouseAndMouseMotionListeners();
	}
}
