import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class demo extends JFrame {
	Image planeimg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");

	plane p = new plane(planeimg, 250, 250);

	shell[] s = new shell[50];
	Explode bao;

	int count;
	Date startTime = new Date();
	Date endTime;
	Long time;

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for (int i = 0; i < s.length; i++) {
			s[i].draw(g);
			boolean peng = s[i].getRectangle().intersects(p.getRectangle());
			if (peng) {
				count++;
				endTime = new Date();
				p.live = false;
				if (bao == null) {
					bao = new Explode(p.x, p.y);
					time = (endTime.getTime() - startTime.getTime()) / 1000;
					if (!p.live)
						JOptionPane.showConfirmDialog(null, "游戏结束", "提示", JOptionPane.CLOSED_OPTION);
				}
			}
		}
		if(bao!=null) {
			bao.draw(g);
			if (!p.live) {
				g.setColor(Color.red);
				Font f = new Font(null, Font.BOLD, 50);
				g.setFont(f);
				g.drawString("游戏结束！" + time + "秒", 100, 200);

			}
		}

	}

	class paintThread extends Thread {// 无限重画
		@Override
		public void run() {
			super.run();
			while (true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public demo() {
		this.setTitle("飞机");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(150, 150);
		new paintThread().start();
		addKeyListener(new key());
		for (int i = 0; i < s.length; i++)
			s[i] = new shell();

	}

	class key extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}

	}

	public static void main(String[] args) {
		demo d = new demo();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
