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
	
	
	

}
