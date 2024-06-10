JAVA
-------------------
import java.awt.*;
import javax.swing.*;

public class myClass extends JApplet{
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("this actually works?", 25, 25);	
	}
}

HTML
-------------------
<html>
<body>

<applet code ="myClass.class" width="400" height="100">
</applet>

</body>
</html>