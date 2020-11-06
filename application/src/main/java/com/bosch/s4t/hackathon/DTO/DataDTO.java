package com.bosch.s4t.hackathon.DTO;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataDTO {
	
	@JsonProperty("fetchTime")
	private LocalDateTime fetchTime;
	
	@JsonProperty("v")
	private String v;
	
	@JsonProperty("mid")
	private int mid;
	
	@JsonProperty("time")
	private int time;
	
	@JsonProperty("ip")
	private String ip;
	
	@JsonProperty("mac")
	private String mac;
	
	@JsonProperty("devices")
	private String devices;
	
	@JsonProperty("deviceNum")
	private int deviceNum;
	
	@JsonProperty("hex")
	private List<String> hex;
	
}
