package gameStuff;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	//use a linked list to set the characteristics of all of the game objects
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	//enemy counter
	public static int enemyCount;
	
	public void tick() {
		//loop through all the game objects
		for(int CurrentObject = 0; CurrentObject < object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and makes it run
			//updates all the game objects
			GameObject tempObject = object.get(CurrentObject);
			tempObject.tick();
		}
	}
	
	
	public void render(Graphics g) {
		//renders all of the game objects
		for(int CurrentObject = 0; CurrentObject < object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and renders it
			GameObject tempObject = object.get(CurrentObject);
			tempObject.render(g);
		}
	}
	
	
	//add a GameObject to our linked list
	public void addObject(GameObject GObject) {
		this.object.add(GObject);
		//each time the game object added is an enemy, we add to our enemyCount
		if (GObject.getID() == ID.Enemy || GObject.getID() == ID.Enemy2 || GObject.getID() == ID.Enemy3) {
			enemyCount += 1;
		}
	}
	//remove a GameObject from our linked list
	public void removeObject(GameObject GObject) {
		this.object.remove(GObject);
	}
	
	public void removeAll() {
		for(int CurrentObject = 0; CurrentObject < object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and renders it
			this.object.remove(CurrentObject);
		}
	}
	
	public void removeBoss() {
		for(int CurrentObject = 0; CurrentObject < object.size(); CurrentObject++) {
			if (object.get(CurrentObject).getID() != ID.Player) {
			//set a temporary variable which gets the ID of the current variable and renders it
				this.object.remove(CurrentObject);
			}
		}
	}
}
