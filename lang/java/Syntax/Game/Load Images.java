import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class images extends JFrame{
	public static void main(String[] args){
		
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		images i = new images();
		i.run(dm);
	}
	
	private class2 s;
	private Image bg;
	private Image pic;
	private boolean loaded;
	
	
	//Run method
	public void run(DisplayMode dm){
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Ariel", Font.PLAIN, 24));
		loaded = false;
		
		s = new class2();
		try{
			s.setFullScreen(dm, this);
			loadPics();
			try{
				Thread.sleep(5000);
			}catch(Exception ex){}
		}
		finally{
			s.restoreScreen();
		}
	}
	
	//Load pictures
	public void loadPics(){
		bg = new ImageIcon("C:\\Users\\PC\\Desktop\\Java Current Projects\\Stuff\\src\\wallpaper.jpg").getImage();
		pic = new ImageIcon("C:\\Users\\PC\\Desktop\\Java Current Projects\\Stuff\\src\\face.png").getImage();
		loaded = true;
	}
	
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//KEY_TEXT_ANITALIASING
		}
		if(loaded){
			g.drawImage(bg, 0, 0, null);
			g.drawImage(pic, 170, 180, null);
		}
	}
}
