package wuziqi_1;

import java.awt.Color;
import java.awt.Graphics;

public class background {
	public static void draw(Graphics g) {
		g.setColor(Color.black);
		for(int i=1;i<constant.h+1;i++)
		g.drawLine(i*constant.space, 50, i*constant.space,constant.height-50);
		for(int i=1;i<constant.l+1;i++)
		g.drawLine(50, i*constant.space, constant.width-50, i*constant.space);
	}

}
