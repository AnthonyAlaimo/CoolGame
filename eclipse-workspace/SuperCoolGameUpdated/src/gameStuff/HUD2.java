package gameStuff;

import java.awt.Color;
import java.awt.Graphics;

//HUD of PLAYER2, AKA boss1 (maybe depending on game implementation)
public class HUD2 {
	public static int HEALTH = 190;
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 190);
		//set player2(boss) upgrades at current levels in the game
	}
	//setting color of HUD
	public void render(Graphics g) {
		//using this keyinput variable, we prevent the HUD for ther boss character from appearing
		//until the space bar has been clicked, to indicate the start of the game
		if (KeyInput.spaceBarClicked == 1) {
			g.setColor(Color.darkGray);
			g.fillRect(440, 0, 200, 30);
			g.setColor(Color.GREEN);
			g.fillRect(445, 5, HEALTH, 20);
			g.drawString("Spawner", 580, 50);
		}
	}

}
