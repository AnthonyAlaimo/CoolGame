package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
//Our player class, where we set the features of our player
public class Player2 extends GameObject{
	
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
	public Player2(int positionX, int positionY, int width, int height, ID id, Handler handler) {
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
		for(int CurrentObject = 0; CurrentObject < handler.object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and makes it run
			//updates all the game objects
			//this is for collision between the player and enemy objects enemy objects
			GameObject EnemyObject = handler.object.get(CurrentObject);
			if (EnemyObject.getID() == ID.Enemy || EnemyObject.getID() == ID.Enemy2 || EnemyObject.getID() == ID.Enemy3) {
				if(getBounds().intersects(EnemyObject.getBounds())) {
					HUD.HEALTH -= healthDecrease;
				}
			}
		}
	}
	
	
	
	//making player visible with color and at certain position
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(positionX, positionY, width, height);
	}
	
	
	//Player1 Weapon class
	public void Weapon(GameObject Player2) {
		//3 copies max
		if (weaponPressCount < 2) {
			//duplication, player can create multiple copies of itself, the risk is
			//both copies will decrease the health bar
			//breaks the game when adding a second copy?
			//handler.addObject(Player2);
			weaponPressCount += 1;
		}
	}
	

}
