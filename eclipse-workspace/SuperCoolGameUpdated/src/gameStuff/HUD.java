package gameStuff;

import java.awt.Color;
import java.awt.Graphics;


//PLAYER HUD
public class HUD {
	//made static so HUD2 can use this value to upgrade the boss character
	public static int levelCount;
	//player health points
	public static int HEALTH = 190;
	public void tick() {
		//making the health bar decrease and bounding it within a range.
		//Need to implement this correctly next time and add into other HUD2
		//Should correspond to PLAYER1 HEALTH BAR
		HEALTH = Game.clamp(HEALTH, 0, 190);
		//each time the BossPlayers health reaches 0, the game level will increase by 1
		//with further implementation this will also transition into a new boss player spawning
		if (HUD2.HEALTH == 0) {
			//each level increase will essentially increase the difficulty to defeat the boss
			//the boss grows stronger as the player progresses through levels
			levelCount += 1;
			//reset boss player's health 
			HUD2.HEALTH += 190;
		//every 10 levels refill health
		}else if (levelCount%10 == 0) {
			HEALTH = 190;
		}
	}
	//setting color of HUD
	public void render(Graphics g) {
		if (KeyInput.spaceBarClicked == 1) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, 200, 30);
			g.setColor(Color.GREEN);
			g.fillRect(5, 5, HEALTH, 20);
			//Creating a string which will display the current level
			g.drawString("Level "  + String.valueOf(levelCount), 0, 50);
		}
	}
}
