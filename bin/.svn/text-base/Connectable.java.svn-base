import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Connectable {
	protected Game game;
	protected String color;
	protected ObjectOutputStream out;
    protected ObjectInputStream in;
	
	public Connectable() {
		this.setGame(new Game(this));
	}

	/** Writes a Packet to an initialized ObjectOutputStream
	 * @param packet the packet to be sent
	 */
	public void sendPacket(Packet packet) {
		try {
			if(out != null) {
				out.writeObject(packet);
				out.flush();
			}
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void handlePacket(Packet packet) {
	    	game.handleReceivedPacket(packet);
	 }
}
