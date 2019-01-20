package baithi.tuentpd01983.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "area")
public class Area implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "area_id")
	private Long areaId;

	@Column(name = "area_name", length = 255)
	private String areaName;

	@Column(name = "area_note", length = 255)
	private String areaNote;

	@JsonBackReference("area")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User users;

	@JsonBackReference("area")
	@OneToMany(mappedBy = "areas")
	private Set<AreaDevice> areaDevices;
	
	
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}


	public String getAreaNote() {
		return areaNote;
	}

	public void setAreaNote(String areaNote) {
		this.areaNote = areaNote;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}


	public Area() {

	}

	public Area( String areaName, String areaNote, User users) {
		super();
		this.areaName = areaName;
		this.areaNote = areaNote;
		this.users = users;
	}

	public Set<AreaDevice> getAreaDevices() {
		return areaDevices;
	}

	public void setAreaDevices(Set<AreaDevice> areaDevices) {
		this.areaDevices = areaDevices;
	}

	public Area(Long areaId) {
		super();
		this.areaId = areaId;
	}

	

	
}
