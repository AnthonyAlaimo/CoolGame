package gameStuff;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	//position of objects, player/ enemy
	protected int positionX, positionY;
	//used to refer to a player or enemy ID as seperate objects
	protected ID id;
	//speed of player object/enemy object variable
	protected int velX, velY;
	//size of object
	protected int width, height;
	
	public GameObject(int positionx, int positiony, int width, int height, ID id) {
		this.positionX = positionx;
		this.id = id;
		this.positionY = positiony;
		this.width = width;
		this.height = height;
	}
	
	//abstract methods used as a method of interface, defined with no implementation
	//but are mean't for the children classes to implement these methods however
	//appropriate to their needs
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	 
	//setter/getter methods for the position player/enemy objects
	public void setPlayerWidth(int width) {
		this.width = width;
	}
	public void setPlayerHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return positionX;
	}
	public int getY() {
		return positionY;
	}
	
	//getter and setters for player id
	public void setID(ID id) {
		this.id = id;
	}
	public ID getID() {
		return id;
	}
	
	
	//getter and setter methods for velocity
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	
}
