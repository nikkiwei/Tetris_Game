/**
 * TetrisS1 represents Tetris S shape.
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisS1 extends TetrisPiece{
	
	/**
	 * Constructor for S-shaped tetris piece
	 */
	public TetrisS1() {
		
		super();
		
		// the state of 0 degree rotation
		filledSquares[0][1][0] = true;
		filledSquares[0][1][1] = true;
		filledSquares[0][0][1] = true;
		filledSquares[0][0][2] = true;
		
		// the state of 90 degree rotation
		filledSquares[1][0][0] = true;
		filledSquares[1][1][0] = true;
		filledSquares[1][1][1] = true;
		filledSquares[1][2][1] = true;
		
		// the state of 180 degree rotation
		filledSquares[2][1][0] = true;
		filledSquares[2][1][1] = true;
		filledSquares[2][0][1] = true;
		filledSquares[2][0][2] = true;
		
		// the state of 270 degree rotation
		filledSquares[3][0][0] = true;
		filledSquares[3][1][0] = true;
		filledSquares[3][1][1] = true;
		filledSquares[3][2][1] = true;
	}
}
