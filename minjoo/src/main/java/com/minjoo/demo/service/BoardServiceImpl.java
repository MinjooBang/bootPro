package com.minjoo.demo.service;

import java.util.List;

import  com.minjoo.demo.domain.BoardVO;
import com.minjoo.demo.domain.Criteria;
import   com.minjoo.demo.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	@Override
	public boolean delete(long bno) {
		log.info("delete....."+bno);
		return mapper.delete(bno) == 1;
	}

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	
	@Override
	public void register(BoardVO board) {
		log.info("register..........."+board);
		mapper.insert(board);
		
	}
	

	@Override
	public BoardVO get(long bno) {
		
		log.info("get()......");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify.........."+board);
		
		return mapper.update(board) == 1;
	}

	/*@Override
	public List<BoardVO> getList() {
		log.info("getList()......");
		
		return mapper.getList();
	}*/


	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List paging with criteria "+cri);
		
		return mapper.getListWithPaging(cri);
	}


	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}


	

	
	

}
