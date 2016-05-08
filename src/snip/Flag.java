package snip;

public class Flag {
	
	private boolean status;
	public Flag (boolean b) {
		this.setStatus(b);
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
