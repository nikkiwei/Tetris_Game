import java.awt.Graphics;

/**
 * Store information about the pieces
 * @author Nikki Wei
 * @version skeleton
 */

public class TetrisPiece {
	
	// Piece array to hold values
	private boolean[][] piece;
	
	// remember the location of the current piece
	private int location;
	
	// remember the shape of the peice
	private int shape;
	
	/**
	 * Constructor to create a piece
	 * call assignShape method
	 * @param shape int values correspond to different shapes
	 * @param location int value of the initial location
	 */
	public TetrisPiece (int shape, int location) {
		
	}
	
	/**
	 * Rotate the piece counter clockwise
	 */
	public void zRotate() {
		
	}
	
	/**
	 * Rotate the piece clockwise
	 */
	public void xRotate() {
		
	}
	
	/**
	 * Move the piece one block to the right
	 */
	public void moveRight() {
		
	}
	
	/**
	 * Move the piece one block to the left
	 */
	public void moveLeft() {
		
	}
	
	/**
	 * Move the piece one block downwards
	 */
	public void moveDown() {
		
	}
	
	/**
	 * Get the current location of the piece
	 * @return the location of the piece
	 */
	public int getLocation() {
		return 0;
	}
	
	/**
	 * Assign 7 different shapes to the piece
	 * If int shape is 0, make it a shape I piece
	 * If int shape is 1, make it a shape J piece
	 * If int shape is 2, make it a shape L piece
	 * If int shape is 3, make it a shape O piece
	 * If int shape is 4, make it a shape S piece
	 * If int shape is 5, make it a shape T piece
	 * If int shape is 6, make it a shape Z piece
	 */
	public void assignShape() {
		
	}
	
//	/**
//	 * Assign 7 different colors to the piece
//	 * If int shape is 0, make it a shape I piece, with color cyan
//	 * If int shape is 1, make it a shape J piece, with color blue
//	 * If int shape is 2, make it a shape L piece, with color orange
//	 * If int shape is 3, make it a shape O piece, with color yellow
//	 * If int shape is 4, make it a shape S piece, with color green
//	 * If int shape is 5, make it a shape T piece, with color purple
//	 * If int shape is 6, make it a shape Z piece, with color red
//	 * THIS METHOD ONLY IMPLEMENTED IN GUI COLOR VERSION
//	 * @param g Graphics object to draw on
//	 */
//    public void assignColor(Graphics g) {
//		
//	}
}
