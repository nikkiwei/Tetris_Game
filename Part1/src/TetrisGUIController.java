import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.Timer;

/**
 * Change the model and the view based on user input
 * @author Nikki Wei
 * @version skeleton
 */

public class TetrisGUIController extends JComponent implements KeyListener, ActionListener {
	
	// instance of TetrisBoard, control the board model
    private TetrisBoard gameBoard;
		
	// instance of TetrisPiece, control the piece model
    private TetrisPiece currentPiece;
		
	// remember the current location of the piece
    private int location;
		
	// remember the current score
    private int score;
    
    // automate the falling of pieces
    private Timer timer;
		
	/**
	 * Constructor: starts the game when run
	 * create a new TetrisBoard, assign it to gameBoard
	 * Call createNewPiece method
	 * this score equals to the updating score
	 * @param score pass the updated score to view class and print it out
	 */
	public TetrisGUIController(int score) {
		
	}
		
	/**
	 * Call updateBoard method
	 * Call updateLine method
	 * Call paintBoard method
	 * @param g Graphics object to draw on
	 */
	public void paint(Graphics g) {
			
	}
		
	/**
	 * Paint the board and the pieces.
	 * loop through the gameBoard.
	 * If the element value in the board array is false, paint a framed rectangle.
	 * If the element value is true, paint a filled rectangle and a framed rectangle
	 * @param g Graphics object to draw on
	 */
	public void paintBoard(Graphics g) {
		
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
	 * initialize the timer, set initial delay, call start method on the timer
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
	 * Call repaint method
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

	/**
	 * If the game is over, create a new board
	 * If the piece is landed, create a new piece
	 * Otherwise, move the piece down one block
	 * Call repaint method
	 * @param e the current state of the action
	 */
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
