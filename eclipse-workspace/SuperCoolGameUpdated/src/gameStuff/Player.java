package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
//Our player class, where we set the features of our player
public class Player extends GameObject{
	
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
	public Player(int positionX, int positionY, int width, int height, ID id, Handler handler) {
		super(positionX, positionY, width, height, id);
		//pass in the handler for the game and set our player handler equal to it
		//now our player handler can be referenced and used to find any object in our game
		this.handler = handler;
		//velX = num.nextInt(5) + 1;
		//velY = num.nextInt(5);
		
	
	}
	//method used for collision of objects, returns true when rectangles come in contact
	public Rectangle getBounds() {
		//overlaps with Player parameters
		return new Rectangle(positionX, positionY, width, height);
	}
	
	
	
	
	//position of our player 
	public void tick() {
		//if weapon was used odd times, player will be twice as big
		//this causes a change in its size and velocity
		//size changed in weapon method
		if (weaponPressCount == 1) {
			positionX += velX*3/2;
			positionY += velY*3/2;
		}else {
			positionX += velX;
			positionY += velY;
		}
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
			}else if(EnemyObject.getID() == ID.Boss2) {
				if (HUD.HEALTH >= 10) {
					HUD.HEALTH -= 0;
				}else {
					HUD.HEALTH = 0;
				}
			}
			//character go byebye
			//if (HUD.HEALTH < 10) {
			//	handler.removeObject(EnemyObject);
			//}
		}
	}
	
	
	
	//making player visible with color and at certain position
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(positionX, positionY, width, height);
	}
	
	
	//Player1 Weapon class
	public void Weapon(GameObject Player1) {
		//restricting the increase in player1's size to double only once
		if (width < 64 && height < 64) {
			//double the players size
			Player1.setPlayerWidth(width*2);
			Player1.setPlayerHeight(height*2);
			healthDecrease = 1;
			//indicator that player is double size
			weaponPressCount = 1;
		}else if (width == 64 && height == 64) {
			Player1.setPlayerWidth(width/2);
			Player1.setPlayerHeight(height/2);
			healthDecrease = 2;
			//indicator the player is normal size
			weaponPressCount = 2;
		}
	}
	

}
