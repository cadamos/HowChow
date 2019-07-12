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
@Table(name = "Reviews")
public class Review implements Comparable<Review> {

	@Id
	@Column(name = "r_id")
	@SequenceGenerator(sequenceName = "review_seq", name = "rev_seq")
	@GeneratedValue(generator = "rev_seq", strategy = GenerationType.SEQUENCE)
	private int r_id;
	@ManyToOne
	@JoinColumn(name = "r_user")
	private User user;
	@Column(name = "r_rating")
	private int rating;
	@Column(name = "r_comment")
	private String comment;
	@Column(name = "r_userRating")
	private int userRating = 0;
	@Column(name = "r_date")
	@Temporal(TemporalType.DATE)
	private Date r_date = new Date();


	public Review() {
		super();
	}


	public Review(User user, int rating, String comment) {
		super();
		this.user = user;
		this.rating = rating;
		this.comment = comment;
	}
	
	

	public Review(int r_id, User user, int rating, String comment, int userRating, Date date) {
		super();
		this.r_id = r_id;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
		this.userRating = userRating;
		this.r_date = date;
	}



	@Override
	public String toString() {
		return "Review [r_id=" + r_id + ", user=" + user + ", rating=" + rating + ", comment=" + comment
				+ ", userRating=" + userRating + ", date=" + r_date + "]";
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return r_date;
	}

	@Override
	public int compareTo(Review r) {
		if (this.getUserRating() > r.getUserRating())
			return 1;
		else if (this.getUserRating() == r.getUserRating())
			return 0;
		else
			return -1;
	}

}
