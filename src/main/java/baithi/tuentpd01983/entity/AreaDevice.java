package baithi.tuentpd01983.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "area_device")
public class AreaDevice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@JsonBackReference("area_device")
	@ManyToOne( cascade=CascadeType.PERSIST)
	@JoinColumn(name = "area_id")
	private Area areas;
	
	@JsonBackReference("area_device")
	@OneToMany(mappedBy = "areaDevices")
	private Set<Device> devices;
	

	@Column(name = "mo_start")
	private String moStart;

	@Column(name = "mo_end")
	private String moEnd;
	

	@Column(name = "wed_start")
	private String wedStart;

	
	@Column(name = "wed_end")
	private String wedEnd;


	@Column(name = "tue_start")
	private String tueStart;

	@Column(name = "tue_end")
	private String tueEnd;

	@Column(name = "thur_start")
	private String thurStart;
	
	@Column(name = "thur_end")
	private String thurEnd;
	
	@Column(name = "fri_start")
	private String friStart;

	@Column(name = "fri_end")
	private String friEnd;

	@Column(name = "sta_start")
	private String staStart;

	@Column(name = "sta_end")
	private String staEnd;

	@Column(name = "sun_start")
	private String sunStart;
	
	@Column(name = "sun_end")
	private String sunEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Area getAreas() {
		return areas;
	}

	public void setAreas(Area areas) {
		this.areas = areas;
	}


	public String getMoStart() {
		return moStart;
	}

	public void setMoStart(String moStart) {
		this.moStart = moStart;
	}

	public String getMoEnd() {
		return moEnd;
	}

	public void setMoEnd(String moEnd) {
		this.moEnd = moEnd;
	}

	public String getWedStart() {
		return wedStart;
	}

	public void setWedStart(String wedStart) {
		this.wedStart = wedStart;
	}

	public String getWedEnd() {
		return wedEnd;
	}

	public void setWedEnd(String wedEnd) {
		this.wedEnd = wedEnd;
	}

	public String getTueStart() {
		return tueStart;
	}

	public void setTueStart(String tueStart) {
		this.tueStart = tueStart;
	}

	public String getTueEnd() {
		return tueEnd;
	}

	public void setTueEnd(String tueEnd) {
		this.tueEnd = tueEnd;
	}

	public String getThurStart() {
		return thurStart;
	}

	public void setThurStart(String thurStart) {
		this.thurStart = thurStart;
	}

	public String getThurEnd() {
		return thurEnd;
	}

	public void setThurEnd(String thurEnd) {
		this.thurEnd = thurEnd;
	}

	public String getFriStart() {
		return friStart;
	}

	public void setFriStart(String friStart) {
		this.friStart = friStart;
	}

	public String getFriEnd() {
		return friEnd;
	}

	public void setFriEnd(String friEnd) {
		this.friEnd = friEnd;
	}

	public String getStaStart() {
		return staStart;
	}

	public void setStaStart(String staStart) {
		this.staStart = staStart;
	}

	public String getStaEnd() {
		return staEnd;
	}

	public void setStaEnd(String staEnd) {
		this.staEnd = staEnd;
	}

	public String getSunStart() {
		return sunStart;
	}

	public void setSunStart(String sunStart) {
		this.sunStart = sunStart;
	}

	public String getSunEnd() {
		return sunEnd;
	}

	public void setSunEnd(String sunEnd) {
		this.sunEnd = sunEnd;
	}

	public AreaDevice() {
		super();
	}

	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}


	public AreaDevice(Area areas,  String moStart, String moEnd, String wedStart, String wedEnd,
			String tueStart, String tueEnd, String thurStart, String thurEnd, String friStart, String friEnd, String staStart,
			String staEnd, String sunStart, String sunEnd) {
		super();
		this.areas = areas;
		this.moStart = moStart;
		this.moEnd = moEnd;
		this.wedStart = wedStart;
		this.wedEnd = wedEnd;
		this.tueStart = tueStart;
		this.tueEnd = tueEnd;
		this.thurStart = thurStart;
		this.thurEnd = thurEnd;
		this.friStart = friStart;
		this.friEnd = friEnd;
		this.staStart = staStart;
		this.staEnd = staEnd;
		this.sunStart = sunStart;
		this.sunEnd = sunEnd;
	}

	public AreaDevice(Area areas) {
		super();
		this.areas = areas;
	}

	public AreaDevice(Long id) {
		super();
		this.id = id;
	}

	

}
