/**
 * The TetrisPiece abstract class represents a piece made of 4 TetrisBlocks.
 * 
 * @author Nikki Wei
 * @version 1
 */

public abstract class TetrisPiece {
	
	// the 3-D array to hold the piece
	protected boolean[][][] filledSquares;
	
	// the current rotation of the piece
	protected int pieceRotation = 0;
	
	/**
	 * Create the initial array of the piece
	 */
	public TetrisPiece() {
		// first dimension for rotation, second for row, third for column
		filledSquares = new boolean[4][4][4];
		
		//initiate the piece array
		for (int r = 0; r < filledSquares.length; r ++) {
			for (int i = 0; i < filledSquares[r].length; i ++) {
				for (int j = 0; j < filledSquares[r][i].length; j ++) {
					filledSquares[r][i][j] = false;
				}
			}
		}
	}
	
	/**
	 * Rotate the piece clockwise
	 */
	public void rotateCW() {
		
		// if in rotation state of 270 degrees, next state would be 0 degree
		if (pieceRotation == 3) {
			pieceRotation = 0;
		}
		
		// go to next state of rotation
		else {
			pieceRotation = pieceRotation + 1;
		}
	}
	
	/**
	 * Rotate the piece counter-clockwise
	 */
	public void rotateCCW() {
		
		// if in rotation state of 0 degree, next state would be 270 degree
		if (pieceRotation == 0) {
			pieceRotation = 3;
		}
		
		// go to next state of rotation
		else {
			pieceRotation = pieceRotation - 1;
		}
	}
	
	/**
	 * Getter to get the state of rotation of the piece
	 * @return the int that represents the state of rotation
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}
	
	/**
	 * Check if a certain block in the array has true value
	 * @param rot the state of rotation
	 * @param row row number
	 * @param col column number
	 * @return true if the block is a true block
	 */
	public boolean isFilled(int rot, int row, int col) {
		if (filledSquares[rot][row][col] == true) {
			return true;
		}
		return false;
	}
}
