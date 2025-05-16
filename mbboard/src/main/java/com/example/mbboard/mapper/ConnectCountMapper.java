package com.example.mbboard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.ConnectCount;

@Mapper
public interface ConnectCountMapper {
	Map<String,Integer> selectConnectCountAll();
	Map<String,Integer> selectConnectCountToday();
	
	// 오늘날짜에 카운팅이 있는지 없는지
	String selectConnectDateBykey(ConnectCount cc); // cc.getMemberRole()
	
	// selectConnectDateBykey의 반환값이 없다면 
	int insertConnectCount(ConnectCount cc);
	
	// selectConnectDateBykey의 반환값이 있다면 
	int updateConnectCount(ConnectCount cc);
}
