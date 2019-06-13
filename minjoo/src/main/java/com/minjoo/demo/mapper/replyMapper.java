package  com.minjoo.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.minjoo.demo.domain.Criteria;
import  com.minjoo.demo.domain.ReplyVo;
@Mapper
public interface replyMapper {
	
	public int insert(ReplyVo vo);
	public ReplyVo read(long bno);
	public int delete(long rno);
	public int update(ReplyVo vo);
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria cri,@Param("bno") Long bno);

}
