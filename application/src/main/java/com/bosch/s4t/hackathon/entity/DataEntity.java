package com.bosch.s4t.hackathon.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="data")
@Data
@NoArgsConstructor
public class DataEntity {
	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dataseq")
	@SequenceGenerator(name="dataseq", sequenceName="seq_data", initialValue=1, allocationSize=1)
	private Long id;
	
	private String sentMac;
	
	private int rssi; 
	
	private LocalDateTime fetchTime;
	
	public String getSentMac() {
		return this.sentMac;
	}
	public void setSentMac(String sentMac) {
		this.sentMac = sentMac;
	}
	
	public int getRssi() {
		return this.rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	
	public LocalDateTime fetchTime() {
		return this.fetchTime;
	}
	public void setFetchTime(LocalDateTime fetchTime) {
		this.fetchTime = fetchTime;
	}
	
/*
	private String v;
	
	private int mid;
	
	private int time;
	
	private String ip;
	
	private String mac;
	
	private int devices;
	
	private List<String> hex;
	
	
	
	public String getV() {
		return this.v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
	public int getMid() {
		return this.mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	public int getTime() {
		return this.time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getMac() {
		return this.mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public int getDevices() {
		return this.devices;
	}
	public void setDevices(int devices) {
		this.devices = devices;
	}
	
	public List<String> getHex() {
		return this.hex;
	}
	public void setHex(List<String> hex) {
		this.hex = hex;
	}
	
	public LocalDateTime fetchTime() {
		return this.fetchTime;
	}
	public void setFetchTime(LocalDateTime fetchTime) {
		this.fetchTime = fetchTime;
	}
*/
	
}