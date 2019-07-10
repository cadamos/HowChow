package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Reviews")
public class Review implements Comparable<Review>{

	@Id
	@Column(name="r_id")
	@SequenceGenerator(sequenceName="review_seq", name="rev_seq")
	@GeneratedValue(generator="rev_seq", strategy=GenerationType.SEQUENCE)
	private int r_id;
	@ManyToOne
	@JoinColumn(name="u_id")
	private User user;
	@ManyToOne 
	@JoinColumn(name="d_id")
	private Dish dish;
	@Column(name="rating")
	private int rating;
	@Column(name="userRating")
	private int userRating;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
    private Date date = new Date();
	
	
	
	
	
	public Review(User user, Dish dish, int rating) {
		super();
		this.user = user;
		this.dish = dish;
		this.rating = rating;
	}
	
	public Review(int r_id, User user, Dish dish, int rating, int userRating, Date date) {
		super();
		this.r_id = r_id;
		this.user = user;
		this.dish = dish;
		this.rating = rating;
		this.userRating = userRating;
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUserRating() {
		return userRating;
	}
	public void upUserRating() {
		this.userRating++;
	}
	public void downUserRating() {
		this.userRating--;
	}
	public Date getDate() {
		return date;
	}
	



	@Override
	public int compareTo(Review r) {
		if(this.getUserRating()>r.getUserRating())
			return 1;
		else if(this.getUserRating()==r.getUserRating())
			return 0;
		else
			return -1;
	}
	
}
