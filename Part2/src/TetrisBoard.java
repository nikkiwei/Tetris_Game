import java.util.Random;

/**
 * The TetrisBoard class represents the model: a board on which Tetris is played;
 * it maintains the grid (the block matrix) and the current piece.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisBoard {
	
	/**Number of columns of the board*/
	public static final int NUM_COLS = 10;
	
	/**Number of rows of the board*/
	public static final int NUM_ROWS = 18;
	
	// current grid column of the piece
	private int currentCol;
	
	// current grid row of the piece
	private int currentRow;
	
	// current rotation of the piece
	private int currentRot;
	
	// the 2-D array to hold the board
	private boolean[][] blockMatrix;
	
	// current tetris piece that user can move and rotate
	private TetrisPiece currentPiece;
	
	/**
	 * Constructor for the tetris board
	 */
	public TetrisBoard() {
		initBoard();
	}
	
	/**
	 * Initialize the board array, all values are false
	 */
	private void initBoard() {
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		for (int i = 0; i < blockMatrix.length; i ++) {
			for (int j = 0; j < blockMatrix[i].length; j ++) {
				blockMatrix[i][j] = false;
			}
		}
	}
	
	/**
	 * Make landed piece a part of the board and create a new piece
	 */
	public void landPiece() {
		
		// loop through the piece array, find the filled blocks
		// and update the corresponding elements of the board
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (currentPiece.isFilled(currentRot, i, j)) {
					blockMatrix[currentRow + i][currentCol + j] = true;
				}
			}
		}
	}
	
	/**
	 * Check if moving left is a valid move
	 * @return true if moving left is a valid move
	 */
	public boolean moveLeft() {
		if (validMove(currentPiece, currentRot, currentRow, currentCol - 1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if moving right is a valid move
	 * @return true if moving right is a valid move
	 */
	public boolean moveRight() {
		if (validMove(currentPiece, currentRot, currentRow, currentCol + 1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if moving down is a valid move
	 * @return true if moving down is a valid move
	 */
	public boolean moveDown() {
		if (validMove(currentPiece, currentRot, currentRow + 1, currentCol)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if a clockwise rotation is a valid move
	 * @return true if the move is valid
	 */
	public boolean rotateCW() {
		
		// if in 270 degree state of rotation
		if (currentRot == 3) {
			if (validMove(currentPiece, 0, currentRow, currentCol)) {
				return true;
			}
		}
		
		// if in any other state of rotation
		else if (validMove(currentPiece, currentRot + 1, currentRow, currentCol)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if a counter-clockwise rotation is a valid move
	 * @return true if the move is valid
	 */
	public boolean rotateCCW() {
		
		// if in 0 degree state of rotation
		if (currentRot == 0) {
			if (validMove(currentPiece, 3, currentRow, currentCol)) {
				return true;
			}
		}
		
		// if in any other state of rotation
		else if (validMove(currentPiece, currentRot - 1, currentRow, currentCol)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Check if the attempted rotation or move will make the current piece
	 * collide with any landed pieces
	 * @param piece current piece
	 * @param rot attempted rotation state of the piece
	 * @param gridRow attempted row to move the piece to
	 * @param gridCol attempted column to move the piece to
	 * @return true if current piece collides with any landed piece
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		
		// loop through the piece array, find the filled blocks
		// and check if the attempted movement will cause collision between the filled block and any landed pieces
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (piece.isFilled(rot, i, j) && blockMatrix[gridRow + i][gridCol + j] == true) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Check if the attempted rotation or move will make the current piece
	 * move out of the boundaries of the board
	 * @param piece current piece
	 * @param rot attempted rotation state of the piece
	 * @param gridRow attempted row to move the piece to
	 * @param gridCol attempted column to move the piece to
	 * @return true if current piece is out of bounds
	 */
	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		
		// loop through the piece array, find the filled blocks
		// and check if the attempted movement will make the filled block out of bounds
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (piece.isFilled(rot, i, j)) {
					if (gridRow + i >= NUM_ROWS || gridCol + j >= NUM_COLS || gridCol + j < 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Check if the attempted rotation or move is valid
	 * @param piece current piece
	 * @param rot attempted rotation state of the piece
	 * @param gridRow attempted row to move the piece to
	 * @param gridCol attempted column to move the piece to
	 * @return true if there is no collision nor out of bounds
	 */
	private boolean validMove(TetrisPiece piece, int rot, int gridRow, int gridCol) {
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) == true
				|| detectCollision(piece, rot, gridRow, gridCol) == true) {
			return false;
		}
		return true;
	}
	
	/**
	 * Check if a block exists at a certain row and column
	 * @param row row number of the block
	 * @param col column number of the block
	 * @return true if a block exists there
	 */
	public boolean hasBlock(int row, int col) {
		
		// the landed pieces
		if (blockMatrix[row][col] == true) {
			return true;
		}
		
		// the current piece
		else {
			
			// loop through the piece array, find where the blocks should be
			// on the board, update the value of the corresponding element on board
			for (int i = 0; i < 4; i ++) {
				for (int j = 0; j < 4; j ++) {
					if (row == currentRow + i && col == currentCol + j
							&& currentPiece.isFilled(currentRot, i, j)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Add a new piece and update the instance currentPiece
	 */
	public void addNewPiece() {

		// randomly generate new piece
		if (getRandom(7) == 0) {
			currentPiece = new TetrisL1();
		}
		else if (getRandom(7) == 1) {
			currentPiece = new TetrisL2();
		}
		else if (getRandom(7) == 2) {
			currentPiece = new TetrisS1();
		}
		else if (getRandom(7) == 3) {
			currentPiece = new TetrisS2();
		}
		else if (getRandom(7) == 4) {
			currentPiece = new TetrisSquare();
		}
		else if (getRandom(7) == 5) {
			currentPiece = new TetrisStick();
		}
		else {
			currentPiece = new TetrisT();
		}
		
		// initial row, column, rotation
		currentRow = 0;
		currentCol = 2;
		currentRot = currentPiece.getPieceRotation();
	}
	
	/**
	 * Get a random int between the specified values
	 * @param max the returned value should not be higher than or equalto max
	 * @return a random number between 0 (inclusive) and max (exclusive)
	 */
	private int getRandom(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}
	
	/**
	 * If there is a full line, remove it and update the value of
	 * number of lines removed
	 * @return the number of lines removed
	 */
	public int numberOfFormedLines() {
		
		// number of lines removed
		int numLines = 0;
		
		// loop through each row in board array
		for (int i = 0; i < blockMatrix.length; i ++) {
			if (fullLine(i) == true) {
				removeLine(i);
				numLines ++;
			}
		}
		return numLines;
	}
	
	/**
	 * Check a certain to see if it is completely filled with blocks
	 * @param row the row to check
	 * @return false if any block in a certain row has a false value
	 */
	private boolean fullLine(int row) {
		
		// loop through each column in that row
		for (int j = 0; j < blockMatrix[row].length; j ++) {
			if (blockMatrix[row][j] == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Remove a row of line recursively
	 * @param row the row of line to remove
	 */
	private void removeLine(int row) {
		
		// base case
		if (row == 0) {
			for (int j = 0; j < blockMatrix[row].length; j ++) {
				blockMatrix[row][j] = false;
			}
		}
		
		// recursive case
		else {
			for (int j = 0; j < blockMatrix[row].length; j ++) {
				blockMatrix[row][j] = blockMatrix[row - 1][j];
			}
			removeLine(row - 1);
		}
		
		// loop through the board and update the values of those
		// that doesn't have a block
		for (int i = 0; i < blockMatrix.length; i ++) {
			for (int j = 0; j < blockMatrix[i].length; j ++) {
				if (hasBlock(i, j) == false) {
					blockMatrix[i][j] = false;
				}
			}
		}
	}
	
	/**
	 * Get the 2-D board array
	 * @return the 2-D array that holds the board
	 */
	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}
	
	/**
	 * Get the current piece
	 * @return the current piece that can be manipulated by the user
	 */
	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}
	
	/**
	 * Update the current grid position of the piece
	 * @param distance how far and in what direction to move the piece
	 */
	public void updateCurrentRow(int distance) {
		currentRow += distance;
	}
	
	/**
	 * Update the current grid position of the piece
	 * @param distance how far and in what direction to move the piece
	 */
	public void updateCurrentCol(int distance) {
		currentCol += distance;
	}
	
	/**
	 * Update the current rotation of the piece
	 */
	public void updateCurrentRot() {
		currentRot = currentPiece.getPieceRotation();
	}
}
