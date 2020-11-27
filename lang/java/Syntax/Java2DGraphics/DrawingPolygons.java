package Java2DGraphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class DrawingPolygons extends JFrame{
	private static final long serialVersionUID = 1L;

	DrawingPolygons()
	{
		super("Drawing Polygons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel() {
			
			public void paintComponent(Graphics comp) {
				super.paintComponent(comp);
				Graphics2D comp2D = (Graphics2D) comp;
				comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
						RenderingHints.VALUE_ANTIALIAS_ON);
				
				// Drawing Stroke
				BasicStroke pen = new BasicStroke(2.0f,
						BasicStroke.CAP_BUTT,    // CAP_ROUND, CAP_SQUARE
						BasicStroke.JOIN_ROUND); // JOIN_MITER, JOIN_BEVEL
				comp2D.setStroke(pen);
				
				// Gradient Colour
				GradientPaint gp = new GradientPaint(0, 400, Color.RED, 
						0, 200, Color.BLACK, true);
				comp2D.setPaint(gp);
				
				// Line
				Line2D.Float ln = new Line2D.Float(10F, 10F, 370F, 10F);
				comp2D.draw(ln);
				
				// Rectangle
				Rectangle2D.Float rc = new Rectangle2D.Float(10F, 70F, 180F, 20F);
				comp2D.fill(rc);
				comp2D.draw(rc);
				
				// Ellipses
				Ellipse2D.Float ee = new Ellipse2D.Float(40, 50, 10, 10);
				comp2D.fill(ee);
				comp2D.draw(ee);
				
				// Arc
				Arc2D.Float arc = new Arc2D.Float(27F, 22F, 42F, 30F, 33F, 90F, 
						Arc2D.PIE); // OPEN, CHORD
				comp2D.fill(arc);
				comp2D.draw(arc);
				
				// Polygon
				GeneralPath polly = new GeneralPath();
				polly.moveTo(100F, 100F);
				polly.lineTo(110F, 130F);
				polly.lineTo(140F, 150F);
				polly.closePath();
				comp2D.fill(polly);
				comp2D.draw(polly);
			}
		};
		
		add(panel);
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
	
	public static void main(String[] Args) {
		new DrawingPolygons();
	}
}
