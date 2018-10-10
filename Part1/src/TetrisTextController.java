import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Change the model and the view based on user input
 * @author Nikki Wei
 * @version skeleton
 */

public class TetrisTextController implements KeyListener {
	
	// instance of TetrisBoard, control the board model
	private TetrisBoard gameBoard;
	
	// instance of TetrisPiece, control the piece model
	private TetrisPiece currentPiece;
	
	// instance of TetrisTextView, control the view
	private TetrisTextView textView;
	
	// remember the current location of the piece
	private int location;
	
	// remember the current score
	private int score;
	
	/**
	 * Constructor: starts the game when run
	 * create a new TetrisBoard, assign it to gameBoard
	 * create a new TetrisTextView, assign it to textView
	 * Call createNewPiece method
	 */
	public TetrisTextController() {
		
	}
	
	
	/**
	 * Call getLocation method and get the location of the current piece.
	 * Update the corresponding element of the board array to true.
	 * To achieve that, loop through the piece array, find the elements with true value
	 * and based on its location in the board, update the value of board
	 */
	public void updateBoard() {
		
	}
	
	/**
	 * If the there is a completed line, clear it.
	 * Loop through the board, if checkCompletedLine method ever returns true,
	 * update all the value in that row to match the line above
	 * and do the same thing for every line above
	 * update score
	 */
	public void updateLine( ) {
		
	}
	
	/**
	 * Generate a random int between 0(inclusive) - 7(exclusive), for shape
	 * Generate another random int between 0(inclusive) - 10(exclusive), for location
	 * Call TetrisPiece constructor and pass these values in, assign to currentPiece
	 */
	public void createNewPiece() {
		
	}
	
	/**
	 * Invoked when the key is pressed
	 * If the game is over, create a new board, piece, and view
	 * If the piece is landed, create a new piece
	 * Otherwise:
	 * If getKeyText method returns "l" and it can move left, call moveLeft on the current piece
	 * If getKeyText returns "r" and it can move right, call moveRight on the current piece
	 * If getKeyText returns "d" and it can move down, call moveDown on the current piece
	 * If getKeyText returns "z" and it can rotate counter clockwise, call zRotate on the current piece
	 * If getKeyText returns "x" and it can rotate clockwise, call xRotate on the current piece
	 * Call updateBoard method
	 * Call updateLine method
	 * Call printBoard method
	 * @param e the current state of the key
	 */
	public void keyPressed(KeyEvent e) {
		
	}
	
	/**
	 * Invoked when the key is typed
	 * @param e the current state of the key
	 */
	public void keyTyped(KeyEvent e) {}
	
	/**
	 * Invoked when the key is released
	 * @param e the current state of the key
	 */
	public void keyReleased(KeyEvent e) {}
}
