

public class Game{
	private Model model;
	private View view;
	private Controller controller;
	private Connectable connectable;
	
	public Game() {
		model = new Model();
		view = new View(model.getBoard(), this, "null");
		setController(new Controller(model, view, this));
	}
	
	public Game(Connectable connectable) {
		model = new Model();
		setConnectable(connectable);
		if(connectable.getClass() == Server.class) {
			view = new View(model.getBoard(), this, "white");
		}
		if(connectable.getClass() == Client.class) {
			view = new View(model.getBoard(), this, "black");
		}
		setController(new Controller(model, view, this));
		
	}
	
	/** Creates a Packet based on the parameters and sends it by calling connectable.sendPacket
	 * @param command  Command, could be null
	 * @param restart  true if one player wishes to restart
	 * @param restartConfirm  true if both parties wish to restart the game
	 * @param forfeit	true if a player wants to forfeit
	 * @param undo	true if a player wants to undo
	 * @param exit	true if a player exits the game
	 */
	public void sendPacket(Command command, boolean restart, boolean restartConfirm, boolean forfeit, boolean undo, boolean exit, boolean customRestart, boolean customRestartConfirm) {
		connectable.sendPacket(new Packet(command, restart, restartConfirm, forfeit, undo, exit, customRestart, customRestartConfirm));
	}
	
	/** Performs various actions using the Controller based on the contents of a Packet
	 * @param packet the packet in question
	 */
	public void handleReceivedPacket(Packet packet) {
		if(packet.getCom() != null) { 
			//use controller move to update the board
			controller.move(packet.getCom().getFrom(), packet.getCom().getTo());
		}
		if(packet.isRestart() == true) {
			if(packet.isRestartConfirm() == true) {
				//this occurs from the origin of the restart request,  only after the askee sends back an affirmative reply, then restart the game
				controller.resetBoard();
				return;
			}
			//ask the user if you want to restart
			boolean restarted = view.promptRestart();
			if(restarted == true) {
				sendPacket(null, true, true, false, false, false, false, false);
				controller.resetBoard();
			}
		}
		if(packet.isForfeit() == true) {
			//forfeit
			if(view.getCurrTurn() == "white") {
				view.incrementBlackScore();
			}
			if(view.getCurrTurn() == "black") {
				view.incrementWhiteScore();
			}
			getController().resetBoard();
		}
		if(packet.isUndo() == true) {
			//call undo
			model.undo();
			controller.switchTurns();
		}
		if(packet.isExit() == true) {
			//call close
			view.opponentQuit();
			view.close();
		}
		if(packet.isCustomRestart() == true) {
			if(packet.isCustomRestartConfirm() == true) {
				//this occurs from the origin of the restart request,  only after the askee sends back an affirmative reply, then restart the game
				controller.resetCustomBoard();
				return;
			}
			//ask the user if you want to restart
			boolean restartedCustom = view.promptRestartCustom();
			if(restartedCustom == true) {
				sendPacket(null, false, false, false, false, false, true, true);
				controller.resetCustomBoard();
			}
		}
	}
	
	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Connectable getConnectable() {
		return connectable;
	}

	public void setConnectable(Connectable connectable) {
		this.connectable = connectable;
	}

	
}
