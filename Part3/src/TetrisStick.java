/**
 * TetrisStick represents Tetris I shape.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisStick extends TetrisPiece {
	
	/**
	 * Constructor for I-shaped tetris piece
	 */
	public TetrisStick() {
		
		super();
		
		// the state of 0 degree rotation
		filledSquares[0][0][0] = true;
		filledSquares[0][0][1] = true;
		filledSquares[0][0][2] = true;
		filledSquares[0][0][3] = true;
		
		// the state of 90 degree rotation
		filledSquares[1][0][0] = true;
		filledSquares[1][1][0] = true;
		filledSquares[1][2][0] = true;
		filledSquares[1][3][0] = true;
		
		// the state of 180 degree rotation
		filledSquares[2][0][0] = true;
		filledSquares[2][0][1] = true;
		filledSquares[2][0][2] = true;
		filledSquares[2][0][3] = true;
		
		// the state of 270 degree rotation
		filledSquares[3][0][0] = true;
		filledSquares[3][1][0] = true;
		filledSquares[3][2][0] = true;
		filledSquares[3][3][0] = true;
	}
}
