import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

import entities.AbstractClass;
import entities.AbstractMovableEntity;
import entities.Entity;
import entities.MovableEntity;

public class EntityDemo {
	
	private long lastFrame;
	
	private long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private int getDelta(){
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	
	private static class Box extends AbstractMovableEntity{

		public Box(double x, double y, double width, double height) {
			super(x, y, width, height);
		}

		@Override
		public void draw() {
			glRectd(x, y, x + width, y + height);
		}
		
	}
	
	private static class Point extends AbstractClass{

		public Point(double x, double y) {
			super(x, y, 1, 1);
		}

		@Override
		public void draw() {
			glBegin(GL_POINTS);
				glVertex2d(x, y);
			glEnd();
		}

		@Override
		public void update(int delta) {
			// Do nothing...
		}
		
	}

	public EntityDemo(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Entity DEMOSSSSS");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
		
		//Entity Initialization
		MovableEntity box = new Box(100, 100, 50, 50);
		Entity point = new Point(10, 10);
		
		//OPENGL Initialization
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		lastFrame = getTime();
		
		while(!Display.isCloseRequested()){
			
			point.setLocation(Mouse.getX(), 480 - Mouse.getY());
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			int delta = getDelta();
			box.update(delta);
			point.update(delta);
			
			if(box.intersects(point)){
				box.setDX(0.2);
			}
			
			point.draw();
			box.draw();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new EntityDemo();
	}
}

package entities;

public abstract class AbstractMovableEntity extends AbstractClass implements MovableEntity{

	protected double dx, dy;
	
	public AbstractMovableEntity(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.dx = 0;
		this.dy = 0;
	}
	
	@Override
	public void update(int delta){
		this.x += delta * dx;
		this.y += delta * dy;
	}
	
	public double getDX(){
		return dx;
	}
	
	public double getDY(){
		return dy;
	}
	
	public void setDX(double dx){
		this.dx = dx;
	}
	
	public void setDY(double dy){
		this.dy = dy;
	}

}

package entities;

public interface MovableEntity extends Entity {
	public double getDX();
	public double getDY();
	public void setDX(double dx);
	public void setDY(double dy);
}

package entities;

import java.awt.Rectangle;

public abstract class AbstractClass implements Entity {

	protected double x, y, width, height;
	protected Rectangle hitbox = new Rectangle();
	
	public AbstractClass(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public boolean intersects(Entity other) {
		hitbox.setBounds((int)x, (int)y, (int)width, (int)height);
		return hitbox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
	}

}

 package entities;

public interface Entity {
	public void draw();
	public void update(int delta);
	public void setLocation(double x, double y);
	public void setX(double x);
	public void setY(double y);
	public void setWidth(double width);
	public void setHeight(double height);
	public double getX();
	public double getY();
	public double getWidth();
	public double getHeight();
	public boolean intersects(Entity other);
}
