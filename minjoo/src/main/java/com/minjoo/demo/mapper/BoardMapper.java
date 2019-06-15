package  com.minjoo.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.minjoo.demo.domain.BoardVO;
import com.minjoo.demo.domain.Criteria;

public interface BoardMapper {
	//@Select("select * from book_ex where bno > 0") 
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	//public void insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
	
	public List<BoardVO> getListWithPaging(Criteria cri); 
	public int getTotalCount(Criteria cri);
	public void updateReplyCnt(@Param("bno") long bno,@Param("amount") int amount);
	
	
}
