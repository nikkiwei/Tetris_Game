import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TetrisGameTextController plays Tetris from the command line,
 * printing the game after each move.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisGameTextController {
	
	// an instance of TetrisGame
	private TetrisGame game;
	
	// an instance of TetrisBoardTextView
	private TetrisBoardTextView view;
	
	/**
	 * Constructor for the controller
	 */
	public TetrisGameTextController() {
		game = new TetrisGame();
		view = new TetrisBoardTextView(game.getTetrisBoard());
		readInput();
	}
	
	/**
	 * Get input from the user, looping until the user types "Quit"
	 */
	private void readInput() {

		// wrap input stream read input from user
		BufferedReader in = 
				new BufferedReader( new InputStreamReader( System.in ) );

		// prompt the user for input
		System.out.println( "Please enter a move (l,r,d,z,x) or type Quit to end." ); 

		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;

			// loop until the user types "Quit"
			do {

				// try to read a line
				// this function potentially throws an IOException
				line = in.readLine(); 

				// attempt to parse the string entered by the user
				try 
				{
					// print resulting total
					System.out.println("Number of lines cleared: " + game.getNumLines()
							+ "\nNumber of Tetrises cleared: " + game.getNumTetrises());
					
					// call the moveEntered function with user argument
					moveEntered(line);
 
				}
				finally {}
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Call printBoard on view to refresh the display of the game
	 */
	private void refreshDisplay() {
		view.printBoard();
	}
	
	/**
	 * Move the piece according to user input
	 * @param move the String user typed in
	 */
	private void moveEntered(String move) {
		
		if (move.equals("r")) {
			game.attemptMove(0);
		}
		else if (move.equals("l")) {
			game.attemptMove(1);
		}
		else if (move.equals("d")) {
			game.attemptMove(2);
		}
		else if (move.equals("x")) {
			game.attemptMove(3);
		}
		else if (move.equals("z")) {
			game.attemptMove(4);
		}
		
		refreshDisplay();
	}
}
