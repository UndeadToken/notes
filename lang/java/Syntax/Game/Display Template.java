import java.awt.*;
import javax.swing.JFrame;

public class mainClass extends JFrame{
	public static void main(String[] args){
		
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		mainClass main = new mainClass();
		main.run(dm);
	}
	
	public void run(DisplayMode dm){
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Ariel", Font.PLAIN, 24));
		
		class2 s = new class2();
		try{
			s.setFullScreen(dm, this);
			try{
				Thread.sleep(5000);
			}catch(Exception ex){}
		}
		finally{
			s.restoreScreen();
		}
	}
	
	public void paint(Graphics g){
		g.drawString("this is game stuff", 200, 200);
	}
}

import java.awt.*;
import javax.swing.JFrame;

public class class2{

	private GraphicsDevice vc;
	
	public class2(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame window){
		window.setUndecorated(true);
		window.setResizable(false);
		vc.setFullScreenWindow(window);
		
		if(dm != null && vc.isDisplayChangeSupported()){
			try{
				vc.setDisplayMode(dm);
			}
			catch(Exception ex){}
		}
	}
	
	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		vc.setFullScreenWindow(null);
	}
}
