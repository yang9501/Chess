
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;



public final class King extends Piece {

		public King(Square _occupying, String _color) {
			super(_occupying, _color);
			
			if(getColor() == "white") {
				this.icon = new ImageIcon("images/whiteking.png");
			}
			else if(getColor() == "black") {
				this.icon = new ImageIcon("images/blackking.png");
			}
		}
		
		
		public List<Point> getPossibleMoves() {
			List<Point> moves = new ArrayList<Point>();
			
			Point moveIterator = occupying.getPosition();
			
			getCardinalDir(moves, moveIterator);
			getDiagDir(moves, moveIterator);
					
			return moves;
		}


		private void getDiagDir(List<Point> moves, Point moveIterator) {
			if(moveIterator.x + 1 <= 7 && moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y + 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x + 1, moveIterator.y + 1));
				}
			}
			if(moveIterator.x + 1 <= 7 && moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y - 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x + 1, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x + 1, moveIterator.y - 1));
				}
			}
			if(moveIterator.x - 1 >= 0 && moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y + 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x - 1, moveIterator.y + 1));
				}
			}
			if(moveIterator.x - 1 >= 0 && moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y - 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x - 1, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x - 1, moveIterator.y - 1));
				}
			}
		}


		private void getCardinalDir(List<Point> moves, Point moveIterator) {
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
			if(moveIterator.y + 1 <= 7) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x, moveIterator.y + 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x, moveIterator.y + 1));
				}
			}
			if(moveIterator.y - 1 >= 0) {
				if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 1).getOccupier() == null ||
						occupying.getBoard().getSquare(moveIterator.x, moveIterator.y - 1).getOccupier().getColor() != getColor()) {
					moves.add(new Point(moveIterator.x, moveIterator.y - 1));
				}
			}
		}
}
