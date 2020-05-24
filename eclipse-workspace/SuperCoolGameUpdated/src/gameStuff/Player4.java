package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
//Our player class, where we set the features of our player
public class Player4 extends GameObject{
	
	//random number used to generate random velocity and positions
	//not needed, but could be useful
	//Random num = new Random();
	//handler is used to find our player object, so we can account for collision with it
	Handler handler;
	//dimension variables for the player
	//variable for the decrease in health during contact
	private int healthDecrease = 2;
	//keeps track of how many times the weapon button was used for resizing player
	private int weaponPressCount;
	public Player4(int positionX, int positionY, int width, int height, ID id, Handler handler) {
		super(positionX, positionY, width, height, id);
		//pass in the handler for the game and set our player handler equal to it
		//now our player handler can be referenced and used to find any object in our game
		this.handler = handler;
	
	}
	//method used for collision of objects, returns true when rectangles come in contact
	public Rectangle getBounds() {
		//overlaps with Player parameters
		return new Rectangle(positionX, positionY, width, height);
	}
	
	
	
	
	//position of our player 
	public void tick() {

		positionX += velX;
		positionY += velY;
		//bounding our player within the JFrame window
		positionX=Game.clamp(positionX, 0, Game.WIDTH - 34);
		positionY=Game.clamp(positionY, 0, Game.HEIGHT - 56);
		//extra method used for the collison of objects
		collision();
	}
	private void collision() {
	}
	
	
	
	//making player visible with color and at certain position
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(positionX, positionY, width, height);
	}
	
	
	//Player1 Weapon class
	public void Weapon(GameObject Player4) {

	}
	

}
