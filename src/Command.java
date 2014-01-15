import java.awt.Point;
import java.io.Serializable;

public class Command implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private transient Piece moved;
	private transient Piece taken;
	private Point from;
	private Point to;
	
	public Command(Piece moved, Piece taken, Point from, Point to) {
		this.setMoved(moved);
		this.setTaken(taken);
		this.setFrom(from);
		this.setTo(to);
	}
	
	public Command(Point from, Point to) {
		this.setMoved(null);
		this.setTaken(null);
		this.setFrom(from);
		this.setTo(to);
	}
	
	public Command(Command command) {
		this.setMoved(command.getMoved());
		this.setTaken(command.getTaken());
		this.setFrom(command.getFrom());
		this.setTo(command.getTo());
	}
	
	public Piece getMoved() {
		return moved;
	}
	
	public void setMoved(Piece moved) {
		this.moved = moved;
	}
	
	public Piece getTaken() {
		return taken;
	}
	
	public void setTaken(Piece taken) {
		this.taken = taken;
	}
	
	public Point getFrom() {
		return from;
	}
	
	public void setFrom(Point from) {
		this.from = from;
	}
	
	public Point getTo() {
		return to;
	}
	
	public void setTo(Point to) {
		this.to = to;
	}
}
