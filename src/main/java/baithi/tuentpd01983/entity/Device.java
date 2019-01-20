package baithi.tuentpd01983.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "device")
public class Device implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "device_id")
	private Long deviceId;
	
	@Column(name = "device_name")
	private String deviceName;
	
	@JsonBackReference("device")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
    private AreaDevice areaDevices ;

	@JsonBackReference("device")
	@OneToMany(mappedBy = "devices")
	private List<DeviceStatus> deviceStatus;
	


	public Long getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}


	public String getDeviceName() {
		return deviceName;
	}


	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}


	public List<DeviceStatus> getDeviceStatus() {
		return deviceStatus;
	}


	public void setDeviceStatus(List<DeviceStatus> deviceStatus) {
		this.deviceStatus = deviceStatus;
	}


	public Device() {
		super();
	}


	public AreaDevice getAreaDevices() {
		return areaDevices;
	}


	public void setAreaDevices(AreaDevice areaDevices) {
		this.areaDevices = areaDevices;
	}


	public Device(String deviceName, AreaDevice areaDevices) {
		super();
		this.deviceName = deviceName;
		this.areaDevices = areaDevices;
	}


	public Device(Long deviceId, String deviceName, AreaDevice areaDevices) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.areaDevices = areaDevices;
	}
	


}
