import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * TetrisGameGUIController plays Tetris game, update the view after each move
 * 
 * @author Nikki Wei
 * @version 1
 */

public class TetrisGameGUIController extends JPanel implements KeyListener {
	
	/**The default drop rate of the pieces*/
	public static final int DEFAULT_DROP_RATE = 1000;
	
	// an instance of TetrisGame
	private TetrisGame game;
	
	// an instance of TetrisBoardGUIView
	private TetrisBoardGUIView view;
	
	// an instance of TetrisBoard
	private TetrisBoard gameBoard;
	
	// the JLabel that holds the cleared lines score
	private JLabel linesLabel;
	
	// the JLabel that holds the cleared tetrises score
	private JLabel tetrisesLabel;
	
	// animate the falling of pieces
	private Timer gameTimer;
	
	/**
	 * Constructor for TetrisGameGUIController
	 */
	public TetrisGameGUIController() {
		
		// set the layout to be box-layout
		super ();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// initiate the game, the board, and the view
		game = new TetrisGame();
		gameBoard = game.getTetrisBoard();
		view = new TetrisBoardGUIView(gameBoard);
		
		setFocusable(true);
		addKeyListener(this);
		
		// set up original display
		createScore();
		createView();
		refreshDisplay();
		setUpTimer();
	}
	
	/**
	 * Set up the timer to animate the falling of pieces
	 */
	private void setUpTimer() {

		ActionListener drop = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent eve) {
				if (gameBoard.moveDown()) {
					gameBoard.updateCurrentRow(1);
					refreshDisplay();
				}
				else {
					game.endRound();
					((Timer) eve.getSource()).restart();
				}
			}
		};
		gameTimer = new Timer(DEFAULT_DROP_RATE, drop);
		gameTimer.setInitialDelay(0);
		gameTimer.start();
	}
	
	/**
	 * Add the view component to this panel
	 */
	private void createView() {
		this.add(view);
	}
	
	/**
	 * Add the scores labels to this panel
	 */
	private void createScore() {
		linesLabel = new JLabel("Lines cleared                            " + game.getNumLines());
		tetrisesLabel = new JLabel("Tetrises cleared                        " + game.getNumTetrises());
		this.add(linesLabel);
		this.add(tetrisesLabel);
	}
	
	/**
	 * Update the scores and the view
	 */
	private void refreshDisplay() {
		linesLabel.setText("Lines cleared                            " + game.getNumLines());
		tetrisesLabel.setText("Tetrises cleared                        " + game.getNumTetrises());
		view.repaint();
	}
	
	/**
	 * Handle the key-pressed event
	 * @param e the current state of the key
	 */
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_RIGHT) {
			game.attemptMove(0);
		}
		else if (key == KeyEvent.VK_LEFT) {
			game.attemptMove(1);
		}
		else if (key == KeyEvent.VK_DOWN) {
			game.attemptMove(2);
		}
		else if (key == KeyEvent.VK_X) {
			game.attemptMove(3);
		}
		else if (key == KeyEvent.VK_Z) {
			game.attemptMove(4);
		}
		refreshDisplay();
	}
	
	/**
	 * Handle the key-released event
	 * @param e the current state of the key
	 */
	public void keyReleased(KeyEvent e) {}
	
	/**
	 * Handle the key-typed event
	 * @param e the current state of the key
	 */
	public void keyTyped(KeyEvent e) {}
}
