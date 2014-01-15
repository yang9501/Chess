import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller implements ActionListener {
	
	private Model model;
	private View view;
	private Square selectedSquare;
	private String turn;
	private Game game;
	
	public Controller(Model model, View view, Game game) {
		this.setModel(model);
		this.setView(view);
		this.setGame(game);
		this.setTurn("white");
		this.setSelectedSquare(null);
		model.addActionListeners(this);
		view.addActionListeners(this);
	}
	
	
	/*  Details what happens when an action is performed on various parts of the chess game
	 * @param e the event in question
	 */
	public void actionPerformed(ActionEvent e) {

		String action_com = e.getActionCommand();
		if(action_com == "square") {
			isClicked((Square) e.getSource());  //passes a Object that the even occurred on typecasted to a Square into the isClicked() function
		}
		
		if(action_com == "restart") {
			boolean restarted = view.promptRestart();
			if(restarted == true) {
				game.sendPacket(null, true, false, false, false, false, false, false);
			}
		}
		
		if(action_com == "forfeit") {
			if((this.getTurn() == getGame().getConnectable().getColor())) {
				boolean forfeited = view.promptForfeit();
				if(forfeited == true) {
					resetBoard();
					game.sendPacket(null, false, false, true, false, false, false, false);
				}
			}
		}
	
		if(action_com == "undo") {
			if((this.getTurn() != getGame().getConnectable().getColor())) {  //can only undo during an opponents turn BEFORE they make a move
				boolean undo = view.promptUndo();
				if(undo == true) {
					if(model.undo()) {
						if(getSelectedSquare() != null) {
							deselect(selectedSquare);
						}
						switchTurns();
						game.sendPacket(null, false, false, false, true, false, false, false);
					}
				}
			}
		}
		if(action_com == "exit") {
			boolean exit = view.promptExit();
			if(exit == true) {
				game.sendPacket(null, false, false, false, false, true, false, false);
				view.close();
			}
		}
		if(action_com == "custom") {
			boolean restartedCustom = view.promptRestartCustom();
			if(restartedCustom == true) {
				game.sendPacket(null, false, false, false, false, false, true, false);
			}
		}
	}
	
	/**
	 * Resets the Board to the default starting position
	 */
	public void resetBoard() {
		this.setModel(new Model(model.getWhiteScore(), model.getBlackScore(), false));
		this.setTurn("white");
		view.turnSwitchDisplay("white");
		this.setSelectedSquare(null);
		model.addActionListeners(this);
		view.resetBoardPanel(getModel().getBoard());
	}
	
	/**
	 * Resets the board with custom pieces
	 */
	public void resetCustomBoard() {
		this.setModel(new Model(model.getWhiteScore(), model.getBlackScore(), true));
		this.setTurn("white");
		view.turnSwitchDisplay("white");
		this.setSelectedSquare(null);
		model.addActionListeners(this);
		view.resetBoardPanel(getModel().getBoard());
	}

	/** Handles what happens when a Square is clicked
	 * @param square The square that is clicked
	 */
	public void isClicked(Square square) {  
		if(getSelectedSquare() == null) {
			if(square.getOccupier() != null) { 		//if there is a piece on the square
				if(checkProperTurn(square)) {  		//and if the piece clicked is the same color as the owner of the current turn
					select(square);
				}
			}
		}
		else if(getSelectedSquare() != null) {
			if(getSelectedSquare() == square) {
				deselect(square);
			}
			else if(square.isHighlighted()) {
				game.sendPacket(new Command(selectedSquare.getPosition().getLocation(), square.getPosition().getLocation()), false, false, false, false, false, false, false); //SEND THE PACKET
				move(selectedSquare.getPosition(), square.getPosition()); 

				if(getSelectedSquare() != null) {
					deselect(getSelectedSquare());
				}
			}
		}
	}
	
	/** Highlights the selected square and all it's possible legal moves
	 * @param square the Square to be highlighted
	 */
	public void select(Square square) {
		square.setBackground(Color.green);
		
		setSelectedSquare(square);    //set selected square to square
		
		List<Point> moves = square.getOccupier().getFilteredMoves();  //get possible moves
		
		for(Point p : moves) {			//highlight possible moves with double for loop
			model.getBoard().getSquare(p).setBackground(Color.green);
			model.getBoard().getSquare(p).setHighlighted(true);
		}		
	}
	
	/** This function is called when a piece is to be deselected.  Also unhighlightes the entire board
	 * @param square The Square to unhighlight
	 */
	public void deselect(Square square) {
		square.setBackground(square.getOrigColor());
		
		setSelectedSquare(null);					//set selected square to null
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				model.getBoard().getSquare(new Point(i, j)).setBackground(model.getBoard().getSquare(new Point(i, j)).getOrigColor());
				model.getBoard().getSquare(new Point(i, j)).setHighlighted(false);
			}
		}
	}

	/** Moves the Piece from a start point to an end point
	 * @param from the start point
	 * @param to the end point
	 */
	public void move(Point from, Point to) {
		model.move(from, to); 				//move the piece under legal conditions
		switchTurns();						//switch the turn color
		testGameStatus(getTurn());			//test whether the move placed the switched turn color under check, checkmate, or stalemate
	}
	
	/** Given a side's color it tests whether that side is in check, stalemated, or checkmated
	 * @param turn the side's color in question
	 */
	public void testGameStatus(String turn) { 		 //tests for check, checkmate, stalemate, etc and notifies user with popups
		if(model.getBoard().isCheckmate(turn)) {		//if the turn is in check
			view.notifyCheckmate(turn);  					//send to View pop up a "checkmated" notification add one point to the winning side's score
			resetBoard();
			view.resetBoardPanel(getModel().getBoard());
			return;
		}
		
		if(model.getBoard().isStalemate(turn)) {
			view.notifyStalemate();
			resetBoard();
			view.resetBoardPanel(getModel().getBoard());
			return;
		}
		
		if(model.getBoard().isChecked(turn)) {
			view.notifyChecked(turn);
			return;
		}
	}
	
	/**
	 * Switches the turns, then updates the view
	 */
	public void switchTurns() {
		if(this.getTurn() == "white") {
			this.setTurn("black");
			view.turnSwitchDisplay("black");  //call a function in view to notify which turn it is
		}
		else if(this.getTurn() == "black") {
			this.setTurn("white");
			view.turnSwitchDisplay("white");
		}
	}
	
	/** Tests if the Piece on the Square is the same color as the current turn, which allows it to be moved
	 * @param test The Square that contains the piece to be tested
	 * @return whether the piece is the same color as the current turn
	 */
	public boolean checkProperTurn(Square test) {
		if((test.getOccupier().getColor() == this.getTurn()) && (this.getTurn() == getGame().getConnectable().getColor())) {
			return true;
		}
		return false;
	}
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public Square getSelectedSquare() {
		return selectedSquare;
	}

	public void setSelectedSquare(Square selectedSquare) {
		this.selectedSquare = selectedSquare;
	}


	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
