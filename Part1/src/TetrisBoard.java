/**
 * Store information about the board
 * @author Nikki Wei
 * @version skeleton
 */

public class TetrisBoard {
	
	// Board array to hold values
	private boolean[][] board;
	
	/**
	 * Constructor, creates the board size
	 */
	public TetrisBoard() {
		
	}
	
	/**
	 * Get the current board
	 * @return 2D array holding the board state
	 */
	public boolean[][] getBoard() {
		return null;
	}
	
	/**
	 * Check if there is a line that can be cleared.
	 * One line can be cleared when all values in that row is true.
	 * @return true if there is such a line
	 */
	public boolean checkCompletedLine() {
		return false;
	}
	
	/**
	 * Check if the piece can move further right.
	 * One can only move the piece within the boundaries of the board without
	 * overlapping the landed pieces.
	 * @param location location of the piece we are going to move
	 * @return true if the move can be done
	 */
	public boolean attemptMoveRight(int location) {
		return false;
	}
	
	/**
	 * Check if the piece can move further left.
	 * One can only move the piece within the boundaries of the board without
	 * overlapping the landed pieces.
	 * @param location location of the piece we are going to move
	 * @return true if the move can be done
	 */
	public boolean attemptMoveLeft(int location) {
		return false;
	}
	
	/**
	 * Check if the piece can move further down.
	 * One can only move the piece within the boundaries of the board without
	 * overlapping the landed pieces.
	 * @param location location of the piece we are going to move
	 * @return true if the move can be done
	 */
	public boolean attemptMoveDown(int location) {
		return false;
	}
	
	/**
	 * Check if the piece can rotate counter clockwise.
	 * One can only move the piece within the boundaries of the board without
	 * overlapping the landed pieces.
	 * @param location location of the piece we are going to move
	 * @return true if the move can be done
	 */
	public boolean attemptZRotate(int location) {
		return false;
	}
	
	/**
	 * Check if the piece can rotate clockwise.
	 * One can only move the piece within the boundaries of the board without
	 * overlapping the landed pieces.
	 * @param location location of the piece we are going to move
	 * @return true if the move can be done
	 */
	public boolean attemptXRotate(int location) {
		return false;
	}
	
	/**
	 * Check if the game is over.
	 * Game is over when a piece hits the top row (first row), that is
	 * when one value in the top row is true
	 * @return true if the game is over
	 */
	public boolean isGameOver() {
		return false;
	}
}
