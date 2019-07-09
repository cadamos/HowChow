package model;

public class User {

	private int p_id;
	private String username;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int p_id, String username, String password) {
		super();
		this.p_id = p_id;
		this.username = username;
		this.password = password;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
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

	@Override
	public String toString() {
		return "User [p_id=" + p_id + ", username=" + username + ", password=" + password + "]";
	}
	
}
