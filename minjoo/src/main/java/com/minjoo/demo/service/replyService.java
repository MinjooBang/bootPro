package com.minjoo.demo.service;

import java.util.List;

import com.minjoo.demo.domain.Criteria;
import com.minjoo.demo.domain.ReplyVo;
import com.minjoo.demo.mapper.BoardMapper;
import com.minjoo.demo.mapper.replyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class replyService {
	
	@Setter(onMethod_ =@Autowired )
	private replyMapper mapper;
	@Setter(onMethod_ =@Autowired )
	private BoardMapper boardmapper;
	
	@Transactional
	public int register(ReplyVo vo) {
		log.info("댓글 등록 .. "+vo);
		boardmapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}
	
	public ReplyVo get(Long bno) {
		log.info("get!---"+bno);
		
		return mapper.read(bno);

	}
	public int modify(ReplyVo vo) {
		log.info("modify--"+vo);
		return mapper.update(vo);
	}
	
	public int remove(Long rno) {
		log.info("delete...");
		return mapper.delete(rno);
	}
	
	public List<ReplyVo> getList(Criteria cri,Long bno){
		log.info("list & paging");
		//log.info(mapper.getListWithPaging(cri, bno));
		log.info(""+mapper.getListWithPaging(cri, bno));
		return mapper.getListWithPaging(cri, bno);
	}
	
	
}//replyService

