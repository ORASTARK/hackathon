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
@Table(name="current")
@Data
@NoArgsConstructor
public class CurrentEntity {
	@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="currentseq")
	@SequenceGenerator(name="currentseq", sequenceName="seq_current", initialValue=1, allocationSize=1)
	private Long id;
	
	private int num; 
	
	private LocalDateTime fetchTime;
	
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public LocalDateTime fetchTime() {
		return this.fetchTime;
	}
	public void setFetchTime(LocalDateTime fetchTime) {
		this.fetchTime = fetchTime;
	}
}