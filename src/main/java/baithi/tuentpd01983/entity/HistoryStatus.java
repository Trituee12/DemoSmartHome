package baithi.tuentpd01983.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="history_status")
public class HistoryStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "history_id")
	private Long historyId;
	
	@Column(name = "device_name")
	private String deviceName;
	
	
	@Column(name = "history_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private String historyDate;
	
	@ManyToOne
	@JoinColumn(name = "device_status_id")
	private DeviceStatus deviceStatus;

	@Column(name = "status_device")
	private String statusDevice;
	
	@Column(name = "is_used")
	private boolean used;
	
	
	

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	public String getStatusDevice() {
		return statusDevice;
	}

	public void setStatusDevice(String statusDevice) {
		this.statusDevice = statusDevice;
	}

	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public HistoryStatus(String deviceName, DeviceStatus deviceStatus, String statusDevice, boolean used) {
		super();
		this.deviceName = deviceName;
		this.deviceStatus = deviceStatus;
		this.statusDevice = statusDevice;
		this.used = used;
	}

	public HistoryStatus() {
		super();
	}

	

}
