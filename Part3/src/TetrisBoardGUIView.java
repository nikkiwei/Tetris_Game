import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * The TetrisBoardGUIView class creates a GUI view of a TetrisBoard.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisBoardGUIView extends JComponent {
	
	// to remember the board passed in through parameter
	private TetrisBoard board;
	
	/**
	 * Constructor for the TetrisBoardGUIView
	 * @param b a TetrisBoard
	 */
	public TetrisBoardGUIView(TetrisBoard b) {
		board = b;
	}
	
	/**
	 * Paint the game
	 * @param g Graphics object to paint on
	 */
	public void paint(Graphics g) {
		
		// compute the appropriate block size and paint the board outline
		int blockSize = computeBlockSize();
		paintBoardOutline(g, blockSize);
		
		// Get the board out of the model,
		// loop through board and paint blocks based on board contents
		boolean[][] gameBoard = board.getBlockMatrix();
		
		for (int i = 0; i < gameBoard.length; i ++) {
			for (int j = 0; j < gameBoard[i].length; j ++) {
				paintBlock(g, i, j, blockSize);
			}
		}
	}
	
	/**
	 * Paint the board outline
	 * @param g Graphics object to paint on
	 * @param blockSize the size of each block
	 */
	private void paintBoardOutline(Graphics g, int blockSize) {
		g.drawRect(0, 0, blockSize*10, blockSize*18);
	}
	
	/**
	 * Paint the block at grid row, grid column
	 * @param g Graphics object to paint on
	 * @param row the grid row the block is in
	 * @param col the grid column the block is in
	 * @param blockSize the size of each block
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		// check if there should be a block in a certain row and col of the board
		if (board.hasBlock(row, col)) {
			g.setColor(Color.PINK);
			g.fillRect(col*blockSize, row*blockSize, blockSize, blockSize);
			g.setColor(Color.BLACK);
			g.drawRect(col*blockSize, row*blockSize, blockSize, blockSize);
		}
	}
	
	/**
	 * Compute the best block size for the current width and height
	 * @return the size of the block
	 */
	private int computeBlockSize() {
		int blockSize = this.getHeight()/18;
		return blockSize;
	}
}
