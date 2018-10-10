/**
 * TetrisSquare represents Tetris O shape.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisSquare extends TetrisPiece {
	
	/**
	 * Constructor for O-shaped tetris piece
	 */
	public TetrisSquare() {
		
		super();
		
		// loop through the four rotation states
		for (int r = 0; r < filledSquares.length; r ++) {
			filledSquares[r][0][1] = true;
			filledSquares[r][1][1] = true;
			filledSquares[r][1][0] = true;
			filledSquares[r][0][0] = true;
		}
	}
}
