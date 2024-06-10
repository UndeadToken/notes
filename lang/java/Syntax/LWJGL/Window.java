import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;


public class Main {

	public Main(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Our Game");
			Display.create();
		}catch(LWJGLException e){
			e.printStackTrace();
		}
		
		//OPENGL 
		
		while(!Display.isCloseRequested()){
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
