import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public final class Rook extends Piece {
	
	public Rook(Square _occupying, String _color) {
		super(_occupying, _color);
		
		if(getColor() == "white") {
			icon = new ImageIcon("images/whiterook.png");
		}
		else if(getColor() == "black") {
			icon = new ImageIcon("images/blackrook.png");
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
		
		moveIterator.x = startx;
		moveIterator.y = starty;
		
		return moves;
	}
}
