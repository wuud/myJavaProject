import java.awt.Color;
import java.awt.Graphics;

public class shell extends GameOblect {

	double degree;

	public shell() {
		speed = 3;
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		degree = Math.random() * Math.PI * 2;
		
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.blue);
		g.fillOval((int) x, (int) y, width, height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(x<0||x>Contants.width-width)degree=Math.PI-degree;
		if(y<30||y>Contants.height-height)degree=-degree;
	
		
	}
}
