package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name="Tags")
public class Tag {
<<<<<<< HEAD
	
	
=======
>>>>>>> 58b109f08a3398e8847a8558e5ec880b9b689e49
	@Id
	@SequenceGenerator(sequenceName="tag_seq", name="t_seq")
	@GeneratedValue(generator="t_seq",strategy=GenerationType.SEQUENCE)
	@Column(name="t_id")
	private int t_id;
	
	
	@Column(name="t_name", nullable=false, unique=true)
	private String t_name;
	
	public Tag(int t_id, String t_name) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
	}

	public Tag(String t_name) {
		super();
		this.t_name = t_name;
	}

	public Tag() {
		super();
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	@Override
	public String toString() {
		return "Tag [t_id=" + t_id + ", t_name=" + t_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t_name == null) ? 0 : t_name.hashCode());
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
		Tag other = (Tag) obj;
		if (t_name == null) {
			if (other.t_name != null)
				return false;
		} else if (!t_name.equals(other.t_name))
			return false;
		return true;
	}
	
	
	

}
