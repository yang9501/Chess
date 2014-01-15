import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Elephant extends Piece {

	public Elephant(Square _occupying, String _color) {
		super(_occupying, _color);
		
		if(getColor() == "white") {
			this.icon = new ImageIcon("images/whiteelephant.png");
		}
		else if(getColor() == "black") {
			this.icon = new ImageIcon("images/blackelephant.png");
		}
	}

	
	public List<Point> getPossibleMoves() {
		
		List<Point> moves = new ArrayList<Point>();
		
		Point moveIterator = new Point(occupying.getPosition());	
		
		if(moveIterator.x - 2 >= 0 && moveIterator.y + 2 <= 7) {
			if(occupying.getBoard().getSquare(moveIterator.x - 2, moveIterator.y + 2).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x - 2, moveIterator.y + 2).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x - 2, moveIterator.y + 2)); //attacking diagonally upward and to the left
			}
		}
		if(moveIterator.x + 2 <= 7 && moveIterator.y + 2 <= 7) {
			if(occupying.getBoard().getSquare(moveIterator.x + 2, moveIterator.y + 2).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x + 2, moveIterator.y + 2).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x + 2, moveIterator.y + 2));//attacking diagonally upward and to the right
			}
		}
		
		if(moveIterator.x - 2 >= 0 && moveIterator.y - 2 >= 0) {
			if(occupying.getBoard().getSquare(moveIterator.x - 2, moveIterator.y - 2).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x - 2, moveIterator.y - 2).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x - 2, moveIterator.y - 2)); //attacking diagonally down and to the left
			}
		}
		if(moveIterator.x + 2 <= 7 && moveIterator.y - 2 >= 0) {
			if(occupying.getBoard().getSquare(moveIterator.x + 2, moveIterator.y - 2).getOccupier() == null ||
					occupying.getBoard().getSquare(moveIterator.x + 2, moveIterator.y - 2).getOccupier().getColor() != getColor()) {
				moves.add(new Point(moveIterator.x + 2, moveIterator.y - 2));//attacking diagonally down and to the right
			}
		}
		
		return moves;
	}

}
