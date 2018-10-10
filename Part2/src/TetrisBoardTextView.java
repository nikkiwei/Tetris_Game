/**
 * TetrisBoardTextView prints view of a TetrisBoard.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisBoardTextView {
	
	// an instance of the TetrisBoard
	private TetrisBoard board;
	
	/**
	 * Constructor for the view of tetris board
	 * @param b pass the value of TetrisBoard through parameter
	 */
	public TetrisBoardTextView(TetrisBoard b) {
		board = b;
	}
	
	/**
	 * Print the tetris board to the console
	 */
	public void printBoard() {

		// Get the board out of the model,
		// loop through board and get appropriate characters based on board contents
		boolean[][] gameBoard = board.getBlockMatrix();

		// add in the grid lines
		System.out.print("----------");

		for (int i = 0; i < gameBoard.length; i ++) {
			System.out.print("\n");
			for (int j = 0; j < gameBoard[i].length; j ++) {

				// check if there should be a block on the board
				if (board.hasBlock(i, j)) {
					System.out.print("X");
				}
				else {
					System.out.print(" ");
				}
			}
		}
		// add in the grid lines
		System.out.print("\n----------\n");
	}
}
