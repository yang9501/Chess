import java.io.Serializable;


public class Packet implements Serializable {

	private static final long serialVersionUID = 1L;
	private Command com;
	private boolean restart;
	private boolean restartConfirm;
	private boolean forfeit;
	private boolean undo;
	private boolean exit;
	private boolean customRestart;
	private boolean customRestartConfirm;
	
	public Packet() {
		setCom(null);
		setRestart(false);
		setRestartConfirm(false);
		setForfeit(false);
		setUndo(false);
		setExit(false);
		setCustomRestart(false);
		setCustomRestartConfirm(false);
	}
	
	public Packet(Command command, boolean restart, boolean restartConfirm, boolean forfeit, boolean undo, boolean exit, boolean customRestart, boolean customRestartConfirm) {
		this.setCom(command);
		this.setRestart(restart);
		this.setRestartConfirm(restartConfirm);
		this.setForfeit(forfeit);
		this.setUndo(undo);
		this.setExit(exit);
		this.setCustomRestart(customRestart);
		this.setCustomRestartConfirm(customRestartConfirm);
	}

	public Command getCom() {
		return com;
	}

	public void setCom(Command com) {
		this.com = com;
	}

	public boolean isRestart() {
		return restart;
	}

	public void setRestart(boolean restart) {
		this.restart = restart;
	}

	public boolean isForfeit() {
		return forfeit;
	}

	public void setForfeit(boolean forfeit) {
		this.forfeit = forfeit;
	}

	public boolean isUndo() {
		return undo;
	}

	public void setUndo(boolean undo) {
		this.undo = undo;
	}

	public boolean isRestartConfirm() {
		return restartConfirm;
	}

	public void setRestartConfirm(boolean restartConfirm) {
		this.restartConfirm = restartConfirm;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public boolean isCustomRestart() {
		return customRestart;
	}

	public void setCustomRestart(boolean customRestart) {
		this.customRestart = customRestart;
	}

	public boolean isCustomRestartConfirm() {
		return customRestartConfirm;
	}

	public void setCustomRestartConfirm(boolean customRestartConfirm) {
		this.customRestartConfirm = customRestartConfirm;
	}
}
