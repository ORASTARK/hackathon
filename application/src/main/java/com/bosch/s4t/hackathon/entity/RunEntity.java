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
@Table(name="kpi")
@Data
@NoArgsConstructor
public class RunEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="kpiseq")
	@SequenceGenerator(name="kpiseq", sequenceName="seq_kpi", initialValue=1, allocationSize=1)
	private Long id;
	
	private int num;
	
	private LocalDateTime shiftTime;
	
	private LocalDateTime t1;
	
	private LocalDateTime t1Start;
	
	private LocalDateTime t1End;
	
	private LocalDateTime t1Hold;
	
	private LocalDateTime t2;
	
	private LocalDateTime t2Start;
	
	private LocalDateTime t2End;
	
	private LocalDateTime t2Hold;
	
	private LocalDateTime t3;
	
	private LocalDateTime t3Start;
	
	private LocalDateTime t3End;
	
	private LocalDateTime t3Hold;
	
	private LocalDateTime t4;
	
	private LocalDateTime t4Start;
	
	private LocalDateTime t4End;
	
	private LocalDateTime t4Hold;
	
	private LocalDateTime tRun;
	
	private LocalDateTime t1t2;
	
	private LocalDateTime t1t3;
	
	private LocalDateTime t1t4;
	
/*	
	
	
	

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
*/	

}