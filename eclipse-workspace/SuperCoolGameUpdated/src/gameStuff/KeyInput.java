package gameStuff;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	//variable to initialize the player and HUD aka its starting the game
	static int spaceBarClicked = 0;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		//when a key is clicked on the keyboard its corresponding number will be stored
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE && spaceBarClicked == 0) {
			handler.addObject(new Player(50, 100, 32, 32, ID.Player, handler));
			handler.addObject(new Boss(550, 100, 24, 24, ID.Boss, handler));
			spaceBarClicked += 1;
		//second option of chose a ble players
		}else if (key == KeyEvent.VK_Z && spaceBarClicked == 0){
			handler.addObject(new Player2(50, 100, 16, 16, ID.Player2, handler));
			handler.addObject(new Boss(550, 100, 24, 24, ID.Boss, handler));
			spaceBarClicked += 1;
		//I can create more key input options here which will allow for player choice
		//by indicating a certain button to press and the player that corresponds to it
		//we can create variety for the player and further develop the game
		}else if (key == KeyEvent.VK_X && spaceBarClicked == 0){
			handler.addObject(new Player3(50, 100, 50, 50, ID.Player3, handler));
			handler.addObject(new Boss(550, 100, 24, 24, ID.Boss, handler));
			spaceBarClicked += 1;
		}else if (key == KeyEvent.VK_C && spaceBarClicked == 0){
			handler.addObject(new Player4(50, 100, 40, 40, ID.Player4, handler));
			handler.addObject(new Boss(550, 100, 24, 24, ID.Boss, handler));
			spaceBarClicked += 1;
		}
		
		
		
		//PLAYER SELECTION 4 TOO CHOSE FROM CLICK Z,X,C,SPACEBAR TO CHOSE
		//use a loop to get the specific object in our game which is the player
		//this way we can make our key inputs correspond to our player specifically
		//and the inputs won't interfere with other objects in the game
		for (int i = 0; i < handler.object.size() ; i++) {
			//set a curObject so we can traverse through our linked list
			GameObject curObject = handler.object.get(i);
			//if its Player set its keys specific to it
			if (curObject.getID() == ID.Player) {
				//key events for player
				//every time we click w the Player will move upwards
				//s will move player downwards
				if(key == KeyEvent.VK_W) {
					curObject.setVelY(-3);
				}else if(key == KeyEvent.VK_S) {
					curObject.setVelY(3);
				//works the same as w and s keys but horizontally
				}else if(key == KeyEvent.VK_D) {
					curObject.setVelX(3);
				}else if(key == KeyEvent.VK_A) {
					curObject.setVelX(-3);
				//clicking F will stop the objects movement
				}else if(key == KeyEvent.VK_E) {
					curObject.setVelX(0);
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_F) {
					//this will be player1 weapon button
					((Player) curObject).Weapon(curObject);
				}
			}else if (curObject.getID() == ID.Player2) {
				if(key == KeyEvent.VK_W) {
					curObject.setVelY(-3);
				}else if(key == KeyEvent.VK_S) {
					curObject.setVelY(3);
				//works the same as w and s keys but horizontally
				}else if(key == KeyEvent.VK_D) {
					curObject.setVelX(3);
				}else if(key == KeyEvent.VK_A) {
					curObject.setVelX(-3);
				//clicking F will stop the objects movement
				}else if(key == KeyEvent.VK_E) {
					curObject.setVelX(0);
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_F) {
					//this will be player1 weapon button
					((Player2) curObject).Weapon(curObject);
				}
			}else if (curObject.getID() == ID.Player3) {
				if(key == KeyEvent.VK_W) {
					curObject.setVelY(-3);
				}else if(key == KeyEvent.VK_S) {
					curObject.setVelY(3);
				//works the same as w and s keys but horizontally
				}else if(key == KeyEvent.VK_D) {
					curObject.setVelX(3);
				}else if(key == KeyEvent.VK_A) {
					curObject.setVelX(-3);
				//clicking F will stop the objects movement
				}else if(key == KeyEvent.VK_E) {
					curObject.setVelX(0);
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_F) {
					//this will be player1 weapon button
					((Player3) curObject).Weapon(curObject);
				}
			}else if (curObject.getID() == ID.Player4) {
				if(key == KeyEvent.VK_W) {
					curObject.setVelY(-3);
				}else if(key == KeyEvent.VK_S) {
					curObject.setVelY(3);
				//works the same as w and s keys but horizontally
				}else if(key == KeyEvent.VK_D) {
					curObject.setVelX(3);
				}else if(key == KeyEvent.VK_A) {
					curObject.setVelX(-3);
				//clicking F will stop the objects movement
				}else if(key == KeyEvent.VK_E) {
					curObject.setVelX(0);
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_F) {
					//this will be player1 weapon button
					((Player4) curObject).Weapon(curObject);
				}
			}
			
			
////////////////////////////////////////////////////////////////////////////////
			//if its Player2 set specific keys to it
//			if (curObject.getID() == ID.Boss) {
//				//key events for player
//				//every time we click w the Player will move upwards
//				//s will move player downwards
//				if(key == KeyEvent.VK_UP) {
//					curObject.setVelY(-4);
//				}else if(key == KeyEvent.VK_DOWN) {
//					curObject.setVelY(4);
//				//works the same as w and s keys but horizontally
//				}else if(key == KeyEvent.VK_RIGHT) {
//					curObject.setVelX(4);
//				}else if(key == KeyEvent.VK_LEFT) {
//					curObject.setVelX(-4);
//				//clicking F will stop the objects movement
//				}else if(key == KeyEvent.VK_SHIFT) {
//					curObject.setVelX(0);
//					curObject.setVelY(0);
//				}else if(key == KeyEvent.VK_SLASH) {
//					//this will be player1 weapon button
//					((Boss) curObject).Weapon(curObject);
//				}
//			}
		//press this key to exit the game
		}if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void KeyReleased(KeyEvent e) {
		//in this method we want our object to stop moving once we let go of the key
		//Same code as above except we set the velocities to 0 on release
		//don't need this code if I use F as a stop button for the player
		//depends on how we want to implement the game
		/*int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size() ; i++) {
			GameObject curObject = handler.object.get(i);
			if (curObject.getID() == ID.Player) {
				if(key == KeyEvent.VK_W) {
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_S) {
					curObject.setVelY(0);
				}else if(key == KeyEvent.VK_D) {
					curObject.setVelX(0);
				}else if(key == KeyEvent.VK_A) {
					curObject.setVelX(0);
				}
			}
		}*/
	}
}
