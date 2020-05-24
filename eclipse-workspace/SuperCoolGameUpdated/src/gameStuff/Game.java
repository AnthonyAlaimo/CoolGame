package gameStuff;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -240840600533728354L;
	//sets the dimensions of the JFrame window
	public static final int WIDTH = 640, HEIGHT= WIDTH/ 12*9;
	//initialize our thread
	private Thread thread;
	private boolean running = false;
	//random number used to spawn objects in the game
	private Random num;
	//Initialize our handler which will create our player and enemy objects 
	private Handler handler;
	//initialize our HUD for Player1 and Player2
	private HUD hud;
	private HUD2 hud2;
	//
	private StartScreen SS;
	private Graphics g;

	
	
	
	public Game() {
		//recreate a handler to deal with all the objects of the game
		//must be initialize a handler before window, because our window is creating an instance of the handler
		handler = new Handler();
		//tells the game we will be using keys, so it will now look for the
		//this instance of our game will use keys
		this.addKeyListener(new KeyInput(handler));
		//initialize our JFrame window
		new Window(WIDTH, HEIGHT, "Title", this);
		//variable used to start the game
		SS = new StartScreen();
		//created the HUD for player 1 and 2
		hud = new HUD();
		hud2 = new HUD2();
		//Initialize our random number
		num = new Random();
		//adding player objects into game, with ID at specified position
		//50 and 100 are the coordinates the player will spawn at
		//moved to keyboard class, will initilaze the player when the game begins
		//handler.addObject(new Player(50, 100, 32, 32, ID.Player, handler));
		//550 and 100 or the position the play will spawn in and 24, 24 are the players dimensions
		//CREATING THE PLAYER IN KEYBOARD CLASS WHEN WE HIT THE SPACEBAR THE GAME BEGINS AND THE BOSS APPEARS
		//handler.addObject(new Player2(550, 100, 24, 24, ID.Player2, handler));
		//Add enemeis into our game
//		for (int i = 0; i < 10; i ++) {
//			/*num is a random generated number which will be randomly generated within
//			 * the range given. (i.e the x component is a Random number within the WIDTH) */
//			handler.addObject(new Enemy(num.nextInt(WIDTH), num.nextInt(HEIGHT), 10, 10, ID.Enemy));
//		}
	}
	
	public synchronized void start() {
		//thread to start the program
		thread = new Thread(this);
		thread.start();
		running = true; 
	}
	
	public synchronized void stop() {
		//stopping the thread 
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Don't quite understand it, but it makes the game run
	public void run() {
		//when the game window opens we don't have to click on it to play, keyboard
		//inputs will switch to that screen originally
		this.requestFocus();
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
		
		
	}
	private void render() {
		//control fps
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		//To set the color of the JFrame
		g = bs.getDrawGraphics();
		//g is a graphics object used to fill the color of our JFrame
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//render the starting screen of game
		SS.render(g);
		if (KeyInput.spaceBarClicked == 1) {
			SS.remove(g);
		}
		//render the handler objects into the game
		handler.render(g);
		//render our hud into th3 game
		//player1
		hud.render(g);
		//player2
		hud2.render(g);
		//gameover screen and victory screen
		if (HUD.HEALTH == 0) {
			g.setColor(Color.black);
			g.drawRect(0, 0, 640, 640/ 12*9);
			g.fillRect(0, 0, 640, 640/12*9);
			g.setColor(Color.red);
			g.drawString("GAME OVER", 280, 180);
			handler.removeAll();
		}
		//if the level countis a multiple of 10 a new boss will spawn and graphics will reset
		if (HUD.levelCount %10 == 0){
			//every 10 levels a new Boss spawns	
			if(HUD.levelCount == 10) {
				handler.removeBoss();
				handler.addObject(new Boss2(550, 100, 32, 32, ID.Boss2, handler));
			}else if(HUD.levelCount == 20) {
				handler.removeBoss();
				handler.addObject(new Boss3(550, 100, 24, 24, ID.Boss3, handler));
			}else if(HUD.levelCount == 30) {
				handler.removeBoss();
				handler.addObject(new Boss4(550, 100, 24, 24, ID.Boss4, handler));
			}else if(HUD.levelCount == 40) {
				handler.removeBoss();
				handler.addObject(new Boss5(550, 100, 24, 24, ID.Boss5, handler));
			}
		}
		if(HUD.levelCount == 50) {
			g.setColor(Color.white);
			g.drawRect(0, 0, 640, 640/ 12*9);
			g.fillRect(0, 0, 640, 640/12*9);
			g.setColor(Color.YELLOW);
			g.drawString("YOU'VE WON", 280, 180);
			handler.removeAll();
		}
		g.dispose();
		bs.show();
	}
	//used to bound our JFrame window
	public static int clamp(int value, int min, int max) {
		if(value >= max) {
			return value = max;
		}else if(value <= min) {
			return value = min;
		}else{
			return value;
		}
	}
	
	
	
	public static void main(String args[]) {
		new Game();
	}

}
 