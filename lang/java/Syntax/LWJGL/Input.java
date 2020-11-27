import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.lwjgl.*;


public class input {
	
	private List<Box> shapes = new ArrayList<Box>(16);
	private boolean SomethingIsSelected = false;
	private volatile boolean randomColorCooldown = false;

	public input(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Our Game");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
		
		shapes.add(new Box(15, 15));
		shapes.add(new Box(100, 150));
		
		//OPENGL Initialization
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while(!Display.isCloseRequested()){
			//Render
			glClear(GL_COLOR_BUFFER_BIT);
			
			while(Keyboard.next()){
				if(Keyboard.getEventKey() == Keyboard.KEY_C && Keyboard.getEventKeyState())
					shapes.add(new Box(15, 15));
			}
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();
				System.exit(0);
			}
			
			for(Box box : shapes){
				if(Mouse.isButtonDown(0) && box.inBounds(Mouse.getX(), 480 - Mouse.getY()) && !SomethingIsSelected){
					box.selected = true;
					SomethingIsSelected = true;
					System.out.println("You clicked me!");
				}
				
				if(Mouse.isButtonDown(2) && box.inBounds(Mouse.getX(), 480 - Mouse.getY()) && !SomethingIsSelected){
					box.RandomizeColours();
					randomColorCooldown = true;
					new Thread(new Runnable(){
						public void run(){
							try{
								Thread.sleep(200);
							}catch(InterruptedException e){
								e.printStackTrace();
							}finally{
								randomColorCooldown = false;
							}
						}
					}).run();
				}
				
				if(Mouse.isButtonDown(1)){
					box.selected = false;
					SomethingIsSelected = false;
				}
				
				if(box.selected){
					box.update(Mouse.getDX(), - Mouse.getDY());
				}
				
				box.draw();
			}
				
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	private static class Box {
		public int x, y;
		public Boolean selected = false;
		private float colorRed, colorGreen, colorBlue;
		
		Box(int x, int y){
		this.x = x;
		this.y = y;
		
		Random RandomGenerator = new Random();
		colorRed = RandomGenerator.nextFloat();
		colorGreen = RandomGenerator.nextFloat();
		colorBlue = RandomGenerator.nextFloat();
	    }
		
		boolean inBounds(int mousex, int mousey){
			if(mousex > x && mousex < x + 50 && mousey > y && mousey < y + 50){
				return true;
			}else{
				return false;
			}
		}
		
		void update(int dx, int dy){
			x += dx;
			y += dy;
		}
	
	    void RandomizeColours(){
	    	Random RandomGenerator = new Random();
		    colorRed = RandomGenerator.nextFloat();
		    colorGreen = RandomGenerator.nextFloat();
		    colorBlue = RandomGenerator.nextFloat();
	    }
	    
	    void draw(){
	    	glColor3f(colorRed, colorGreen, colorBlue);
	    	
	    	glBegin(GL_QUADS);
	    		glVertex2i(x, y);
	    		glVertex2i(x + 50, y);
	    		glVertex2i(x + 50, y + 50);
	    		glVertex2i(x, y + 50);
	    	glEnd();
	    }
    }
	
	public static void main(String[] args) {
		new input();
	}
}
