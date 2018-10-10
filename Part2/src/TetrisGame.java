/**
 * The TetrisGame class maintains a Tetris game.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisGame {
	
	/**moveType 0 means move right*/
	public static final int RIGHT = 0;
	
	/**moveType 1 means move left*/
	public static final int LEFT = 1;
	
	/**moveType 2 means move down*/
	public static final int DOWN = 2;
	
	/**moveType 3 means rotate clockwise*/
	public static final int CW = 3;
	
	/**moveType 4 means rotate counter-clockwise*/
	public static final int CCW = 4;
	
	// for the score
	private int numLines = 0;
	
	// for the score
	private int numTetrises = 0;
	
	// an instance of TetrisBoard
	private TetrisBoard tetrisBoard;
	
	/**
	 * Constructor of the game
	 */
	public TetrisGame() {
		tetrisBoard = new TetrisBoard();
		tetrisBoard.addNewPiece();
	}
	
	/**
	 * Try to move the current piece
	 * @param moveType what type of movement performed on the piece
	 */
	public void attemptMove(int moveType) {
		
		// Get the current piece on the board
		TetrisPiece currentPiece = tetrisBoard.getCurrentPiece();
		
		if (moveType == RIGHT && tetrisBoard.moveRight() == true) {
			tetrisBoard.updateCurrentCol(1);
		}
		else if (moveType == LEFT && tetrisBoard.moveLeft() == true) {
			tetrisBoard.updateCurrentCol(-1);
		}
		else if (moveType == DOWN && tetrisBoard.moveDown() == true) {
			tetrisBoard.updateCurrentRow(1);
		}
		else if (moveType == CW && tetrisBoard.rotateCW() == true) {
			currentPiece.rotateCW();
			tetrisBoard.updateCurrentRot();
		}
		else if (moveType == CCW && tetrisBoard.rotateCCW() == true) {
			currentPiece.rotateCCW();
			tetrisBoard.updateCurrentRot();
		}
	}
	
	/**
	 * Performed when a piece cannot move down anymore
	 */
	private void endRound() {
		tetrisBoard.landPiece();
		tetrisBoard.addNewPiece();
	}
	
	/**
	 * If the piece cannot move down anymore, call endRound
	 * and update the number of lines cleared
	 * @return the number of lines cleared
	 */
	public int getNumLines() {
		if (tetrisBoard.moveDown() == false) {
			endRound();
			numLines = numLines + tetrisBoard.numberOfFormedLines();
		}
		return numLines;
	}
	
	/**
	 * Calculate the number of tetrises cleared
	 * @return the number of tetrises cleared
	 */
	public int getNumTetrises() {
		if (tetrisBoard.numberOfFormedLines() == 4) {
			numTetrises ++;
		}
		return numTetrises;
	}
	
	/**
	 * Get the tetris board
	 * @return an instance of the TetrisBoard
	 */
	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}
}
