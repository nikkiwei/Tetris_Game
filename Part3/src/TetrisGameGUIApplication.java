import javax.swing.JFrame;

/**
 * Command line version of the GUI Tetris game.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisGameGUIApplication {
	
	/** Set the width of the frame*/
	public static final int FRAME_WIDTH = 600;
	
	/** Set the height of the frame*/
	public static final int FRAME_HEIGHT = 1000;
	
	/**
	 * Creates and draws the frame for the game. Start the game.
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		// create a frame to hold the game panel
		JFrame gameFrame = new JFrame("Tetris");
		
		// add the game panel
		gameFrame.add(new TetrisGameGUIController());
		
		// set size
		gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// exit normally on closing the window
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// show frame
		gameFrame.setVisible(true);
	}
}
