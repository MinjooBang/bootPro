package  com.minjoo.demo.service;

import java.util.List;

import  com.minjoo.demo.domain.BoardVO;
import  com.minjoo.demo.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	public BoardVO get(long bno);
	public boolean modify(BoardVO board);
	//public List<BoardVO> getList();
	public boolean delete(long bno);
	public List<BoardVO> getList(Criteria cri) ;
	public int getTotal(Criteria cri);

}
