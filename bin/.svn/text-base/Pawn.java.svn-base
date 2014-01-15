

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;




public final class Pawn extends Piece {
	
	public Pawn(Square _occupying, String _color) {
		super(_occupying, _color);
		setMoved(false);
		if(getColor() == "white") {
			this.icon = new ImageIcon("images/whitepawn.png");
		}
		else if(getColor() == "black") {
			this.icon = new ImageIcon("images/blackpawn.png");
		}
	}
	
	
	public List<Point> getPossibleMoves() {
		List<Point> moves = new ArrayList<Point>();
		
		Point moveIterator = new Point(occupying.getPosition());
		
		if(getColor() == "black") {
			if(moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 1).getOccupier() == null) {
					moves.add(new Point(moveIterator.x, moveIterator.y + 1)); //move north if pawn is not at top end of board and there is no piece on the possible Square to move to
					if(this.isMoved() == false && moveIterator.y + 2 <= 7) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 2).getOccupier() == null) {
							moves.add(new Point(moveIterator.x, moveIterator.y + 2)); //double jump at beginning, if the pawn hasn't moved yet
						}
					}
				}	
			}
			//diagonal attacks
			if(moveIterator.x - 1 >= 0 && moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y + 1).getOccupier() != null &&
						occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x - 1, moveIterator.y + 1)); //attacking diagonally upward and to the left
				}
			}
			if(moveIterator.x + 1 <= 7 && moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y + 1).getOccupier() != null &&
						occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x + 1, moveIterator.y + 1));//attacking diagonally upward and to the right
				}
			}	
		}
		
		else if(getColor() == "white") {
			if(moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 1).getOccupier() == null) {
					moves.add(new Point(moveIterator.x, moveIterator.y - 1)); //move north if pawn is not at top end of board and there is no piece on the possible Square to move to
					if(this.isMoved() == false && moveIterator.y - 2 >= 0 &&
							occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 2).getOccupier() == null) {
						moves.add(new Point(moveIterator.x, moveIterator.y - 2)); //double jump at beginning, when the pawn hasn't moved yet
					}
				}
			}
			//diagonal attacks
			if(moveIterator.x - 1 >= 0 && moveIterator.y - 1 >= 0) { 
				if(occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y - 1).getOccupier() != null &&
						occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x - 1, moveIterator.y - 1)); //attacking diagonally down and to the left
				}
			}
			if(moveIterator.x + 1 <= 7 && moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y - 1).getOccupier() != null &&
						occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x + 1, moveIterator.y - 1)); //attacking diagonally down and to the right
				}
			}	
		}
		return moves;
	}
	
	
}
