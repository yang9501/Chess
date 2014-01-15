import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Soldier extends Piece {

	public Soldier(Square _occupying, String _color) {
		super(_occupying, _color);
		
		if(getColor() == "white") {
			this.icon = new ImageIcon("images/whitesoldier.png");
		}
		else if(getColor() == "black") {
			this.icon = new ImageIcon("images/blacksoldier.png");
		}
	}

	public List<Point> getPossibleMoves() {
		
		List<Point> moves = new ArrayList<Point>();
		
		Point moveIterator = new Point(occupying.getPosition());
		
		if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() == "black") {
			//up
			if(moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x, moveIterator.y + 1));
				}
			}
			if(moveIterator.y > 3) {
				getHorizMovement(moves, moveIterator);
			}
		}
		
		if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() == "white") {
			//down
			if(moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x, moveIterator.y - 1));
				}
			}
			if(moveIterator.y < 4) {
				getHorizMovement(moves, moveIterator);
			}
		}
		
		return moves;
	}

	private void getHorizMovement(List<Point> moves, Point moveIterator) {
		if(moveIterator.x + 1 <= 7) {
			if(occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x + 1, moveIterator.y));
			}
		}
		if(moveIterator.x - 1 >= 0) {
			if(occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x - 1, moveIterator.y));
			}
		}
	}
	
	

}
