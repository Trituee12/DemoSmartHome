package baithi.tuentpd01983.entity;

import java.io.Serializable;
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

/**
 * @author Administrator
 *
 */
@Entity
@Table(name = "device_status")
public class DeviceStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "is_used", length = 1)
	private boolean used;

	@Column(name = "is_sms", length = 1)
	private boolean sms;

	@Column(name = "is_call", length = 1)
	private boolean call;

	@Column(name = "output1")
	private Integer outPut1;

	@Column(name = "output2")
	private Integer outPut2;

	@Column(name = "is_loa", length = 1)
	private boolean loa;

	@OneToMany(mappedBy = "deviceStatus")
	private Set<HistoryStatus> historyStatus;
	

	@JsonBackReference("device_status")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "device_id", referencedColumnName = "device_id")
	private Device devices;

	public DeviceStatus(boolean used, boolean sms, boolean call, Integer outPut1, Integer outPut2, boolean loa,
			Device devices) {
		super();
		this.used = used;
		this.sms = sms;
		this.call = call;
		this.outPut1 = outPut1;
		this.outPut2 = outPut2;
		this.loa = loa;
		this.devices = devices;
	}

	public DeviceStatus() {
		super();
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public boolean isSms() {
		return sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}

	public boolean isCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}

	public Integer getOutPut1() {
		return outPut1;
	}

	public void setOutPut1(Integer outPut1) {
		this.outPut1 = outPut1;
	}

	public Integer getOutPut2() {
		return outPut2;
	}

	public void setOutPut2(Integer outPut2) {
		this.outPut2 = outPut2;
	}

	public boolean isLoa() {
		return loa;
	}

	public void setLoa(boolean loa) {
		this.loa = loa;
	}

	public Device getDevices() {
		return devices;
	}

	public void setDevices(Device devices) {
		this.devices = devices;
	}

	public Set<HistoryStatus> getHistoryStatus() {
		return historyStatus;
	}

	public void setHistoryStatus(Set<HistoryStatus> historyStatus) {
		this.historyStatus = historyStatus;
	}

	
}
