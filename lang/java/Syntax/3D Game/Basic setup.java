import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;


public class main extends Canvas implements Runnable{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "My Game - Pre-release 0.1";
	
	private Thread thread;
	private Screen screen;
	private BufferedImage img;
	private Boolean running = false;
	private Render render;
	private int[] pixels;
	
	public main(){
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	
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
		while(running){
			tick();
			render();
		}
	}
	
	private void tick(){
		//ticks
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.render();
		
		for(int i=0; i<WIDTH*HEIGHT; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
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


public class Render {
	public final int height;
	public final int width;
	public final int[] pixels;
	
	public Render(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void draw(Render render, int yOffset, int xOffset){
		for(int y = 0; y<render.height; y++){
			int yPix = y + yOffset;
			
			for(int x = 0; x<render.width; x++){
				int xPix = x + xOffset;
				
				pixels[xPix + yPix * width] = render.pixels[x + y * render.width];
			}
		}
	}
	
	
}


import java.util.Random;


public class Screen extends Render{
	
	private Render test;
	
	public Screen(int width, int height){
		super(width, height);
		Random random = new Random();
		test = new Render(256, 256);
		
		for(int i=0; i<256*256; i++){
			test.pixels[i] = random.nextInt();
		}
	}
	
	public void render(){
		draw(test, 0, 0);
	}
}
