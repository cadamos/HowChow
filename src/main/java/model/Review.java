package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Review implements Comparable<Review>{

	@Id
	@Column(name="r_id")
	@SequenceGenerator(sequenceName="review_seq", name="rev_seq")
	@GeneratedValue(generator="rev_seq", strategy=GenerationType.SEQUENCE)
	private int r_id;
	@OneToMany
	@JoinColumn(name="p_id")
	private int p_id;
	@ManyToOne
	@JoinColumn(name="d_id")
	private int d_id;
	@Column(name="rating")
	private int rating;
	@Column(name="userRating")
	private int userRating;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
    private Date date = new Date();
	
	
	
	public Review(int p_id, int d_id, int rating, int userRating) {
		super();
		this.p_id = p_id;
		this.d_id = d_id;
		this.rating = rating;
		this.userRating = userRating;
	}
	
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getD_id() {
		return d_id;
	}
	public void setF_id(int d_id) {
		this.d_id = d_id;
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
	public String toString() {
		return "Review [r_id=" + r_id + ", p_id=" + p_id + ", d_id=" + d_id + ", rating=" + rating + ", userRating="
				+ userRating + ", date=" + date + "]";
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
