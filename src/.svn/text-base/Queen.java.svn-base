import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;




public final class Queen extends Piece {
	
	public Queen(Square _occupying, String _color) {
		super(_occupying, _color);
		
		if(getColor() == "white") {
			this.icon = new ImageIcon("images/whitequeen.png");
		}
		else if(getColor() == "black") {
			this.icon = new ImageIcon("images/blackqueen.png");
		}
	}

	public List<Point> getPossibleMoves() {
		List<Point> moves = new ArrayList<Point>();
		
		Point moveIterator = new Point(occupying.getPosition());
		int startx = moveIterator.x;
		int starty = moveIterator.y;
		
		getHorizRight(moves, moveIterator, startx, starty);
		getHorizLeft(moves, moveIterator, startx, starty);
		getVertUp(moves, moveIterator, startx, starty);
		getVertDown(moves, moveIterator, startx, starty);
		getDiagUpRight(moves, moveIterator, startx, starty);
		getDiagDownRight(moves, moveIterator, startx, starty);
		getDiagUpLeft(moves, moveIterator, startx, starty);
		getDiagDownLeft(moves, moveIterator, startx, starty);
		
		moveIterator.x = startx;
		moveIterator.y = starty;
		
		return moves;
	}
}
