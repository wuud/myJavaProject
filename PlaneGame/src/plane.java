import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class plane extends GameOblect {
	boolean up, down, left, right;
	int speed = 5;
	
    boolean live=true;
	public plane() {
		super();
	}

	public plane(Image img, double x, double y, int speed, int width, int heigth) {
		super(img, x, y, speed, width, heigth);
	}

	public plane(Image img, double x, double y) {
		super(img, x, y);
		this.height=img.getHeight(null)-20;
		this.width=img.getWidth(null)-20;
	}
	
	@Override
	public void draw(Graphics g) {
		if(live){
			super.draw(g);
		if (right)
			x += speed;
		if (left)
			x -= speed;
		if (up)
			y -= speed;
		if (down)
			y += speed;
	}}

	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		}
	}

	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = false;
		case KeyEvent.VK_DOWN:
			down = false;
		case KeyEvent.VK_RIGHT:
			right = false;
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		}
	}

}
