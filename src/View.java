import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View {
	
	JFrame view;
	private int whiteScoreValue;
	private int blackScoreValue;
	private String currTurn;
	private Game game;
	private String side;
	
	JPanel mainPanel, infoBox, scoreBox, turnBox, boardPanel, sideBox;
	JLabel whiteScore, blackScore, turnTitle, turn, sideTitle, sideText; 
	JMenuBar menuBar;
	JMenu gameOptions;
	JMenuItem restart, forfeit, undo, exit, restartCustom;
	
	public View(Board board, Game game, String color) {
		setCurrTurn("white");
		setWhiteScoreValue(0);
		setBlackScoreValue(0);
		boardPanel = board;
		setSide(color);
		createAndShowGUI();
		setGame(game);
		
	}

	/**
	 *  Creates and shows the GUI
	 */
	public void createAndShowGUI() {
		view = new JFrame("Chess");
		view.getContentPane().add(createPanels());
		view.setJMenuBar(createMenu());
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.pack();
		view.setVisible(true);
	}

	/** Creates the Menu to be added to the GUI
	 * @return The menu to be added to the GUI
	 */
	public JMenuBar createMenu() {
		menuBar = new JMenuBar();
		
		gameOptions = new JMenu("Game Options");
		menuBar.add(gameOptions);
		
		restart = new JMenuItem("Restart");
		forfeit = new JMenuItem("Forfeit");
		undo = new JMenuItem("Undo last move");
		exit = new JMenuItem("Exit Game");
		restartCustom = new JMenuItem("Custom Restart");
		
		gameOptions.add(restart);
		gameOptions.add(restartCustom);
		gameOptions.add(forfeit);
		gameOptions.add(undo);
		gameOptions.add(exit);
		
		return menuBar;
	}

	/** Creates the Panels to be used in the GUI.  Includes the main board representation, current turn view, and the current score
	 * @return the Panels to be added to the GUI
	 */
	public JPanel createPanels() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
			infoBox = new JPanel();
			infoBox.setLayout(new BorderLayout());
					
			scoreBox = new JPanel();
			whiteScore = new JLabel("White side score: " + whiteScoreValue);
			blackScore = new JLabel("Black side score: " + blackScoreValue);
			scoreBox.add(whiteScore);
			scoreBox.add(blackScore);
					
			turnBox = new JPanel();
			turnTitle = new JLabel("Current Turn: ");
			turn = new JLabel("" + getCurrTurn());
			turnBox.add(turnTitle);
			turnBox.add(turn);
			
			sideBox = new JPanel();
			sideTitle = new JLabel("Your side is: ");
			sideText = new JLabel("" + getSide());
			sideBox.add(sideTitle);
			sideBox.add(sideText);
			
			infoBox.add(scoreBox, BorderLayout.SOUTH);
			infoBox.add(turnBox, BorderLayout.NORTH);
			infoBox.add(sideBox, BorderLayout.CENTER);
		
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(infoBox, BorderLayout.EAST);
		
		return mainPanel;
	}

	/** Given a string that describes a side (white or black), this function notifies that color of their defeat using a JOptionPane and increments the wining side's points by one
	 * @param turn  the color to notify if that side is checkmated or not
	 */
	public void notifyCheckmate(String turn) {
		JOptionPane.showMessageDialog(view, "Checkmate! " + turn + " has lost!");
		if(turn == "black") {
			incrementWhiteScore();
		}
		else if(turn == "white") {
			incrementBlackScore();
		}
	}

	/**
	 * This function notifies the players of a stalemate situation using a JOptionPane
	 */
	public void notifyStalemate() {
		JOptionPane.showMessageDialog(view, "Stalemate! The game results in a draw.");
	}

	/** Given a string that describes a side (white or black), this function notifies that color of their king being checked using a JOptionPane
	 * @param turn the color to notify if that side is checked or not
	 */
	public void notifyChecked(String turn) {
		JOptionPane.showMessageDialog(view, turn + " is in check!");
	}

	/**  Updates the currTurn JLabel view to the string argument
	 * @param string The turn to be switched to
	 */
	public void turnSwitchDisplay(String string) {
		setCurrTurn(string);
		turn.setText("" + getCurrTurn());
	}

	/** Adds ActionListeners to the restart, forfeit, and undo JMenuItems
	 * @param a the ActionListener to be added to the JMenuItems
	 */
	public void addActionListeners(ActionListener a) {
		restart.addActionListener(a);
		restart.setActionCommand("restart");
		
		forfeit.addActionListener(a);
		forfeit.setActionCommand("forfeit");
		
		undo.addActionListener(a);
		undo.setActionCommand("undo");
		
		exit.addActionListener(a);
		exit.setActionCommand("exit");
		
		restartCustom.addActionListener(a);
		restartCustom.setActionCommand("custom");
	}

	/** Creates a JOptionPane asking the user whether he/she wants to forfeit.  A boolean is sent back to the controller depending on the user's choice
	 * @return Boolean describing whether the user accepted or declined the forfeit prompt
	 */
	public boolean promptForfeit() {
		int result = JOptionPane.showConfirmDialog(view, "Are you sure you want to forfeit?", "Forfeit prompt", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			if(getCurrTurn() == "white") {
				incrementBlackScore();
			}
			if(getCurrTurn() == "black") {
				incrementWhiteScore();
			}
			return true;
		}
		return false;
	}
	
	/** Creates a JOptionPane asking the users whether they want to restart.  A boolean is sent back to the controller depending on the users' choice
	 * @return Boolean describing whether both users accepted or declined the restart prompt
	 */
	public boolean promptRestart() {
		int result = JOptionPane.showConfirmDialog(view, "Would you like to restart the game?", "Restart prompt", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	

	/** Creates a JOptionPane asking the user whether he/she wants to undo their last move.  A boolean is sent back to the controller depending on the user's choice
	 * @return Boolean describing whether the user accepted or declined the undo prompt
	 */
	public boolean promptUndo() {
		int result = JOptionPane.showConfirmDialog(view, "Would you like to undo the last move?", "Undo prompt", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/** Creates a JOptionPane asking the user whether he/she wants to exit the game.  A boolean is sent back to the controller depending on the user's choice
	 * @return Boolean whether the user accepted or declined the exit game prompt
	 */
	public boolean promptExit() {
		int result = JOptionPane.showConfirmDialog(view, "Are you sure you want to exit the game?", "Exit prompt", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	
	/** Creates a JOptionPane asking the users whether they want to restart with custom pieces.  A boolean is sent back to the controller depending on the users' choice
	 * @return Boolean describing whether both users accepted or declined the restart with custom pieces prompt
	 */
	public boolean promptRestartCustom() {
		int result = JOptionPane.showConfirmDialog(view, "Would you like to restart the game with custom pieces?", "Custom Restart prompt", JOptionPane.YES_NO_OPTION);
		
		if(result == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	/**
	 * Lets the user know that their opponent has exited the game
	 */
	public void opponentQuit() {
		JOptionPane.showMessageDialog(view, "Opponent has exited the game", "Opponent quit", JOptionPane.WARNING_MESSAGE);
	}
	
	/** This function accepts board object, removes the current board panel from the mainPanel, re-adds the new board object to the mainPanel, and revalidates the view
	 * @param boardReset the new board to replace the current board
	 */
	public void resetBoardPanel(Board boardReset) {
		mainPanel.remove(boardPanel);
		boardPanel = boardReset;
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		view.invalidate();
		view.validate();
	}
	
	/**
	 * Increments the White side's points by one, and updates the JLabel view
	 */
	public void incrementWhiteScore() {
		setWhiteScoreValue(getWhiteScoreValue() + 1);
		whiteScore.setText("White side score: " + getWhiteScoreValue());
	}

	/**
	 *  Increments the Black side's points by one, and updates the JLabel view
	 */
	public void incrementBlackScore() {
		setBlackScoreValue(getBlackScoreValue() + 1);
		blackScore.setText("Black side score: " + getBlackScoreValue());
	}
	
	/**
	 * Closes the JFrame
	 */
	void close () {
		view.setVisible(false);
		view.dispose();
	}
	
	public int getWhiteScoreValue() {
		return whiteScoreValue;
	}

	public void setWhiteScoreValue(int whiteScoreValue) {
		this.whiteScoreValue = whiteScoreValue;
	}
	
	public int getBlackScoreValue() {
		return blackScoreValue;
	}

	public void setBlackScoreValue(int blackScoreValue) {
		this.blackScoreValue = blackScoreValue;
	}

	public String getCurrTurn() {
		return currTurn;
	}

	public void setCurrTurn(String currTurn) {
		this.currTurn = currTurn;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}



}
