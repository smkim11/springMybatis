package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper; // 인터페이스 형태로 의존성 주입 -> 디커플링
	
	public List<Board> selectBoardList(Page p){
		return boardMapper.selectBoardListByPage(p);
	}
	
	public int totalCount(Page p) {
		return boardMapper.totalCount(p);
	}
	
	public Board selectBoardOne(Board b) {
		return boardMapper.selectBoardOne(b);
	}
	
	public int insertBoard(Board b) {
		return boardMapper.insertBoard(b);
	}
	
	public int updateBoard(Board b) {
		return boardMapper.updateBoard(b);
	}
	
	public int deleteBoard(Board b) {
		return boardMapper.deleteBoardByKey(b);
	}
}
