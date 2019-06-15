package com.minjoo.demo.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	@Insert("INSERT INTO TBL_SAMPLE1 (COL1) VALUES (#{data})")
	public int insertColl(String data);

}
