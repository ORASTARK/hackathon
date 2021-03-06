package com.bosch.s4t.hackathon;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.s4t.hackathon.repository.CurrentRepository;
import com.bosch.s4t.hackathon.repository.DataRepository;
import com.bosch.s4t.hackathon.repository.MasterRepository;
import com.bosch.s4t.hackathon.DTO.DataDTO;
import com.bosch.s4t.hackathon.entity.CurrentEntity;
import com.bosch.s4t.hackathon.entity.DataEntity;
import com.bosch.s4t.hackathon.entity.MasterEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(urlPatterns="/myservlet")
public class MyServlet extends HttpServlet {
	
	@Autowired
	public DataRepository dataRepo;
	
	@Autowired
	public CurrentRepository currentRepo;
	
	@Autowired
	public MasterRepository masterRepo;
	
	private static final long serialVersionUID = -8685285401859800066L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doGet2()<<<<<<<<<<<");
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>>>>>>> Collecting data <<<<<<<<<<<");
		
		InputStream in = request.getInputStream();
		MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(in);
		int maplen = unpacker.unpackMapHeader();
		
		

		LocalDateTime fetchTime = LocalDateTime.now();
		System.out.println("fetchTime:"+ fetchTime);
		
		System.out.println("key:"+ unpacker.unpackString());

        System.out.println("value:"+ unpacker.unpackString());

        System.out.println("key:"+ unpacker.unpackString());

        System.out.println("value:"+ unpacker.unpackInt());

        System.out.println("key:"+ unpacker.unpackString());

        System.out.println("value:"+ unpacker.unpackInt());

        System.out.println("key:"+ unpacker.unpackString());

        System.out.println("value:"+ unpacker.unpackString());

        System.out.println("key:"+ unpacker.unpackString());

        System.out.println("value:"+ unpacker.unpackString());

        System.out.println("key:"+ unpacker.unpackString());

        int arrHeader = unpacker.unpackArrayHeader();

        System.out.println("value BinaryHeader:"+ arrHeader);
        
        List<DataEntity> dataEntityList = new ArrayList<DataEntity>();
		
		String[] macData = new String[arrHeader];
		int[] rssiData = new int[arrHeader];
		int rssiMin = 0;
		String macMin = null; 
		for(int i = 0; i < arrHeader; i++) {
			int binaryHeader = unpacker.unpackBinaryHeader();
			byte[] bytes = new byte[binaryHeader];
			unpacker.readPayload(bytes);
			
			String hexString=bytes2HexStr(bytes);
			System.out.println("bytes hexString:"+ hexString);
			
			macData[i] = hexString.substring(2, 14);
			String rssiHex = hexString.substring(14,16);
			System.out.println("macData["+ i + "]: " + macData[i]);
			System.out.println("rssiHex:" + i + ": " + rssiHex);
			
			rssiData[i]= 255 - Integer.parseInt(rssiHex,16);  	
			System.out.println("rssiData[" + i + "]: " + rssiData[i]);	
			
			if(i==0) {
				rssiMin = rssiData[0];
				macMin = macData[0];
			}
			if ("EAC5B7C514F1".equals(macData[i]) || "E908C024BF5B".equals(macData[i]) || "DDF2BE0886E0".equals(macData[i]) || "E3B3C49220E7".equals(macData[i])) {
				if (rssiData[i]<rssiMin) {
					rssiMin = rssiData[i];
					macMin = macData[i];
				}
			}
			DataEntity dataEntity = new DataEntity();
			dataEntity.setFetchTime(fetchTime);
			dataEntity.setRssi(rssiData[i]);
			dataEntity.setSentMac(macData[i]);
			dataEntityList.add(dataEntity);
		}
		
		
		int totalRssi = 0;
		int countRssi = 0;
		for(int i=0;i<arrHeader;i++) {
			if(dataEntityList.get(i).getSentMac().equals(macMin)) {
				totalRssi += dataEntityList.get(i).getRssi();
				countRssi += 1;
			}
		}
		int rssiavg = totalRssi / countRssi;
		
		//1-1, 2-9,3-11,4-6
		List<MasterEntity> masterEntityList = masterRepo.findAllByIMac(macMin);
		MasterEntity currentMasterEntity = masterEntityList.get(0);
		int currentSNum = 0;
		//int currentRssi = currentMasterEntity.getICircle();
		int checkSNum = currentMasterEntity.getSNum();
		if(checkSNum !=0) {
			if(rssiavg<50) {
				currentSNum = currentMasterEntity.getSNum();
			}else {
				currentSNum = 0;
			}
		}else {
			currentSNum = 0;
		}
		
		
		List<CurrentEntity> currentEntityList = new ArrayList<CurrentEntity>();
		CurrentEntity currentEntity = new CurrentEntity();
		currentEntity.setNum(currentSNum);
		currentEntity.setFetchTime(fetchTime);
		currentEntityList.add(currentEntity);
	
		dataRepo.saveAll(dataEntityList);
		currentRepo.saveAll(currentEntityList);		
		System.out.println("---------------------------------");
		unpacker.close();
	}
	
	public static String bytes2HexStr(byte[] byteArray) {
		if (byteArray == null) {
			return null;
		}
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[byteArray.length * 2];
		for (int j = 0; j < byteArray.length; j++) {
			int v = byteArray[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
	    
}