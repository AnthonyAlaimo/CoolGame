package gameStuff;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends Canvas{

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		//setting size of the JFrame
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		//Needed so the x button will correctly close the JFrame window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//prevents us from resizing the JFrame window
		frame.setResizable(false);
		//Makes the JFrame window appear in the middle of the screen rather then the top corner
		//frame.setLocationRelativeTo(null);
		//adding game class into the JFrame and setting it visible so we can see it
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}

}
