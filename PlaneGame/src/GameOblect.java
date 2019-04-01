import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameOblect {
        Image img;
        double x,y;
        int speed;
        int width,height;
        public void draw(Graphics g){
        	g.drawImage(img, (int)x, (int)y, null);
        }
		public GameOblect(Image img, double x, double y, int speed, int width, int height) {
			super();
			this.img = img;
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.width = width;
			this.height = height;
		}
		public GameOblect(Image img, double x, double y) {
			super();
			this.img = img;
			this.x = x;
			this.y = y;
		}
		public GameOblect() {
			super();
		}
		//Åö×²»úÖÆ¼ì²â
		public Rectangle getRectangle(){
			return new Rectangle((int)x, (int)y, width, height);
		}
        
	
}
