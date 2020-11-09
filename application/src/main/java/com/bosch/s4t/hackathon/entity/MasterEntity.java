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
@Table(name="master")
@Data
@NoArgsConstructor
public class MasterEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="masterseq")
	@SequenceGenerator(name="masterseq", sequenceName="seq_master", initialValue=1, allocationSize=1)
	private Long id;
	
	private int iNum;

	private String iMac;
	
	private int iCircle;
	
	private int iCenter;
	
	private int sNum;
	
	private int sCircle;
	
	private int sCenter;

	public int getINum() {
		return this.iNum;
	}
	public void setINum(int iNum) {
		this.iNum = iNum;
	}
	
	public String getIMac() {
		return this.iMac;
	}
	public void setIMac(String iMac) {
		this.iMac = iMac;
	}
	
	public int getICircle() {
		return this.iCircle;
	}
	public void setICircle(int iCircle) {
		this.iCircle = iCircle;
	}
	
	public int getICenter() {
		return this.iCenter;
	}
	public void setICenter(int iCenter) {
		this.iCenter = iCenter;
	}
	
	public int getSNum() {
		return this.sNum;
	}
	public void setSNum(int sNum) {
		this.sNum = sNum;
	}
	
	public int getSCircle() {
		return this.sCircle;
	}
	public void setSCircle(int sCircle) {
		this.sCircle = sCircle;
	}
	
	public int getSCenter() {
		return this.sCenter;
	}
	public void setSCenter(int sCenter) {
		this.sCenter = sCenter;
	}
}