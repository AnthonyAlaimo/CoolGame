package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy2 extends GameObject{

	Random num = new Random();
	//dimension variables for the player
	private int width = 10;
	private int height = 10;
	//using a random num, we set a random initial velocity to the enemy objects as they span
	public Enemy2(int positionX, int positionY, int width, int height, ID id) {
		super(positionX, positionY, width, height, id);
		velX = num.nextInt(5) + 1;
		velY = num.nextInt(5);
	
	}
	
	//method used for collision of objects, returns true when rectangles come in contact
	public Rectangle getBounds() {
		//overlaps with Player parameters
		return new Rectangle(positionX, positionY, width, height);
	}
	
	
	public void tick() {
		positionX += velX;
		positionY += velY;
		//if the enemy is apporaching the window boundaries, switch its direction
		if (positionY <=-30 || positionY >= (650/ 12*9)) {
			velY = -(3/2)*velY;
		}else if(positionX <=-30 || positionX >= 650) {
			velX = -(3/2)*velX;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(positionX, positionY, 10, 10);
	}

}