package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import service.UserService;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="u_id")
	@SequenceGenerator(sequenceName="user_seq", name="u_seq")
	@GeneratedValue(generator="u_seq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="u_name", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	@Override
	public boolean equals(Object o) {

        if (o == this) {
        	return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        return user.username.equals(username) &&
                user.password == password;
    }
	
	public boolean login(String username, String password) {
		List<User> users = UserService.selectAllUsers();
		for (User u : users) {
			if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public User register(String username, String password) {
		User u = null;
		if (!login(username, password)) {
			u = new User(username, password);
		}
		return u;
	}
}
