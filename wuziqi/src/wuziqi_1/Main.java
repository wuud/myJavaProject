package wuziqi_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {
	private JPanel p;
	private int Pointx, Pointy;// 获得棋子的落点位置
	private int count = 0;// 获得点击次数，用来实现棋子转换
	private ArrayList<Integer> listblack = new ArrayList<>();//存放黑棋落点位置
	private ArrayList<Integer> listblue = new ArrayList<>();//存放蓝棋落点位置

	public Main() {
		super("五子棋");
		p = new JPanel();
		p.addMouseListener(new Monitor());
		this.add(p);

		setSize(750, 750);
		setVisible(true);
	}

	class Monitor extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			Pointx = Location(e.getX() + 8);// 鼠标实际点击位置与获得坐标有偏差
			Pointy = Location(e.getY() + 31);
			repaint();
		}
	}

	public void paint(Graphics g) {
		background.draw(g); // 画出棋盘
		// 如果该点之前没被画过，即blacklist和bluelist都不含此点
		if (!listblue.contains(point(Pointx, Pointy)) && !listblack.contains(point(Pointx, Pointy))) {
			if (count % 2 == 0) {
				g.setColor(Color.black);
				g.fillOval(Pointx - 20, Pointy - 20, 40, 40);
				listblack.add(point(Pointx, Pointy));
			} else {
				g.setColor(Color.blue);
				g.fillOval(Pointx - 20, Pointy - 20, 40, 40);
				listblue.add(point(Pointx, Pointy));
			}
			count++;

		}
		gameOver();
	}

	// 定位与所点击 点最近的落子位置
	public int Location(int x) {
		int lx;
		lx = (x * 2 + 50) / 100;
		return lx * 50;
	}

	// 给棋盘上每个点一个标号，方便判断胜利
	public int point(int x, int y) {
		return x / 50 + (y / 50 - 1) * constant.h;
	}

	public void gameOver() {
		if (ruler.blackWin(listblack)) {
			JOptionPane.showMessageDialog(this, "黑棋胜！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		if (ruler.blueWin(listblue)) {
			JOptionPane.showMessageDialog(this, "蓝棋胜！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
