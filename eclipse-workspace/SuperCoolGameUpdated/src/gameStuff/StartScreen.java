package gameStuff;

import java.awt.Color;
import java.awt.Graphics;

public class StartScreen {
		public void tick() {

		}
		//setting color of HUD
		public void render(Graphics g) {
			g.setColor(Color.GRAY);
			g.drawString("Click Z, X, C or SpaceBar to Start", 240, 150);
			//draw over the text (removing the texts, but painting over it with background color)
		}
		public void remove(Graphics g) {
			g.setColor(Color.white);
			g.drawRect(0, 0, 640, 640/ 12*9);
			g.fillRect(0, 0, 640, 640/12*9);
		}
}
