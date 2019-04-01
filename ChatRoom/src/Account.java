
public class Account {
	private int ID;
	private String username;
	private String password;

	public Account() {
	}

	public Account(int iD, String password) {
		super();
		ID = iD;
		this.password = password;
	}

	public Account(int iD, String username, String password) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
