package model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="DISHES")
public class Dish {
	
	@Id
	@Column(name="d_id")
	@SequenceGenerator(sequenceName="dish_seq", name="dish_seq")
	@GeneratedValue(generator="dish_seq", strategy=GenerationType.SEQUENCE)
	private int d_id;
	
	// URL for the image should be stored here.
	@Column(name="d_img")
	private String img;
	
	@Column(name="d_name")
	private String name;
	
	@Column(name="d_desc")
	private String description;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="dish_tag",
			   joinColumns = @JoinColumn(name="d_id"),
			   inverseJoinColumns = @JoinColumn(name="t_id"))
	private Set<Tag> tagsAssoc;
	
	private List<Review> reviewsAssoc;
	
	@Column(name="d_rating")
	private float ratingAvg;
	
	@Column(name="d_restaurant")
	private String restaurant;

	public Dish() {
		super();
	}

	public Dish(String img, String name, String description, Set<Tag> tagsAssoc, String restaurant) {
		super();
		this.img = img;
		this.name = name;
		this.description = description;
		this.tagsAssoc = tagsAssoc;
		this.restaurant = restaurant;
	}

	public Dish(int d_id, String img, String name, String description, Set<Tag> tagsAssoc, String restaurant) {
		super();
		this.d_id = d_id;
		this.img = img;
		this.name = name;
		this.description = description;
		this.tagsAssoc = tagsAssoc;
		this.restaurant = restaurant;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tag> getTagsAssoc() {
		return tagsAssoc;
	}

	public void setTagsAssoc(Set<Tag> tagsAssoc) {
		this.tagsAssoc = tagsAssoc;
	}

	public List<Review> getReviewsAssoc() {
		return reviewsAssoc;
	}

	public void setReviewsAssoc(List<Review> reviewsAssoc) {
		this.reviewsAssoc = reviewsAssoc;
	}

	public int getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(int ratingAvg) {
		this.ratingAvg = ratingAvg;
	}
	
	// This is a secondary method of setting the rating average; it is based on the current review list. This can be safely called upon object creation, or upon
	// a new review for the dish.
	
	public void setRatingAvg() {
		if (this.reviewsAssoc == null) {
			this.ratingAvg = 0;
		} else {
			float count = 0;
			float amt = 0;
			for (Review r: this.reviewsAssoc) {
				amt += r.rating;
				count += 1;
			}
			this.ratingAvg = amt/count;
		}
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + d_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(ratingAvg);
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (d_id != other.d_id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(ratingAvg) != Float.floatToIntBits(other.ratingAvg))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dish [d_id=" + d_id + ", img=" + img + ", name=" + name + ", description=" + description
				+ ", ratingAvg=" + ratingAvg + ", restaurant=" + restaurant + "]";
	}
	
	
	
}
