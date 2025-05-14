package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

public interface IBoardService {
	List<Board> selectBoardList(Page p);
	int totalCount(Page p);
	Board selectBoardOne(Board b);
	int insertBoard(Board b);
	int updateBoard(Board b);
	int deleteBoard(Board b);
}
