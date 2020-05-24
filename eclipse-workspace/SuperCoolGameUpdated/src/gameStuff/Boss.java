package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
//Our player class, where we set the features of our player
public class Boss extends GameObject{
	
	
	Random num = new Random();
	Handler handler;
	//dimension variables for the player
	private int width = 24;
	private int height = 24;
	
	
	public Boss(int positionX, int positionY, int width, int height, ID id, Handler handler) {
		super(positionX, positionY, width, height, id);
		//pass in the handler for the game and set our player handler equal to it
		//now our player handler can be referenced and used to find any object in our game
		this.handler = handler;
		velX = num.nextInt(5) + 1;
		velY = num.nextInt(5) + 1;
		
	
	}
	//method used for collision of objects, returns true when rectangles come in contact
	public Rectangle getBounds() {
		//overlaps with Player parameters
		return new Rectangle(positionX, positionY, width, height);
	}
	public void tick() {
		positionX += velX;
		positionY += velY;
		//movement for boss character
		if (positionY <=-30 || positionY >= (650/ 12*9)) {
			velY = -1*velY;
		}else if(positionX <=-30 || positionX >= 650) {
			velX = -1*velX;
		}
		//bounding player2 within our JFrame window
//		positionX=Game.clamp(positionX, 0, Game.WIDTH - 34);
//		positionY=Game.clamp(positionY, 0, Game.HEIGHT - 56);
		collision();
	}
	
	private void collision() {
		for(int CurrentObject = 0; CurrentObject < handler.object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and makes it run
			//updates all the game objects
			//this is for collision between the player and enemy objects enemy objects
			GameObject EnemyObject = handler.object.get(CurrentObject);
			if (EnemyObject.getID() == ID.Enemy) {
				if(getBounds().intersects(EnemyObject.getBounds())) {
					HUD2.HEALTH += 1;
				}
			//IF PLAYER1 ATTACKS PLAYER2, THEN P2 GOING TO GET F'ED UP
			}else if (EnemyObject.getID() == ID.Player || EnemyObject.getID() == ID.Player2 || 
					EnemyObject.getID() == ID.Player3 || EnemyObject.getID() == ID.Player4) {
				if(getBounds().intersects(EnemyObject.getBounds())) {
					if ((HUD2.HEALTH - 5) < 0) {
						HUD2.HEALTH = 0;
					}else {
						HUD2.HEALTH -= 5;
					}
				}
			}
		}
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(positionX, positionY, width, height);
		//this.g = g;
	}
	
	//Player2 Weapon class
	public void Weapon(GameObject Player1) {
		//making P2 FASSSSTTT
		//velX = velX*2;
		//velY = velY*2;
		//SUMMONS ENEMY OBJECTS WHICH HEAL P2 WHEN CONTACTED, and damage P1 when contacted
		if (Handler.enemyCount < 3) {
			handler.addObject(new Enemy(num.nextInt(640), num.nextInt(640/12*9), 12, 12, ID.Enemy));
		//add a gap in between enemyCounts to prevent summoning more enemies before the next level is acquired
		}else if (Handler.enemyCount >= 3 && Handler.enemyCount < 5){
			if (HUD.levelCount == 1) {
				handler.addObject(new Enemy2(num.nextInt(640), num.nextInt(640/12*9), 8, 8, ID.Enemy2));
			}
		}else if (Handler.enemyCount >= 5 && Handler.enemyCount < 7) {
			if (HUD.levelCount == 2) {
				handler.addObject(new Enemy3(num.nextInt(640), num.nextInt(640/12*9), 20, 20, ID.Enemy3));
			}
		}
	}

}
