

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;




public abstract class Piece {
		protected String color;
		protected Square occupying;
		protected boolean moved;
		protected ImageIcon icon;
		
		
		
		/** A basic constructor for the Piece subclasses
		 * @param _occupying The Square that the Piece occupies
		 * @param _color The color of the piece, as a String
		 */
		public Piece(Square _occupying, String _color) {
			this.setOccupying(_occupying);
			this.setColor(_color);
			this.moved = false;
		}

		/** A copy constructor
		 * @param copy The Piece copy to be made
		 */
		public Piece(Piece copy) {
			this.setColor(copy.color);
			this.setMoved(copy.moved);
			this.setOccupying(copy.occupying);
		}
		
		/**
		 * @return an abstract function that returns an ArrayList of Points holding the possible moves of a Piece
		 */
		public abstract List<Point> getPossibleMoves();
		
		
		
		public List<Point> getFilteredMoves() {
			List<Point> moves = this.getPossibleMoves();
			
			List<Point> forRemoval = new ArrayList<Point>();
			
			for(Point p : moves) {
				if(getOccupying().getBoard().testSelfCheck(this.getOccupying(), this.getOccupying().getBoard().getSquare(p)) == true) {
					forRemoval.add(p);
				}
			}
			for (Point p : forRemoval){
                moves.remove(p);
			}
			return moves;
		}
		
		
		
		/** Getter function for a Piece's color
		 * @return the color of a Piece
		 */
		public String getColor() {
			return color;
		}

		/** Setter function for a Piece's color
		 * @param color the color to give the Piece
		 */
		public void setColor(String color) {
			this.color = color;
		}

		/** Getter function for a Piece's Square
		 * @return the Square the Piece occupies
		 */
		public Square getOccupying() {
			return occupying;
		}

		/** Setter function for a Piece's Square
		 * @param occupying Sets the Square that the Piece occupies
		 */
		public void setOccupying(Square occupying) {
			this.occupying = occupying;
		}

		/** Getter function for a Piece's first moved status
		 * @return True if the piece has been moved before, false if not
		 */
		public boolean isMoved() {
			return moved;
		}

		/** Setter for the Piece's moved variable
		 * @param moved Modifies the moved value
		 */
		public void setMoved(boolean moved) {
			this.moved = moved;
		}
		
		public ImageIcon getIcon() {
			return icon;
		}

		public void setIcon(ImageIcon icon) {
			this.icon = icon;
		}

		protected void getVertDown(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.y--;
					
					while(moveIterator.y >= 0) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() != null) {
							break;
						}
						moveIterator.y--;
					}
				}

		protected void getVertUp(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					
					moveIterator.y++;
					while(moveIterator.y <= 7) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() != null) {
							break;
						}
						moveIterator.y++;
					}
				}

		protected void getHorizLeft(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					
					moveIterator.x--;
					while(moveIterator.x >= 0) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() != null) {
							break;
						}
						moveIterator.x--;
					}
				}

		protected void getHorizRight(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.x++;
					while(moveIterator.x <= 7) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() != null) {
							break;
						}
						moveIterator.x++;
					}
				}

		protected void getDiagDownLeft(List<Point> moves, Point moveIterator,
				int startx, int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.x--;
					moveIterator.y--;
					while(moveIterator.x >= 0 && moveIterator.y >= 0) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator).getOccupier() != null) {
							break;
						}
						
						moveIterator.x--;
						moveIterator.y--;
					}
				}

		protected void getDiagUpLeft(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.x--;
					moveIterator.y++;
					while(moveIterator.x >= 0 && moveIterator.y <= 7) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
				
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator).getOccupier() != null) {
							break;
						}
						
						moveIterator.x--;
						moveIterator.y++;
					}
				}

		protected void getDiagDownRight(List<Point> moves, Point moveIterator,
				int startx, int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.x++;
					moveIterator.y--;
					while(moveIterator.x <= 7 && moveIterator.y >= 0) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator).getOccupier() != null) {
							break;
						}
						
						moveIterator.x++;
						moveIterator.y--;
					}
				}

		protected void getDiagUpRight(List<Point> moves, Point moveIterator, int startx,
				int starty) {
					moveIterator.x = startx;
					moveIterator.y = starty;
					moveIterator.x++;
					moveIterator.y++;
					while(moveIterator.x <= 7 && moveIterator.y <= 7) {
						if(occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier() == null ||
								occupying.getBoard().getSquare(moveIterator.x, moveIterator.y).getOccupier().getColor() != getColor()) {
							moves.add(new Point(moveIterator.x, moveIterator.y));
						}
						if(occupying.getBoard().getSquare(moveIterator).getOccupier() != null) {
							break;
						}
						
						moveIterator.x++;
						moveIterator.y++;
					}
				}

		
}
