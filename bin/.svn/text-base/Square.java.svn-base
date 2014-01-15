
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;


public class Square extends JButton {

	private static final long serialVersionUID = 1L;
	private Piece occupier;
	private Point position;
	private Board board;
	private boolean highlighted;
	private Color origColor;
	
	static Dimension size = new Dimension(48, 48);
	
	/** A constructor for a Square object
	 * @param _board The chess board that the Square makes up
	 * @param _position The location of the Square on the chess board
	 */
	public Square(Board _board, Point _position) {
		this.setBoard(_board);
		this.setOccupier(null);
		this.setPosition(_position);
		this.setPreferredSize(size);
		this.setHighlighted(false);
	}


	/** The getter for the Piece occupier variable
	 * @return the piece occupying the Square
	 */
	public Piece getOccupier() {
		return occupier;
	}

	/** The setter for the Piece occupier variable
	 * @param _occupier The Piece to occupy the Square
	 */
	public void setOccupier(Piece _occupier) {
		this.occupier = _occupier;
		
		if(occupier != null) {
			setIcon(occupier.getIcon());
		}
	}

	/** The getter for the Point position variable
	 * @return the point in the Square
	 */
	public Point getPosition() {
		return position;
	}

	/** The setter for the Point position variable
	 * @param _position The Point of the Square
	 */
	public void setPosition(Point _position) {
		this.position = _position;
	}

	/** The getter for the Board variable that the Square makes up
	 * @return the board that the Square makes up
	 */
	public Board getBoard() {
		return board;
	}

	/** The setter for the Board variable
	 * @param _board the Board to set
	 */
	public void setBoard(Board _board) {
		this.board = _board;
	}


	/** returns whether the Square is highlighted or not
	 * @return if the Square is highlighted or not
	 */
	public boolean isHighlighted() {
		return highlighted;
	}


	/**Sets whether the Square is highlighted or not
	 * @param highlighted sets whether the Square is highlighted or not
	 */
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}


	/** Returns the original color of the Square
	 * @return orignial color
	 */
	public Color getOrigColor() {
		return origColor;
	}


	/** Sets the orignial color of the square
	 * @param origColor the color to set as teh orignial color of the square
	 */
	public void setOrigColor(Color origColor) {
		this.origColor = origColor;
	}

}	