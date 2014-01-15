import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;


/**
 * @author Justin
 *
 */
public class Board extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Square[][] chessBoard;
	
	
	/**
	 * The basic constructor for the Board class. Initializes the chessBoard variable to a 2-D array of Squares
	 */
	public Board(boolean custom) {
		chessBoard = new Square[8][8];
		setLayout(new GridLayout(8, 8));
		boardInit(custom);
	}

	
	/**
	 * This function populates a chess board with pieces in their respective starting positions, and gives them initial values
	 */
	public void boardInit(boolean custom){
		removeAll();
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 8; x++) {
				
				this.chessBoard[x][y] = new Square(this, new Point(x, y));
				
				if((x + y)%2 == 0){
                    this.chessBoard[x][y].setBackground(Color.white);
                    this.chessBoard[x][y].setOrigColor(Color.white);
				}
				else{
                    this.chessBoard[x][y].setBackground(Color.black);
                    this.chessBoard[x][y].setOrigColor(Color.black);
				}
				
				Piece p = null;
				String color = null;
				
				if(y == 0 || y == 1) {
					//Since these Squares are on the white side(y = 0 and y = 1), they are given the "white" string
					color = "black";
				}
				else if(y == 6 || y == 7) {
					//Since these Squares are on the black side(y = 6 and y = 7), they are given the "black" string
					color = "white";
				}
				
				if(y == 1 || y == 6) {
					p = new Pawn(chessBoard[x][y], color);
				}
				if(y == 0 || y == 7){
					switch(x) {
					case 0: case 7:
						p = new Rook(chessBoard[x][y], color);
						break;
					case 1: case 6:
						p = new Knight(chessBoard[x][y], color);
						break;
					case 2: case 5:
						p = new Bishop(chessBoard[x][y], color);
						break;
					case 3:
						p = new Queen(chessBoard[x][y], color);
						break;
					case 4:
						p = new King(chessBoard[x][y], color);
						break;
					}
				}
				
				//putting Piece onto a Square, or leaving a Square holding null
				chessBoard[x][y].setOccupier(p);
				add(chessBoard[x][y]); //add to panel
			}
		}
		if(custom) {
			chessBoard[1][6].setOccupier(new Soldier(chessBoard[1][6], "white"));
			chessBoard[6][6].setOccupier(new Elephant(chessBoard[6][6], "white"));
			chessBoard[6][1].setOccupier(new Soldier(chessBoard[6][1], "black"));
			chessBoard[1][1].setOccupier(new Elephant(chessBoard[1][1], "black"));
		}
	}
	
	/** Moves a Piece on one location to the other, returning true if successful
	 * @param from: the initial location of the Piece to be moved
	 * @param to: the desired final destination of the Piece
	 * @return whether the move was successful
	 */
	public boolean move(Point from, Point to) {		
		
		if(from.x <= 7 && from.x >= 0 && to.x <= 7 && to.y >= 0) {
			
			Square origin = getSquare(from);
			Square destination = getSquare(to);
			if(origin.getOccupier() != null) {  
				List<Point> possibleMoves = origin.getOccupier().getPossibleMoves();
				if(possibleMoves.contains(to)) {
					if(testSelfCheck(origin, destination) == false) {
						destination.setOccupier(origin.getOccupier());
						destination.getOccupier().setOccupying(destination);
						origin.setOccupier(null);
						origin.setIcon(null);
						destination.getOccupier().setMoved(true);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Checks if a movement places the moving side's king in check. 
	 * @param from The Square of the moving Piece
	 * @param to The Square that the Piece might move to
	 * @return If the return value is true, a move by the piece puts the king in danger, and is therefore an illegal move.
		If the return value is false, this move is valid
	 */
	public boolean testSelfCheck(Square from, Square to) {
		
		boolean check;
		Piece mover = from.getOccupier();
		Piece replaced = to.getOccupier();
		String moverColor = mover.getColor();
		
		Square holdReplacedPiece = new Square(from.getBoard(), new Point(-1, -1));
		
		holdReplacedPiece.setOccupier(replaced);  //effectively the temporary variable ,could this cause an error?  do I need to create an entirely new Piece?
		to.setOccupier(mover);   //delete the piece on the to square and put the mover piece on to
		from.setOccupier(null);
		
		check = isChecked(moverColor);  //check if the mover's king is in danger
		
		if(replaced == null) {
			to.setIcon(null);
		}
		from.setOccupier(to.getOccupier());				//replace the moved piece
		to.setOccupier(holdReplacedPiece.getOccupier());  //replace the deleted piece
		return check;
	}
	
	
	/** Returns the Square at the position (x,y)
	 * @param x The x-coordinate of the desired Square to be returned
	 * @param y The y-coordinate of the desired Square to be returned
	 * @return This function returns the requested Square if it is within the bounds of the chess board, and null if it is not
	 */
	public Square getSquare(int x, int y) {
		if(x >= 0 && x <= 7 && y <= 7 && y >= 0) {
			return chessBoard[x][y];
		}
		return null;
	}
	
	/** An alternative method to return a square using a Point instead of (x, y) coordinates
	 * @param _point The Point that represents the desired Square
	 * @return This function returns the requested Square if it is within the bounds of the chess board, and null if it is not
	 */
	public Square getSquare(Point _point) {
		return getSquare(_point.x, _point.y);
	}
	
	/** Determines whether a given side is in check or not
	 * @param color The side to be tested if it's king is in check or not
	 * @return True if the given side is in check, and false if it is not
	 */
	public boolean isChecked(String color) {
		Point kingLoc = kingLocation(color);
		String opponentColor = null;
		if(color.equals("white")){
			opponentColor = "black";
		}
		else if(color.equals("black")) {
			opponentColor = "white";
		}
		
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				Piece testPiece = getSquare(x, y).getOccupier();
				
				if(testPiece != null) {
					if(testPiece.getColor().equals(opponentColor) && testPiece.getPossibleMoves().contains(kingLoc)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Determines whether a given side has any moves available
	 * @param color The side to be tested if it has any moves available
	 * @return True if the given side has any moves, false if not
	 */
	public boolean hasMoves(String color) {
		for(int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				Piece testPiece = getSquare(x, y).getOccupier();
				
				if(testPiece != null) {
					if(testPiece.getColor().equals(color)) {
						List<Point> test = testPiece.getPossibleMoves();
						if(!testPiece.getPossibleMoves().isEmpty()) {
							Square origin = testPiece.getOccupying();
							for(Point potentialMoves : test) {
								Square destination = getSquare(potentialMoves);
								if(testSelfCheck(origin, destination) == false) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/** Gives the location of a given side's king
	 * @param color The side whose king to search for
	 * @return A Point describing the location of the side's king
	 */
	public Point kingLocation(String color) {
		for(int x = 0; x < 8; x++) {
			for(int y= 0; y < 8; y++) {
				Piece testPiece = getSquare(x, y).getOccupier();
				if(testPiece != null && testPiece.getClass().equals(King.class) && testPiece.getColor().equals(color)){
					return new Point(x, y);
				}
			}
		}
		return new Point(-1, -1);
	}
	
	/** Checks whether any end game conditions for a given side have been met, and prints out the status of the game
	 * @param color The side to check end game conditions
	 */
	public boolean isStalemate(String color) {
		boolean check = isChecked(color);
		boolean hasMoves = hasMoves(color);
		
		if(check == false) {
			if(hasMoves == false) {
				return true;
			}
		}	
		return false;
	}
	
	/** Checks whether a given side has been checkmated
	 * @param color A side in a chess game
	 * @return A boolean describing whether a given side is checkmated or not
	 */
	public boolean isCheckmate(String color) {
		boolean check = isChecked(color);
		boolean hasMoves = hasMoves(color);
		
		if(check == true) {
			if(hasMoves == false) {
				return true;
			}
		}
		return false;
	}
}
