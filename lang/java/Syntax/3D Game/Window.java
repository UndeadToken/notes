import java.awt.Canvas;
import javax.swing.JFrame;


public class main extends Canvas implements Runnable{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "My Game - Pre-release 0.1";
	
	private Thread thread;
	private Boolean running = false;
	
	private void start(){
		if(running)
			return;
			running = true;
			thread = new Thread(this);
			thread.start();
	}
	
	public void stop(){
		if(!running)
			return;
		running = false;
		try{
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void run(){
		
	}
	
	public static void main(String[] args){
		main game = new main();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		System.out.println("Running...");
		
		game.start();
	}
}
